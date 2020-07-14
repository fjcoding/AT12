import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

public class DrawComponents extends JComponent {
    private Pacman pacman = new Pacman(30, 30, true);
    public int x = pacman.getX();
    public int y = pacman.getY();
    public ArrayList<Position> walls;
    public Ghost ghost1 = new Ghost(60, 90, true);
    public int xG = ghost1.getX();
    public int yG = ghost1.getY();
    public Ghost ghost2 = new Ghost(60, 90, true);
    public int xG2 = ghost2.getX();
    public int yG2 = ghost2.getY();
    public ListWalls listWalls;
    public Timer timer;
    public DrawComponents() {
        listWalls = new ListWalls();
        walls = listWalls.getWalls();
        ghost1 = new Ghost(60, 90, true, walls);
        ghost2 = new Ghost(90, 90, true, walls);
        timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                ghost1.searchRoute(pacman);
                ghost2.searchRoute(pacman);
                repaint();
            }
        };
        timer.schedule(task, 0, 500);
    }

    //Method to draw pacman in the frame
    public void paintComponent(Graphics g) { 
        drawWalls(g);
        drawGhosts(g);
        drawPacman(g);
    }

    public void drawPacman(Graphics g) {
        if(pacman.getExist()){
            ImageIcon pacmanIcon = new ImageIcon("pacman.gif");
            Image pacmanImg = pacmanIcon.getImage();
            g.drawImage(pacmanImg, x, y, 30, 30, null);
        }
    }

    public void drawWalls(Graphics g) { 
        ArrayList <Position> walls = new ArrayList<Position>();
        ListWalls lWalls = new ListWalls();
        walls = lWalls.getWalls();
        for (int i=0;i<walls.size(); i++) {
            g.setColor(Color.GRAY);
            g.fillRect(walls.get(i).getX(), walls.get(i).getY(), 30, 30);
        }
    }

    public void drawGhosts(Graphics g) {
        xG = ghost1.getX();
        yG = ghost1.getY();
        xG2 = ghost2.getX();
        yG2 = ghost2.getY();
        ImageIcon ghostIcon1 = new ImageIcon("ghost1.png");
        ImageIcon ghostIcon2 = new ImageIcon("ghost2.png");
        Image ghostImg1 = ghostIcon1.getImage();
        Image ghostImg2 = ghostIcon2.getImage();
        g.drawImage(ghostImg1, xG, yG, 30, 30, this);
        g.drawImage(ghostImg2, xG2, yG2, 30, 30, this);
    }

    //Method to move pacman to right 10 pixels
    public void moveRight() {
        x = pacman.right();
        y = y;
        repaint();
    }

    //Method to move pacman to left 10 pixels
    public void moveLeft() {
        x = pacman.left();
        y = y;
        repaint();
    }

    //Method to move pacman to down 10 pixels
    public void moveDown() {
        y = pacman.down();
        x = x;
        repaint();
    }

    //Method to move pacman to up 10 pixels
    public void moveUp() {
        y = pacman.up();
        x = x;
        repaint();
    }
}
