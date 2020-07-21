import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JFrame;

public class Main extends JFrame {

    private DrawComponents drawComponents;
    static final int XFRAME = 900;
    static final int YFRAME = 900;

    public Main() {
        this.drawComponents = new DrawComponents();
        this.addKeyListener(new ActionKeyPacman(drawComponents));
        this.setSize(XFRAME, YFRAME);
        this.setVisible(true);
    }
    public static void HelloWorld() {
        System.out.println("Hola mundo!!!");
    }
    public static void main(final String[] args) {
        Main frame = new Main();
        frame.setMinimumSize(new Dimension(XFRAME, YFRAME));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(frame.drawComponents);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.pack();
        frame.setVisible(true);
    }
}
