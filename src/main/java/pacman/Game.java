import java.util.ArrayList;
import javax.swing.JComponent;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
public class Game extends JComponent {

    private Pacman pacman = new Pacman(30, 30, true);
    public int x = pacman.getX();
    public int y = pacman.getY();
    public ArrayList <Position> walls;
    public Ghost ghost1;
    public int xG = ghost1.getX();
    public int yG = ghost1.getY();

    public Game() {
        walls = new ArrayList<Position>();
        walls = pacman.getWalls();
        ghost1 = new Ghost(60, 90, true);
        Thread threadGhost1 = new Thread(ghost1);
        threadGhost1.start();
    }
    public void paintComponent(Graphics g){
        drawWall(g);
        drawGhosts(g);
        ImageIcon pacmanIcon = new ImageIcon("pacmanIcon.png");
        Image pacmanImg = pacmanIcon.getImage();
        g.drawImage(pacmanImg,x,y,30,30,null);
    }
    public void drawWall(Graphics g){  
        for (int i=0;i<walls.size(); i++){
            g.setColor(Color.BLUE);
            g.drawRect(walls.get(i).getX(), walls.get(i).getY(), 30, 30);  
        }
    }
    public void drawGhosts(Graphics g){
        ImageIcon ghostIcon = new ImageIcon("images/ghost.jpg");
        Image ghostImg = ghostIcon.getImage();
        g.drawImage(ghostImg, xG, yG, 30, 30, this);
    }
    /*public void moveGhost(Ghost g){
        while(true){
            g.searchRoute();
            x = g.getX();
            y = g.getY();
            repaint();
        } 
    }*/
    public void moveRight(){
        x = pacman.right();
        y = y;
        repaint();
    }

    //Method to move pacman to left 10 pixels
    public void moveLeft(){
        x = pacman.left();
        y= y;
        repaint();
    }

    //Method to move pacman to down 10 pixels
    public void moveDown(){
        y = pacman.down();
        x= x;
        repaint();
    }

    //Method to move pacman to up 10 pixels
    public void moveUp(){
        y = pacman.up();
        x = x;
        repaint();
    }
    
}