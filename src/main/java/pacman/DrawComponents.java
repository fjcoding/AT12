import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

public class DrawComponents extends JComponent {

    private Pacman pacman = new Pacman(300, 300, true);
    private int x = pacman.getX();
    private int y = pacman.getY();
    private String direction;
    private ArrayList<Position> walls;
    public ArrayList <Dot> dots;
    private Ghost ghost1 = new Ghost(30, 90, true);
    private int posXghost1 = ghost1.getX();
    private int posYghost1 = ghost1.getY();
    private Ghost ghost2 = new Ghost(300, 120, true);
    private int posXghost2 = ghost2.getX();
    private int posYghost2 = ghost2.getY();
    private ListWalls listWalls;
    public Timer timer;

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
        timer.schedule(task, 3000, 500);
    }

    public void paintComponent(Graphics g) { 
        drawWall(g);
        drawGhosts(g);
        drawPacman(g);
        drawDots(g);
    }
    
    public void drawPacman(Graphics g) {
        if(pacman.doesExist()) {
            ImageIcon pacmanIcon = new ImageIcon(DrawComponents.class.getResource(direction));
            Image pacmanImg = pacmanIcon.getImage();
            g.drawImage(pacmanImg, x, y, 30, 30, null);
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
            if(dot.exist) {
                if(dot.isSpecialDot()) {
                    g.fillOval(dot.getX() + 5, dot.getY() + 5, 20, 20);
                }
                else {
                    g.fillOval(dot.getX() + 10, dot.getY() + 10, 10, 10);
                }
            }
        }
    }

    public void drawGhosts(Graphics g) {
        posXghost1 = ghost1.getX();
        posYghost1 = ghost1.getY();
        posXghost2 = ghost2.getX();
        posYghost2 = ghost2.getY();
        ImageIcon ghostIcon1 = new ImageIcon(PacmanDraw.class.getResource("ghost1.png"));
        ImageIcon ghostIcon2 = new ImageIcon(PacmanDraw.class.getResource("ghost2.png"));
        Image ghostImg1 = ghostIcon1.getImage();
        Image ghostImg2 = ghostIcon2.getImage();
        g.drawImage(ghostImg1, posXghost1, posYghost1, 30, 30, this);
        g.drawImage(ghostImg2, posXghost2, posYghost2, 30, 30, this);
    }
  
    //Method to move pacman to right 10 pixelsAnd Check if there is a dot or superdot
    public void moveRight() {
        if(pacman.doesExist()) {
             x = pacman.right();
            y = y;
            repaint();
            direction = "pacmanRight.gif";
            for (Dot dot : dots) {
                if((pacman.existDot(x, y)) && (dot.getX() == x && dot.getY() == y)) {
                    dot.setExist(false);
                }
                if (((pacman.existDot(x,y)) && (dot.getX() == x && dot.getY() == y)) && (dot.isSpecialDot())) {
                    dot.setExist(false);
                    ghost1.changeEatable();
                    ghost2.changeEatable();
                }   
            }
        }
        
        if((pacman.getX() == ghost1.getX() && pacman.getY() == ghost1.getY())|| (pacman.getX() == ghost2.getX() && pacman.getY() == ghost2.getY())) {
                pacman.die();
            }
    }

    //Method to move pacman to left 10 pixels And Check if there is a dot or superdot
    public void moveLeft() {
        if(pacman.doesExist()) {
        x = pacman.left();
        y = y;
        repaint();
        direction = "pacmanLeft.gif";
        for (Dot dot : dots) {
            if(pacman.existDot(x,y) && (dot.getX() == x && dot.getY() == y)) {
                dot.setExist(false);
            }
            if (((pacman.existDot(x,y)) && (dot.getX() == x && dot.getY() == y)) && (dot.isSpecialDot())){
                dot.setExist(false);
                ghost1.changeEatable();
                ghost2.changeEatable();
            }   
          }}
         if((pacman.getX() == ghost1.getX() && pacman.getY() == ghost1.getY())|| (pacman.getX() == ghost2.getX() && pacman.getY() == ghost2.getY())) {
                pacman.die();
            }
    }

    //Method to move pacman to down 10 pixels And Check if there is a dot or superdot
    public void moveDown() {
        if(pacman.doesExist()) {
        y = pacman.down();
        x = x;
        repaint();
        direction = "pacmanDown.gif";
        for (Dot dot : dots) {
            if(pacman.existDot(x,y) && (dot.getX() == x && dot.getY() == y)) {
                dot.setExist(false);
            }
            if (((pacman.existDot(x,y)) && (dot.getX() == x && dot.getY() == y)) && (dot.isSpecialDot())){
                dot.setExist(false);
                ghost1.changeEatable();
                ghost2.changeEatable();
            }  

        }
        if((pacman.getX() == ghost1.getX() && pacman.getY() == ghost1.getY())|| (pacman.getX() == ghost2.getX() && pacman.getY() == ghost2.getY())) {
                pacman.die();
            }
    }
    }

    //Method to move pacman to up 10 pixels And Check if there is a dot or  superdot
    public void moveUp() {
        if(pacman.doesExist()) {
        y = pacman.up();
        x = x;
        repaint();
        direction = "pacmanUp.gif";
        for (Dot dot: dots) {
            if(pacman.existDot(x,y) && (dot.getX() == x && dot.getY() == y)) {
                dot.setExist(false);
            }
            if (((pacman.existDot(x,y)) && (dot.getX() == x && dot.getY() == y)) && (dot.isSpecialDot())) {
                dot.setExist(false);
                ghost1.changeEatable();
                ghost2.changeEatable();
            }
          }
         
    }
    if((pacman.getX() == ghost1.getX() && pacman.getY() == ghost1.getY())|| (pacman.getX() == ghost2.getX() && pacman.getY() == ghost2.getY())) {
                pacman.die();
            }
}
}