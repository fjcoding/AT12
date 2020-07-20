import java.util.ArrayList;

class Pacman extends Position {
    private boolean eatable;
    private ArrayList<Dot> dots;
    private ArrayList<Wall> walls;
    private static final int POSITION_DIMENSION = 30;

    Pacman(final int x, final int y, final boolean exist, final ArrayList<Wall> wallsCreated, final ArrayList<Dot> dotsCreated) {
        super(x, y, exist);
        eatable = true;
        walls = wallsCreated;
        dots = dotsCreated;
    }

    public boolean isEatable() {
        return this.eatable;
    }

    public void setNotEatable() {
        this.eatable = false;
    }

    public void setEatable() {
        this.eatable = true;
    }

    public void die() {
        this.doesnotExist();
    }

    public void down() {
        if (!existWall(super.getX(), super.getY() + POSITION_DIMENSION)) {
            super.setY(super.getY() + POSITION_DIMENSION);
        }
    }

    public void right() {
        if (!existWall(super.getX() + POSITION_DIMENSION, super.getY())) {
            super.setX(super.getX() + POSITION_DIMENSION);
        }
    }

    public void left() {
        if (!existWall(super.getX() - POSITION_DIMENSION, super.getY())) {
            super.setX(super.getX() - POSITION_DIMENSION);
        }
    }

    public void up() {
        if (!existWall(super.getX(), super.getY() - POSITION_DIMENSION)) {
            super.setY(super.getY() - POSITION_DIMENSION);
        }
    }

    public String move(final String type) {
        String direction = "";
        switch (type) {
            case "left":
                left();
                direction = "pacmanLeft.gif";
                break;
            case "right":
                right();
                direction = "pacmanRight.gif";
                break;
            case "up":
                up();
                direction = "pacmanUp.gif";
                break;
            case "down":
                down();
                direction = "pacmanDown.gif";
                break;
            default:
                break;
        }
        return direction;
    }

    public boolean existWall(final int xx, final int yy) {
        boolean exist = false;
        for (Wall wall: walls) {
            if (wall.getX() == xx && wall.getY() == yy) {
                exist = true;
            }
        }
        return exist;
    }

    //Check if there is a dot in x and y position
    public boolean existDot(final int positionx, final int positiony) {
        boolean exist = false;
        for (Dot i : dots) {
            if (i.getX() == positionx && i.getY() == positiony) {
                exist = true;
            }
        }
        return exist;
    }

    public boolean isEatable(final Dot dotsPosition) {
        if (
        (super.getX() == dotsPosition.getX())
        &&
        (super.getY() == dotsPosition.getY())
        &&
        dotsPosition.doesExist()
        ) {
            dotsPosition.doesnotExist();
            return true;
        }
        return false;
    }

    public boolean isEatable(final Ghost ghostPosition) {
        if (
        (super.getX() == ghostPosition.getX())
        &&
        (super.getY() == ghostPosition.getY())
        &&
        ghostPosition.isEatable()
        ) {
            return true;
        } else {
            super.doesnotExist();
            return false;
        }
    }

    public int pacmanEatDot(final Dot dot, final ArrayList<Ghost> ghosts, final int seconds) {
        if (existDot(dot.getX(), dot.getY()) && dot.doesExist()) {
            dot.doesnotExist();
            if (dot.isSpecialDot()) {
                setNotEatable();
                for (Ghost ghost : ghosts) {
                    ghost.changeEatable();
                }
                return 0;
            }
        }
        return seconds;
    }

    public void pacmanEatGhosts(final ArrayList<Ghost> ghosts) {
        for (Ghost ghost : ghosts) {
            if (getX() == ghost.getX() && getY() == ghost.getY()) {
                if (!ghost.isEatable()) {
                    die();
                } else {
                    ghost.die();
                }
            }
        }
    }
}
