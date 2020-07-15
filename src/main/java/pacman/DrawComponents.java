import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

public class DrawComponents extends JComponent {

    private Pacman pacman = new Pacman(30, 30, true);
    private int x = pacman.getX();
    private int y = pacman.getY();
    private String direction;
    private ArrayList<Position> walls;
    public ArrayList <Dot> dots;
    private Ghost ghost1 = new Ghost(60, 90, true);
    private int xG = ghost1.getX();
    private int yG = ghost1.getY();
    private Ghost ghost2 = new Ghost(60, 90, true);
    private int xG2 = ghost2.getX();
    private int yG2 = ghost2.getY();
    private ListWalls listWalls;

    public DrawComponents() {
        dots = pacman.getDots();
        direction = "pacman.gif";
        listWalls = new ListWalls();
        walls = listWalls.getWalls();
        ghost1 = new Ghost(60, 90, true, walls);
        Thread threadGhost1 = new Thread(ghost1);
        threadGhost1.start();
        ghost2 = new Ghost(90, 90, true, walls);
        Thread threadGhost2 = new Thread(ghost2);
        threadGhost2.start();
    }

    public void paintComponent(Graphics g) { 
        drawWall(g);
        drawGhosts(g);
        drawPacman(g);
        drawDots(g);
    }
    
    public void drawPacman(Graphics g) {
        ImageIcon pacmanIcon = new ImageIcon(DrawComponents.class.getResource(direction));
        Image pacmanImg = pacmanIcon.getImage();
        g.drawImage(pacmanImg, x, y, 30, 30, null);
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
    public void drawWalls(Graphics g) { 
        for (int i=0; i<walls.size(); i++) {
            g.setColor(Color.GRAY);
            g.fillRect(walls.get(i).getX(), walls.get(i).getY(), 30, 30);
        }
    }

    public void drawGhosts(Graphics g) {
        xG = ghost1.getX();
        yG = ghost1.getY();
        xG2 = ghost2.getX();
        yG2 = ghost2.getY();
        ImageIcon ghostIcon = new ImageIcon(DrawComponents.class.getResource("ghost.jpg"));
        Image ghostImg = ghostIcon.getImage();
        g.drawImage(ghostImg, xG, yG, 30, 30, this);
        g.drawImage(ghostImg, xG2, yG2, 30, 30, this);
        repaint();
    }
  
    //Method to move pacman to right 10 pixelsAnd Check if there is a dot or superdot
    public void moveRight() {
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

    //Method to move pacman to left 10 pixels And Check if there is a dot or superdot
    public void moveLeft() {
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
          }
    }

    //Method to move pacman to down 10 pixels And Check if there is a dot or superdot
    public void moveDown() {
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
    }

    //Method to move pacman to up 10 pixels And Check if there is a dot or  superdot
    public void moveUp() {
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
}