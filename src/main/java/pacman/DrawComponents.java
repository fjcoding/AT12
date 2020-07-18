import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

public class DrawComponents extends JComponent {

    public static final int SIZE_FRAME = 300;
    public static final long DELAY_TIMER = 3000;
    public static final long PERIOD_TIMER = 200;
    public static final long PERIOD_TIMER_GHOST = 500;
    public static final int SIZE_ELEMENT = 30;
    public static final int DOT_SHIFT = 10;
    public static final int SPECIAL_DOT_SHIFT = 5;
    public static final int DOT_SIZE = 10;
    public static final int SPECIAL_DOT_SIZE = 20;
    public static final int POSITION_GAMEOVER = 100;
    public static final int SIZE_GAMEOVER = 600;
    public static final int TIME_TO_CHANGE_GHOST = 50;
    private Pacman pacman;
    private String direction;
    private ArrayList<Position> walls;
    private ArrayList<Dot> dots;
    private Creator creator;
    private ArrayList<Ghost> ghosts;
    private ListWalls listWalls;
    private Timer timer;
    private int seconds = 0;

    public DrawComponents() {
        pacman = new Pacman(SIZE_FRAME, SIZE_FRAME, true);
        dots = pacman.getDots();
        direction = "pacman.png";
        listWalls = new ListWalls();
        walls = listWalls.getWalls();
        timer = new Timer();
        creator = new Creator();
        ghosts = creator.createGhost();
        ghostMovementController();
    }

    /**
     * Method to check the ghost movement
     */
    public void ghostMovementController() {
        TimerTask taskScapeGhost = new TimerTask() {
            @Override
            public void run() {
                if (!pacman.isEatable()) {
                    for (Ghost ghost : ghosts) {
                        //ruta de escape
                        if (ghost.doesExist()) {
                            ghost.searchRouteGhost(pacman);
                        }
                        seconds++;
                    }
                    repaint();
                }
                if (seconds > TIME_TO_CHANGE_GHOST) {
                    pacman.setEatable();
                    for (Ghost ghost : ghosts) {
                        //ruta de escape
                        if (ghost.doesExist()) {
                            ghost.setEatable(false);
                        }
                    }
                }
            }
        };
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if (pacman.isEatable()) {
                    for (Ghost ghost : ghosts) {
                        if (ghost.doesExist()) {
                            ghost.searchRouteGhost(pacman);
                        }
                    }
                    repaint();
                }
            }
        };
        timer.schedule(taskScapeGhost, DELAY_TIMER, PERIOD_TIMER_GHOST);
        timer.schedule(task, DELAY_TIMER, PERIOD_TIMER);
    }

    /**
     * Method to add components to the frame
     */
    public void paintComponent(final Graphics g) {
        drawWall(g);
        drawDots(g);
        drawGhosts(g);
        drawPacman(g);
    }

    /**
     * Method to add components to the frame
     */
    public void drawGameOver(final Graphics g) {
        ImageIcon gameOver = new ImageIcon(DrawComponents.class.getResource("gameOver.jpg"));
        Image gameOverImg = gameOver.getImage();
        g.drawImage(gameOverImg, POSITION_GAMEOVER, POSITION_GAMEOVER, SIZE_GAMEOVER, SIZE_GAMEOVER, null);
    }

    /**
     * Method to add components to the frame
     */
    public void drawPacman(final Graphics g) {
        if (pacman.doesExist()) {
            ImageIcon pacmanIcon = new ImageIcon(DrawComponents.class.getResource(direction));
            Image pacmanImg = pacmanIcon.getImage();
            g.drawImage(pacmanImg, pacman.getX(), pacman.getY(), SIZE_ELEMENT, SIZE_ELEMENT, null);
        } else {
            timer.cancel();
            drawGameOver(g);
        }
    }

    /**
     * Method to draw the walls
     */
    public void drawWall(final Graphics g) {
        for (Position wall : walls) {
            g.setColor(Color.BLUE);
            g.fillRect(wall.getX(), wall.getY(), SIZE_ELEMENT, SIZE_ELEMENT);
        }
    }

    /**
     * Method to draw a dot
     */
    public void drawDots(final Graphics g) {
        for (Dot dot : dots) {
            g.setColor(Color.WHITE);
            if (dot.doesExist()) {
                if (dot.isSpecialDot()) {
                    g.fillOval(dot.getX() + SPECIAL_DOT_SHIFT, dot.getY() + SPECIAL_DOT_SHIFT, SPECIAL_DOT_SIZE, SPECIAL_DOT_SIZE);
                } else {
                    g.fillOval(dot.getX() + DOT_SHIFT, dot.getY() + DOT_SHIFT, DOT_SIZE, DOT_SIZE);
                }
            }
        }
    }

    /**
     * Method to draw ghosts
     */
    public void drawGhosts(final Graphics g) {
        for (Ghost ghost : ghosts) {
            if (ghost.doesExist()) {
                ImageIcon ghostIcon;
                if (pacman.isEatable()) {
                    ghostIcon = new ImageIcon(DrawComponents.class.getResource("ghost2.png"));
                } else {
                    ghostIcon = new ImageIcon(DrawComponents.class.getResource("ghost1.png"));
                }
                Image ghostImg = ghostIcon.getImage();
                g.drawImage(ghostImg, ghost.getX(), ghost.getY(), SIZE_ELEMENT, SIZE_ELEMENT, this);
            }
        }
    }

    /**
     * Method to move pacman to right 10 SHIFTs And Check if there is a dot or superdot
     */

    public void move(final String type) {
        if (pacman.doesExist()) {
            direction = pacman.move(type);
            for (Dot dot : dots) {
                if (pacman.getX() == dot.getX() && pacman.getY() == dot.getY()) {
                    seconds = pacman.pacmanEatDot(dot, ghosts, seconds);
                    break;
                }
            }
            repaint();
        }
        pacman.pacmanEatGhosts(ghosts);
    }
}
