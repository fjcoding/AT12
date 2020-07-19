import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import java.util.concurrent.TimeUnit;

public class ActionKeyPacman implements KeyListener {

    private DrawComponents drawComponents;
    private boolean keyRight, keyLeft, keyUp, keyDown;
    public static final int TIMER_PACMAN = 200;
    public static final int MOVE_LEFT = 0;
    public static final int MOVE_RIGHT = 1;
    public static final int MOVE_UP = 2;
    public static final int MOVE_DOWN = 3;
    int preKey;
    int key;
    //long time1 = 50;
    //TimeUnit timer1 = TimeUnit.MILLISECONDS;
    Boolean a = true;
    //private Timer timer1 = new Timer();

    public ActionKeyPacman(final DrawComponents dComponents) {
        this.drawComponents = dComponents;
    }

    private Timer timer = new Timer(TIMER_PACMAN, new ActionListener() {
    /**
     @Override actionPerformed
     */
    @Override
        public void actionPerformed(final ActionEvent event) {
            
            if(drawComponents.isNotPosibleMove(key)){
                key = preKey;
                preKey = 0;
                System.out.println ("no es posible ir a la posicion indicada");
            }
            System.out.println ("inicio de actionPerformed");
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
            System.out.println ("fin de actionPerformed");
            
        }
    });

    /**
     @Override key pressed
     */
    public void keyPressed(final KeyEvent event) {
        if(!timer.isRunning()){
            //wait(100);
            timer.start();
        }
        //timer.start();
        System.out.println ("el timer es mayor a 10 ms");
        if(key != preKey) {
            preKey = key;
            System.out.println ("Se actualizo el prekey");
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
        System.out.println("prekey: " + preKey);
        System.out.println("key: " + key);
        a=true;
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
