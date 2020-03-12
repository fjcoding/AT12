import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

public class PacmanDraw extends JComponent {

    public int x = 50;
    public int y = 50;
    
    //Method to draw pacman in the frame
    public void paintComponent(Graphics g){
        ImageIcon pacman = new ImageIcon("pacmanIcon.png");
        Image pacmanImg = pacman.getImage();
        g.drawImage(pacmanImg,x,y,30,30,null);
    }

    //Method to move pacman to right 10 pixels
    public void moveRight(){
        x = x + 10;
        repaint();
    }

    //Method to move pacman to left 10 pixels
    public void moveLeft(){
        x = x - 10;
        repaint();
    }

    //Method to move pacman to down 10 pixels
    public void moveDown(){
        y = y + 10;
        repaint();
    }

    //Method to move pacman to up 10 pixels
    public void moveUp(){
        y = y - 10;
        repaint();
    }
}