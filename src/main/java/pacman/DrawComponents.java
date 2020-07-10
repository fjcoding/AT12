import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
public class DrawComponents extends JComponent {

    private Pacman pacman= new Pacman(30, 30, true);
    public int x = pacman.getX();
    public int y = pacman.getY();
    public ArrayList <Position> walls;
    
    public DrawComponents(){
        walls = new ArrayList<Position>();
        walls = pacman.getWalls();
    }
    
    //Method to draw pacman in the frame
    public void paintComponent(Graphics g){
        drawWall(g);
        ImageIcon pacmanIcon = new ImageIcon("pacman.gif");
        Image pacmanImg = pacmanIcon.getImage();
        g.drawImage(pacmanImg,x,y,30,30,null);
    }
    public void drawWall(Graphics g){
        
        for (int i=0;i<walls.size(); i++){
            g.setColor(Color.BLUE);
            g.drawRect(walls.get(i).getX(), walls.get(i).getY(), 30, 30);  
        }
    }
    //Method to move pacman to right 10 pixels
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