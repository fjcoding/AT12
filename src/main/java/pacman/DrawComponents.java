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
    private Pacman pacman = new Pacman(300, 300, true);
    private int x = pacman.getX();
    private int y = pacman.getY();
    private String direction;
    private static final int CANT_GHOST = 4;
    private static final int TIME_GHOST_IS_EATABLE = 3;
    private ArrayList<Position> walls;
    public ArrayList<Dot> dots;
    private int posXghost;
    private int posYghost;
    private ArrayList<Ghost> ghosts = new ArrayList<Ghost>();
    private ListWalls listWalls;
    private Timer timer;
    private int seconds = 0;
    public DrawComponents() {
        dots = pacman.getDots();
        direction = "pacman.png";
        listWalls = new ListWalls();
        walls = listWalls.getWalls();
        timer = new Timer();
        for (int i = 1; i <= CANT_GHOST; i++) {
            if ( i % 2 == 0 ){
                ghosts.add(new Ghost(i * 30, i * 180, true));
            } else {
                ghosts.add(new Ghost(i * 210, i * 60, true));
            }
        }
      
        TimerTask taskScapeGhost = new TimerTask() {
            @Override
            public void run() {
                if(!pacman.isEatable()){
                    for (Ghost ghost : ghosts) {
                        //ruta de escape
                        if (ghost.doesExist()) {
                            ghost.searchRouteGhost(pacman);
                        }
                        seconds++;
                    }
                    repaint();
                }
                if ( seconds > 50){
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
        timer.schedule(task, 3000, 200);
        timer.schedule(taskScapeGhost, 3000, 500);
    }

    public void paintComponent(Graphics g) {
        drawWall(g);
        drawDots(g);
        drawGhosts(g);
        drawPacman(g);
    }

    public void drawGameOver(Graphics g) {
        ImageIcon gameOver = new ImageIcon(
        DrawComponents.class.getResource("gameOver.jpg")
        );
        Image gameOverImg = gameOver.getImage();
        g.drawImage(gameOverImg, 100, 100, 600, 600, null);
    }

    public void drawPacman(Graphics g) {
        if (pacman.doesExist()) {
        ImageIcon pacmanIcon = new ImageIcon(
            DrawComponents.class.getResource(direction)
        );
        Image pacmanImg = pacmanIcon.getImage();
        g.drawImage(pacmanImg, x, y, 30, 30, null);
        } else {
            timer.cancel();
            drawGameOver(g);            
        }
    }

    public void drawWall(Graphics g) {
        for (Position wall : walls) {
        g.setColor(Color.BLUE);
        g.fillRect(wall.getX(), wall.getY(), 30, 30);
        }
    }

    public void drawDots(Graphics g) {
        for (Dot dot : dots) {
        g.setColor(Color.WHITE);
        if (dot.exist) {
            if (dot.isSpecialDot()) {
            g.fillOval(dot.getX() + 5, dot.getY() + 5, 20, 20);
            } else {
            g.fillOval(dot.getX() + 10, dot.getY() + 10, 10, 10);
            }
        }
        }
    }

    public void drawGhosts(Graphics g) {
        if(pacman.isEatable()){//
            for (Ghost ghost : ghosts) {
                if (ghost.doesExist()) {
                    posXghost = ghost.getX();
                    posYghost = ghost.getY();
                    ImageIcon ghostIcon = new ImageIcon(
                    PacmanDraw.class.getResource("ghost2.png")
                    );
                    Image ghostImg = ghostIcon.getImage();
                    g.drawImage(ghostImg, posXghost, posYghost, 30, 30, this);
                }
            }
        } else {
            for (Ghost ghost : ghosts) {
                if (ghost.doesExist()) {
                    posXghost = ghost.getX();
                    posYghost = ghost.getY();
                    ImageIcon ghostIcon = new ImageIcon(
                        PacmanDraw.class.getResource("ghost1.png")
                    );
                    Image ghostImg = ghostIcon.getImage();
                    g.drawImage(ghostImg, posXghost, posYghost, 30, 30, this);
                }
            }
        }
    }

    //Method to move pacman to right 10 pixelsAnd Check if there is a dot or superdot
    public void moveRight() {
        if (pacman.doesExist()) {
        x = pacman.right();
        y = y;
        repaint();
        direction = "pacmanRight.gif";
        for (Dot dot : dots) {
            if ((pacman.existDot(x, y)) && (dot.getX() == x && dot.getY() == y)) {
            dot.setExist(false);
            }
            if (
            ((pacman.existDot(x, y)) && (dot.getX() == x && dot.getY() == y)) &&
            (dot.isSpecialDot())
            ) {
            dot.setExist(false);
            pacman.setNotEatable();
            seconds = 0;
            for (Ghost ghost : ghosts) {
                ghost.changeEatable();
            }
            }
        }
        }
        for (Ghost ghost : ghosts) {
            if (pacman.getX() == ghost.getX() && pacman.getY() == ghost.getY()) {
                if(!ghost.isEatable()) {
                    pacman.die();
                } else {
                    ghost.die();
                }
            }
        }
    }

    //Method to move pacman to left 10 pixels And Check if there is a dot or superdot
    public void moveLeft() {
        if (pacman.doesExist()) {
        x = pacman.left();
        y = y;
        repaint();
        direction = "pacmanLeft.gif";
        for (Dot dot : dots) {
            if (pacman.existDot(x, y) && (dot.getX() == x && dot.getY() == y)) {
            dot.setExist(false);
            }
            if (
            ((pacman.existDot(x, y)) && (dot.getX() == x && dot.getY() == y)) &&
            (dot.isSpecialDot())
            ) {
            dot.setExist(false);
            pacman.setNotEatable();
            seconds = 0;
            for (Ghost ghost : ghosts) {
                ghost.changeEatable();
            }
            }
        }
        }
        for (Ghost ghost : ghosts) {
            if (pacman.getX() == ghost.getX() && pacman.getY() == ghost.getY()) {
                if(!ghost.isEatable()) {
                    pacman.die();
                } else {
                    ghost.die();
                }
            }
        }
    }

    //Method to move pacman to down 10 pixels And Check if there is a dot or superdot
    public void moveDown() {
        if (pacman.doesExist()) {
        y = pacman.down();
        x = x;
        repaint();
        direction = "pacmanDown.gif";
        for (Dot dot : dots) {
            if (pacman.existDot(x, y) && (dot.getX() == x && dot.getY() == y)) {
            dot.setExist(false);
            }
            if (
            ((pacman.existDot(x, y)) && (dot.getX() == x && dot.getY() == y)) &&
            (dot.isSpecialDot())
            ) {
            dot.setExist(false);
            pacman.setNotEatable();
            seconds = 0;
            for (Ghost ghost : ghosts) {
                ghost.changeEatable();
            }
            }
        }
        }
        for (Ghost ghost : ghosts) {
        if (pacman.getX() == ghost.getX() && pacman.getY() == ghost.getY()) {
            if(!ghost.isEatable()) {
                pacman.die();
            } else {
                ghost.die();
            }
        }
        }
    }

    //Method to move pacman to up 10 pixels And Check if there is a dot or  superdot
    public void moveUp() {
        if (pacman.doesExist()) {
        y = pacman.up();
        x = x;
        repaint();
        direction = "pacmanUp.gif";
        for (Dot dot : dots) {
            if (pacman.existDot(x, y) && (dot.getX() == x && dot.getY() == y)) {
            dot.setExist(false);
            }
            if (
            ((pacman.existDot(x, y)) && (dot.getX() == x && dot.getY() == y)) &&
            (dot.isSpecialDot())
            ) {
            dot.setExist(false);
            pacman.setNotEatable();
            seconds = 0;
            for (Ghost ghost : ghosts) {
                ghost.changeEatable();
            }
            }
        }
        }
        for (Ghost ghost : ghosts) {
        if (pacman.getX() == ghost.getX() && pacman.getY() == ghost.getY()) {
            if(!ghost.isEatable()) {
                pacman.die();
            } else {
                ghost.die();
            }
        }
        }
    }
}
