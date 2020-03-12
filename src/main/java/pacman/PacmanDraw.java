import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

public class PacmanDraw extends JComponent {

    public int x = 50;
    public int y = 50;
    
    public void paintComponent(Graphics g) {
        ImageIcon pacman = new ImageIcon("pacmanIcon.png");
        Image pacmanImg = pacman.getImage();
        g.drawImage(pacmanImg,x,y,30,30,null);
    }

    public void moveRight() {
        x = x + 1;
        repaint();
    }

    public void moveLeft() {
        x = x - 1;
        repaint();
    }

    public void moveDown() {
        y = y + 1;
        repaint();
    }

    public void moveUp() {
        y = y - 1;
        repaint();
    }
}