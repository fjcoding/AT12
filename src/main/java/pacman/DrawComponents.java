import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Timer;
//import javax.swing.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

public class DrawComponents extends JComponent {

    public static final int WIDTH_FRAME = 300;
    public static final int HEIGHT_FRAME = 300;
    public static final long DELAY_TIMER = 3000;
    public static final long PERIOD_TIMER = 200;
    public static final long PERIOD_TIMER_GHOST = 500;
    public static final int WIDHT_PACMAN = 30;
    public static final int HEIGHT_PACMAN = 30;
    public static final int WIDHT_WALL = 30;
    public static final int HEIGHT_WALL = 30;
    public static final int WIDHT_GHOST = 30;
    public static final int HEIGHT_GHOST = 30;
    public static final int DOT_SHIFT = 10;
    public static final int SPECIAL_DOT_SHIFT = 5;
    public static final int DOT_SIZE = 10;
    public static final int SPECIAL_DOT_SIZE = 20;
    public static final int POSITION_GAMEOVER = 100;
    public static final int SIZE_GAMEOVER = 600;
    public static final int TIME_TO_CHANGE_GHOST = 50;
    private Pacman pacman = new Pacman(WIDTH_FRAME, HEIGHT_FRAME, true);
    private int x = pacman.getX();
    private int y = pacman.getY();
    private String direction;
    private static final int TIME_GHOST_IS_EATABLE = 3;
    private ArrayList<Position> walls;
    private ArrayList<Dot> dots;
    private Creator creator;
    private ArrayList<Ghost> ghosts;
    private ListWalls listWalls;
    private Timer timer;
    private int seconds = 0;
    public static final int CASE_LEFT = 0;
    public static final int CASE_RIGHT = 1;
    public static final int CASE_UP = 2;
    public static final int CASE_DOWN = 3;

    public DrawComponents() {
        dots = pacman.getDots();
        direction = "pacman.png";
        listWalls = new ListWalls();
        walls = listWalls.getWalls();
        timer = new Timer();
        creator = new Creator();
        ghosts = creator.createGhost();
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
        ImageIcon gameOver = new ImageIcon(
        DrawComponents.class.getResource("gameOver.jpg")
        );
        Image gameOverImg = gameOver.getImage();
        g.drawImage(gameOverImg, POSITION_GAMEOVER, POSITION_GAMEOVER, SIZE_GAMEOVER, SIZE_GAMEOVER, null);
    }

    /**
     * Method to add components to the frame
     */
    public void drawPacman(final Graphics g) {
        if (pacman.doesExist()) {
            ImageIcon pacmanIcon = new ImageIcon(
            DrawComponents.class.getResource(direction)
        );
        Image pacmanImg = pacmanIcon.getImage();
        g.drawImage(pacmanImg, x, y, WIDHT_PACMAN, HEIGHT_PACMAN, null);
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
            g.fillRect(wall.getX(), wall.getY(), WIDHT_WALL, HEIGHT_WALL);
        }
    }

    /**
     * Method to draw a dot
     */
    public void drawDots(final Graphics g) {
        int dotPositionX;
        int dotPositionY;
        int specialDotPositionX;
        int specialDotPositionY;
        for (Dot dot : dots) {
            specialDotPositionX = dot.getX() + SPECIAL_DOT_SHIFT;
            specialDotPositionY = dot.getY() + SPECIAL_DOT_SHIFT;
            dotPositionX = dot.getX() + DOT_SHIFT;
            dotPositionY = dot.getY() + DOT_SHIFT;
            g.setColor(Color.WHITE);
            if (dot.doesExist()) {
                if (dot.isSpecialDot()) {
                    g.fillOval(specialDotPositionX, specialDotPositionY, SPECIAL_DOT_SIZE, SPECIAL_DOT_SIZE);
                } else {
                    g.fillOval(dotPositionX, dotPositionY, DOT_SIZE, DOT_SIZE);
                }
            }
        }
    }

    /**
     * Method to draw ghosts
     */
    public void drawGhosts(final Graphics g) {
        if (pacman.isEatable()) {
            for (Ghost ghost : ghosts) {
                if (ghost.doesExist()) {
                    ImageIcon ghostIcon = new ImageIcon(
                    DrawComponents.class.getResource("ghost2.png")
                    );
                    Image ghostImg = ghostIcon.getImage();
                    g.drawImage(ghostImg, ghost.getX(), ghost.getY(), WIDHT_GHOST, HEIGHT_GHOST, this);
                }
            }
        } else {
            for (Ghost ghost : ghosts) {
                if (ghost.doesExist()) {
                    ImageIcon ghostIcon = new ImageIcon(
                        DrawComponents.class.getResource("ghost1.png")
                    );
                    Image ghostImg = ghostIcon.getImage();
                    g.drawImage(ghostImg, ghost.getX(), ghost.getY(), WIDHT_GHOST, HEIGHT_GHOST, this);
                }
            }
        }
    }

    /**
     * Method to move pacman to right 10 SHIFTs And Check if there is a dot or superdot
     */

    public void move(final int type) {
        if (pacman.doesExist()) {
            switch (type) {
                case CASE_LEFT:
                    x = pacman.left();
                    direction = "pacmanLeft.gif";
                    break;
                case CASE_RIGHT:
                    x = pacman.right();
                    direction = "pacmanRight.gif";
                    break;
                case CASE_UP:
                    y = pacman.up();
                    direction = "pacmanUp.gif";
                    break;
                case CASE_DOWN:
                    y = pacman.down();
                    direction = "pacmanDown.gif";
                    break;
                default:
                    break;
            }
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
