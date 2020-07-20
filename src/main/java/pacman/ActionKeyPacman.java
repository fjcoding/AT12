import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class ActionKeyPacman implements KeyListener {

    private DrawComponents drawComponents;
    public static final int TIMER_PACMAN = 200;
    public static final String MOVE_LEFT = "left";
    public static final String MOVE_RIGHT = "right";
    public static final String MOVE_UP = "up";
    public static final String MOVE_DOWN = "down";
    private int key, preKey;
    private Boolean keyLeft, keyRight, keyUp, keyDown, aux = true;

    public ActionKeyPacman(final DrawComponents dComponents) {
        this.drawComponents = dComponents;
    }

    private Timer timer = new Timer(TIMER_PACMAN, new ActionListener() {
    /**
     @Override actionPerformed
     */
    @Override
        public void actionPerformed(final ActionEvent event) {
            aux = false;
            if (drawComponents.isNotPosibleMove(key)) {
                key = preKey;
                preKey = 0;
            }
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
            if (keyLeft) {
                drawComponents.move(MOVE_LEFT);
            }
            if (keyRight) {
                drawComponents.move(MOVE_RIGHT);
            }
            if (keyUp) {
                drawComponents.move(MOVE_UP);
            }
            if (keyDown) {
                drawComponents.move(MOVE_DOWN);
            }
            aux = true;
        }
    });

    /**
     @Override key pressed
     */
    public void keyPressed(final KeyEvent event) {
        if (aux) {
            timer.start();
        }
        if (key != preKey) {
            preKey = key;
        }
        key = event.getKeyCode();
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

    /**
     @Override key Released
     */
    public void keyReleased(final KeyEvent event) {
    }

    /**
     @Override key Typed
     */
    public void keyTyped(final KeyEvent event) {
    }
}
