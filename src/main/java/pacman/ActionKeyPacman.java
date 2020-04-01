import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class ActionKeyPacman implements KeyListener{
    private DrawComponents drawComponents ;
    public ActionKeyPacman(DrawComponents drawComponents){
        this.drawComponents = drawComponents;
    }

    @Override
    public void keyPressed(KeyEvent event){
    }

    @Override
    public void keyReleased(KeyEvent event){
        if(event.getKeyCode() == KeyEvent.VK_RIGHT)
        drawComponents.moveRight();
        else if(event.getKeyCode() == KeyEvent.VK_LEFT)
        drawComponents.moveLeft();
        else if(event.getKeyCode() == KeyEvent.VK_DOWN)
        drawComponents.moveDown();
        else if(event.getKeyCode() == KeyEvent.VK_UP)
        drawComponents.moveUp();
    }

    @Override
    public void keyTyped(KeyEvent event){
    }
}
