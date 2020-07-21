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
    private Boolean isKeyPressed = true;
    private String posToMove = "";

    public ActionKeyPacman(final DrawComponents dComponents) {
        this.drawComponents = dComponents;
    }

    private Timer timer = new Timer(TIMER_PACMAN, new ActionListener() {
    /**
     @Override actionPerformed
     */
    @Override
        public void actionPerformed(final ActionEvent event) {
            isKeyPressed = false;
            if (drawComponents.isNotPosibleMove(key)) {
                key = preKey;
                preKey = 0;
            }
            posToMove = assignMovement(key);
            drawComponents.move(posToMove);
            isKeyPressed = true;
        }
    });

    /**
     @Override key pressed
     */
    public void keyPressed(final KeyEvent event) {
        if (isKeyPressed) {
            timer.start();
        }
        if (key != preKey) {
            preKey = key;
        }
        key = event.getKeyCode();
        posToMove = assignMovement(key);
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

    /**
     * Method to set variable assigned to keyRight, keyLeft, keyUp, keyDown
     */
    public String assignMovement(final int keyValue) {
        if (keyValue == KeyEvent.VK_RIGHT) {
            posToMove = MOVE_RIGHT;
        } else if (keyValue == KeyEvent.VK_LEFT) {
            posToMove = MOVE_LEFT;
        } else if (keyValue == KeyEvent.VK_DOWN) {
            posToMove = MOVE_DOWN;
        } else if (keyValue == KeyEvent.VK_UP) {
            posToMove = MOVE_UP;
        }
        return posToMove;
    }
}
