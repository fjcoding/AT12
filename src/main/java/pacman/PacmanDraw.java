import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

public class PacmanDraw extends JComponent {

    
    private Pacman pacman= new Pacman(60, 60, true);
    public int x = pacman.getX();
    public int y = pacman.getY();
    
    //Method to draw pacman in the frame
    public void paintComponent(Graphics g){
        ImageIcon pacmanIcon = new ImageIcon("pacmanIcon.png");
        Image pacmanImg = pacmanIcon.getImage();
        g.drawImage(pacmanImg,x,y,30,30,null);
    }

    //Method to move pacman to right 10 pixels
    public void moveRight(){
        x = pacman.right();
        repaint();
    }

    //Method to move pacman to left 10 pixels
    public void moveLeft(){
        x = pacman.left();
        repaint();
    }

    //Method to move pacman to down 10 pixels
    public void moveDown(){
        y = pacman.down();
        repaint();
    }

    //Method to move pacman to up 10 pixels
    public void moveUp(){
        y = pacman.up();
        repaint();
    }
}