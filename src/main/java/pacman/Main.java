import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class Main extends JFrame {
    //attrib
    private Dot objectDots;
    private Ghost objectGhost;
    private PacmanDraw pacmanDraw ;
 
    public Main(){
        this.pacmanDraw = new PacmanDraw();
        this.addKeyListener(new ActionKeyPacman(pacmanDraw));
        this.setSize(900, 900);
        this.setVisible(true);       
    }
    public static void main(String[] args){       
        
        Main frame = new Main();
        frame.setMinimumSize(new Dimension(900, 900));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(frame.pacmanDraw);
        frame.pack();
        frame.setVisible(true);       
    }  
}
