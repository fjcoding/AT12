import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class ActionKeyPacman implements KeyListener {

    private DrawComponents drawComponents;
    private int key;
    public static final int TIMER_PACMAN = 200;

    public ActionKeyPacman(final DrawComponents dComponents) {
        this.drawComponents = dComponents;
    }

    private Timer timer = new Timer(TIMER_PACMAN, new ActionListener() {
    /**
     @Override actionPerformed
     */
    @Override
        public void actionPerformed(final ActionEvent event) {
            if (key == KeyEvent.VK_LEFT) {
                drawComponents.move("left");
            }
            if (key == KeyEvent.VK_RIGHT) {
                drawComponents.move("right");
            }
            if (key == KeyEvent.VK_UP) {
                drawComponents.move("up");
            }
            if (key == KeyEvent.VK_DOWN) {
                drawComponents.move("down");
            }
        }
    });

    /**
     @Override key pressed
     */
    public void keyPressed(final KeyEvent event) {
        timer.start();
        key = event.getKeyCode();
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
