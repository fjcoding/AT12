import java.awt.Dimension;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

class Main extends JFrame {
 
    private DrawComponents drawComponents;

    public Main() {
        this.drawComponents = new DrawComponents();
        this.addKeyListener(new ActionKeyPacman(drawComponents));
        this.setSize(900, 900);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        Main frame = new Main();
        frame.setMinimumSize(new Dimension(900, 900));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(frame.drawComponents);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.pack();
        frame.setVisible(true);
    }
}
