import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class ActionKeyPacman implements KeyListener{
    private PacmanDraw pacmanDraw ;
    public ActionKeyPacman(PacmanDraw pacmanDraw){
        this.pacmanDraw = pacmanDraw;
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
}
