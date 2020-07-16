import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class ActionKeyPacman implements KeyListener {
    
    private final DrawComponents drawComponents;
    private boolean keyRight, keyLeft, keyUp, keyDown;
    Timer timer = new Timer(200, new ActionListener() {
        @Override
        public void actionPerformed(final ActionEvent event) {
            if (keyRight)
                drawComponents.moveRight();
            if (keyLeft)
                drawComponents.moveLeft();
            if (keyUp)
                drawComponents.moveUp();
            if (keyDown)
                drawComponents.moveDown();
        }
    });

    public ActionKeyPacman(DrawComponents drawComponents) {
        this.drawComponents = drawComponents;
    }

    @Override
    public void keyPressed(final KeyEvent event) {
        timer.start();
        final int key = event.getKeyCode();
        if (key == KeyEvent.VK_RIGHT) {
            keyUp = false;
            keyDown = false;
            keyRight = true;
            keyLeft = false;
        } else if (key == KeyEvent.VK_LEFT) {
            keyUp = false;
            keyDown = false;
            keyRight = false;
            keyLeft = true;
        } else if (key == KeyEvent.VK_DOWN) {
            keyUp = false;
            keyDown = true;
            keyRight = false;
            keyLeft = false;
        } else if (key == KeyEvent.VK_UP) {
            keyUp = true;
            keyDown = false;
            keyRight = false;
            keyLeft = false;
        }
    }

    @Override
    public void keyReleased(final KeyEvent event) {
    }

    @Override
    public void keyTyped(final KeyEvent event) {
    }
}