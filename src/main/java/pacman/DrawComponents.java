import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

public class DrawComponents extends JComponent {

    public static final int WIDTH_FRAME = 300;
    public static final int HEIGHT_FRAME = 300;
    public static final int GHOST1_POSITION_X = 30;
    public static final int GHOST1_POSITION_Y = 90;
    public static final int GHOST2_POSITION_X = 270;
    public static final int GHOST2_POSITION_Y = 120;
    public static final long DELAY_TIMER = 3000;
    public static final long PERIOD_TIMER = 200;
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

    private Pacman pacman = new Pacman(WIDTH_FRAME, HEIGHT_FRAME, true);
    private int x = pacman.getX();
    private int y = pacman.getY();
    private String direction;
    private ArrayList<Position> walls;
    private ArrayList<Dot> dots;
    private Ghost ghost1 = new Ghost(GHOST1_POSITION_X, GHOST1_POSITION_Y, true);
    private int xG = ghost1.getX();
    private int yG = ghost1.getY();
    private Ghost ghost2 = new Ghost(GHOST2_POSITION_X, GHOST2_POSITION_Y, true);
    private int xG2 = ghost2.getX();
    private int yG2 = ghost2.getY();
    private ListWalls listWalls;
    private Timer timer;

    public DrawComponents() {
        dots = pacman.getDots();
        direction = "pacman.gif";
        listWalls = new ListWalls();
        walls = listWalls.getWalls();
        timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                ghost1.searchRouteGhost(pacman);
                ghost2.searchRouteGhost(pacman);
                repaint();
            }
        };
        timer.schedule(task, DELAY_TIMER, PERIOD_TIMER);
    }

    /**
     * Method to add components to the frame
     */
    public void paintComponent(final Graphics g) {
        drawWall(g);
        drawGhosts(g);
        drawPacman(g);
        drawDots(g);
    }

    /**
     * Method to draw a pacman
     */
    public void drawPacman(final Graphics g) {
        ImageIcon pacmanIcon = new ImageIcon(DrawComponents.class.getResource(direction));
        Image pacmanImg = pacmanIcon.getImage();
        g.drawImage(pacmanImg, x, y, WIDHT_PACMAN, HEIGHT_PACMAN, null);
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
        xG = ghost1.getX();
        yG = ghost1.getY();
        xG2 = ghost2.getX();
        yG2 = ghost2.getY();
        ImageIcon ghostIcon1 = new ImageIcon(DrawComponents.class.getResource("ghost1.png"));
        ImageIcon ghostIcon2 = new ImageIcon(DrawComponents.class.getResource("ghost2.png"));
        Image ghostImg1 = ghostIcon2.getImage();
        Image ghostImg2 = ghostIcon2.getImage();
        g.drawImage(ghostImg1, xG, yG, WIDHT_GHOST, HEIGHT_GHOST, this);
        g.drawImage(ghostImg2, xG2, yG2, WIDHT_GHOST, HEIGHT_GHOST, this);
    }

    /**
     * Method to move pacman to right 10 SHIFTsAnd Check if there is a dot or superdot
     */
    public void moveRight() {
        x = pacman.right();
        repaint();
        direction = "pacmanRight.gif";
        for (Dot dot : dots) {
            if ((pacman.existDot(x, y)) && (dot.getX() == x && dot.getY() == y)) {
                dot.doesnotExist();
            }
            if (((pacman.existDot(x, y)) && (dot.getX() == x && dot.getY() == y)) && (dot.isSpecialDot())) {
                dot.doesnotExist();
                ghost1.changeEatable();
                ghost2.changeEatable();
            }
        }
    }

    /**
     * Method to move pacman to left 10 SHIFTs And Check if there is a dot or superdot
     */
    public void moveLeft() {
        x = pacman.left();
        repaint();
        direction = "pacmanLeft.gif";
        for (Dot dot : dots) {
            if (pacman.existDot(x, y) && (dot.getX() == x && dot.getY() == y)) {
                dot.doesnotExist();
            }
            if (((pacman.existDot(x, y)) && (dot.getX() == x && dot.getY() == y)) && (dot.isSpecialDot())) {
                dot.doesnotExist();
                ghost1.changeEatable();
                ghost2.changeEatable();
            }
        }
    }

    /**
     * Method to move pacman to down 10 SHIFTs And Check if there is a dot or superdot
     */
    public void moveDown() {
        y = pacman.down();
        repaint();
        direction = "pacmanDown.gif";
        for (Dot dot : dots) {
            if (pacman.existDot(x, y) && (dot.getX() == x && dot.getY() == y)) {
                dot.doesnotExist();
            }
            if (((pacman.existDot(x, y)) && (dot.getX() == x && dot.getY() == y)) && (dot.isSpecialDot())) {
                dot.doesnotExist();
                ghost1.changeEatable();
                ghost2.changeEatable();
            }
        }
    }

    /**
     * Method to move pacman to up 10 SHIFTs And Check if there is a dot or  superdot
     */
    public void moveUp() {
        y = pacman.up();
        repaint();
        direction = "pacmanUp.gif";
        for (Dot dot: dots) {
            if (pacman.existDot(x, y) && (dot.getX() == x && dot.getY() == y)) {
                dot.doesnotExist();
            }
            if (((pacman.existDot(x, y)) && (dot.getX() == x && dot.getY() == y)) && (dot.isSpecialDot())) {
                dot.doesnotExist();
                ghost1.changeEatable();
                ghost2.changeEatable();
            }
        }
    }
}
