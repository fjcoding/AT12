import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class ActionKeyPacman implements KeyListener {

    private DrawComponents drawComponents;
    private boolean keyRight, keyLeft, keyUp, keyDown;
    public static final int TIMER_PACMAN = 200;
    public static final int MOVE_LEFT = 0;
    public static final int MOVE_RIGHT = 1;
    public static final int MOVE_UP = 2;
    public static final int MOVE_DOWN = 3;
    private int preKey;
    private int key;
    private Boolean a = true;

    public ActionKeyPacman(final DrawComponents dComponents) {
        this.drawComponents = dComponents;
    }

    private Timer timer = new Timer(TIMER_PACMAN, new ActionListener() {
    /**
     @Override actionPerformed
     */
    @Override
        public void actionPerformed(final ActionEvent event) {
            a = false;
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
            a = true;
        }
    });

    /**
     @Override key pressed
     */
    public void keyPressed(final KeyEvent event) {
        if (a) {
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
