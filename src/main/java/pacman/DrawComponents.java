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
    private String direction;
    public ArrayList <Position> walls;
    public Ghost ghost1 = new Ghost(60, 90, true);
    public int xG = ghost1.getX();
    public int yG = ghost1.getY();
    public Ghost ghost2 = new Ghost(60, 90, true);
    public int xG2 = ghost2.getX();
    public int yG2 = ghost2.getY();

    public DrawComponents() {
        walls = new ArrayList<Position>();
        walls = pacman.getWalls();
        ghost1 = new Ghost(60, 90, true, walls);
        Thread threadGhost1 = new Thread(ghost1);
        threadGhost1.start();
        ghost2 = new Ghost(90, 90, true, walls);
        Thread threadGhost2 = new Thread(ghost2);
        threadGhost2.start();
    }

    //Method to draw pacman in the frame
    public void paintComponent(Graphics g) { 
        drawWall(g);
        drawGhosts(g);
        ImageIcon pacmanIcon = new ImageIcon(direction);
        Image pacmanImg = pacmanIcon.getImage();
        g.drawImage(pacmanImg, x, y, 30, 30, null);
    }

    public void drawWall(Graphics g) {
        for (int i = 0; i < walls.size(); i++) {
        g.setColor(Color.BLUE);
        g.drawRect(walls.get(i).getX(), walls.get(i).getY(), 30, 30);
        }
    }

    public void drawGhosts(Graphics g) {
        xG = ghost1.getX();
        yG = ghost1.getY();
        xG2 = ghost2.getX();
        yG2 = ghost2.getY();
        ImageIcon ghostIcon = new ImageIcon("ghost.jpg");
        Image ghostImg = ghostIcon.getImage();
        g.drawImage(ghostImg, xG, yG, 30, 30, this);
        g.drawImage(ghostImg, xG2, yG2, 30, 30, this);
        repaint();
    }

    //Method to move pacman to right 10 pixels
    public void moveRight() {
        x = pacman.right();
        y = y;
        repaint();
        direction = "pacmanRight.gif";
    }

    //Method to move pacman to left 10 pixels
    public void moveLeft() {
        x = pacman.left();
        y = y;
        repaint();
        direction = "pacmanLeft.gif";
    }

    //Method to move pacman to down 10 pixels
    public void moveDown() {
        y = pacman.down();
        x = x;
        repaint();
        direction = "pacmanDown.gif";
    }

    //Method to move pacman to up 10 pixels
    public void moveUp() {
        y = pacman.up();
        x = x;
        repaint();
        direction = "pacmanUp.gif";
    }
}
