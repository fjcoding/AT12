import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class ActionKeyPacman implements KeyListener {
    
    private final DrawComponents drawComponents;
    private int keyRight, keyLeft, keyUp, keyDown;
    Timer timer = new Timer(200, new ActionListener() {
        @Override
        public void actionPerformed(final ActionEvent event) {
            if(keyRight == 1 )
                drawComponents.moveRight();
            if(keyLeft == 1 )
                drawComponents.moveLeft();
            if(keyUp == 1 )
                drawComponents.moveUp();
            if(keyDown == 1 )
                drawComponents.moveDown();
        }
    });

    public ActionKeyPacman(
    final DrawComponents drawComponents)
    {
        this.drawComponents = drawComponents;
    }

    @Override
    public void keyPressed(final KeyEvent event) {
        timer.start();
        final int key = event.getKeyCode();
        if (key == KeyEvent.VK_RIGHT) {
            keyUp = 0;
            keyDown = 0;
            keyRight = 1;
            keyLeft = 0;
        }
        else if (key == KeyEvent.VK_LEFT) {
            keyUp = 0;
            keyDown = 0;
            keyRight = 0;
            keyLeft = 1;
        }
        else if (key == KeyEvent.VK_DOWN) {
            keyUp = 0;
            keyDown = 1;
            keyRight = 0;
            keyLeft = 0;
        } 
        else if (key == KeyEvent.VK_UP) {
            keyUp = 1;
            keyDown = 0;
            keyRight = 0;
            keyLeft = 0;
        }
    }

    @Override
    public void keyReleased(final KeyEvent event) {

    }

    @Override
    public void keyTyped(final KeyEvent event) {
    }
}
