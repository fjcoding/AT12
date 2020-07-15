import java.util.ArrayList;
import java.util.Random;

public class Ghost extends Position {
    private boolean eatable;
    public ArrayList<Position> walls;

    public Ghost(int x, int y, boolean exist) {
        super(x, y, exist);
        this.eatable = false;
    }

    public Ghost(int x, int y, boolean exist, ArrayList<Position> walls) {
        super(x, y, exist);
        this.eatable = false;
        this.walls = walls;
    }

    public boolean getExist() {
        return exist;
    }

    public void setX(int x) {
        super.x = x;
    }

    public void setY(int y) {
        super.y = y;
    }

    public int getX() {
        return super.x;
    }

    public int getY() {
        return super.y;
    }

    public boolean setExist(boolean exist) {
        super.exist = exist;
        return true;
    }

    public boolean isEatable() {
        return this.eatable;
    }

    public void changeEatable() {
        this.eatable = true;
    }

    public void die() {
        this.exist = false;
    }

    public boolean existPacmanEatable(Pacman pacman) {
        if(pacman.exist == true && pacman.getX() == this.x && pacman.getY() == this.getY()) {
            return true;
        }
        else return false;
    }

    public void eatPacman(Pacman pacman) {
        pacman.die();
        this.exist = false;
    }

    public void moveUp() {
        super.y -= 30;
    }

    public void moveDown() {
        super.y += 30;
    }

    public void moveLeft() {
        super.x -= 30;
    }

    public void moveRight() {
        super.x += 30;
    }

    public boolean isPosibleMoveDown(ArrayList<Position> walls) {
        for (Position i : walls) {
            if (i.getX() == this.x && i.getY() == this.y + 30) 
                return false;
        }
        return true;
    }

    public boolean isPosibleMoveUp(ArrayList<Position> walls) {
        for (Position i : walls) {
            if (i.getX() == this.x && i.getY() == this.y - 30) 
                return false;
        }
        return true;
    }

    public boolean isPosibleMoveLeft(ArrayList<Position> walls) {
        for (Position i : walls) {
            if (i.getX() == this.x - 30 && i.getY() == this.y) 
                return false;
        }
        return true;
    }

    public boolean isPosibleMoveRight(ArrayList<Position> walls) {
        for (Position i : walls) {
            if (i.getX() == this.x + 30 && i.getY() == this.y) 
                return false;
        }
        return true;
    }

    public void searchRoute(Pacman pacman) {
        int dir = new Random().nextInt(4);

        switch (dir) {
        case 0:
            if (isPosibleMoveDown(walls)) {
                moveDown();
                if (existPacmanEatable(pacman)) 
                    eatPacman(pacman);
            }
            break;
        case 1:
            if (isPosibleMoveUp(walls)) {
                moveUp();
                if (existPacmanEatable(pacman)) 
                    eatPacman(pacman);
            }
            break;
        case 2:
            if (isPosibleMoveLeft(walls)) {
                moveLeft();
                if (existPacmanEatable(pacman)) 
                    eatPacman(pacman);
            }
            break;
        case 3:
            if (isPosibleMoveRight(walls)) {
                moveRight();
                if (existPacmanEatable(pacman)) 
                    eatPacman(pacman);
            }
            break;
        }
    }

    public void searchRoute() {
        int dir = new Random().nextInt(4);

        switch (dir) {
        case 0:
            if (isPosibleMoveDown(walls)) {
                moveDown();
            }
            break;
        case 1:
            if (isPosibleMoveUp(walls)) {
                moveUp();
            }
            break;
        case 2:
            if (isPosibleMoveLeft(walls)) {
                moveLeft();
            }
            break;
        case 3:
            if (isPosibleMoveRight(walls)) {
                moveRight();
            }
            break;
        }
    }
}
