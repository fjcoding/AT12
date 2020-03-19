import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

<<<<<<< HEAD
class Main extends JFrame implements KeyListener{

    PacmanDraw pacmanDraw ;
 
    public Main(){
        this.pacmanDraw = new PacmanDraw();
        addKeyListener(this);
        this.setSize(900, 900);
        this.setVisible(true);       
    }

    @Override
    public void keyPressed(KeyEvent event){
    }

    @Override
    public void keyReleased(KeyEvent event){
        if(event.getKeyCode() == KeyEvent.VK_RIGHT)
            pacmanDraw.moveRight();
        else if(event.getKeyCode() == KeyEvent.VK_LEFT)
            pacmanDraw.moveLeft();
        else if(event.getKeyCode() == KeyEvent.VK_DOWN)
            pacmanDraw.moveDown();
        else if(event.getKeyCode() == KeyEvent.VK_UP)
            pacmanDraw.moveUp();
    }

    @Override
    public void keyTyped(KeyEvent event){
    }

    public static void main(String[] args){       
        
        Main frame = new Main();
        frame.setMinimumSize(new Dimension(900, 900));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(frame.pacmanDraw);
        frame.pack();
        frame.setVisible(true);       
    }  
=======
class Main extends Frame{

    //attrib
    private Pacman objectPacman;
    private Dot objectDots;
    private Ghost objectGhost;
 
    public Main(){
        this.setLayout(null);
        this.setSize(200,200);
        this.setVisible(true);
    }

    public static void main(String[] args){     
        Main m = new Main();      
    }
    
>>>>>>> 97cedee6a666f27deb44e15446b71e73060a97ec
}