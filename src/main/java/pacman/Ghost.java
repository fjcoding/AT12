import java.util.ArrayList;

public class Ghost extends Position {
    private boolean eatable;
    private ListWalls lWall = new ListWalls();
    private ArrayList<Position> walls = lWall.getWalls();
    private String direccion;
    private String noPDir;
    private String irDir;
    private String ruta;
    private boolean atascado = false;
    private static final int WALK_DISTANCE = 30;
    private static final int NUM_POSIBLE_RUTES = 4;
    private static final int DOWN = 0;
    private static final int UP = 1;
    private static final int LEFT = 2;
    private static final int RIGHT = 3;

    public Ghost(final int x, final int y, final boolean exist) {
        super(x, y, exist);
        this.eatable = false;
    }

    public Ghost(
        final int x,
        final int y,
        final boolean exist,
        final ArrayList<Position> wallsExtern
    ) {
        super(x, y, exist);
        this.eatable = false;
        walls = wallsExtern;
    }

    /**
     *
     * @param x
     */
    public void setX(final int x) {
        super.x = x;
    }

    /**
     *
     * @param y
     */
    public void setY(final int y) {
        super.y = y;
    }

    /**
     *
     * @return x
     */
    public int getX() {
        return super.x;
    }

    /**
     *
     * @return y
     */
    public int getY() {
        return super.y;
    }

    /**
     *
     * @return exist
     */
    public boolean setExist(final boolean exist) {
        super.exist = exist;
        return true;
    }

    /**
     *
     * @return isEatable
     */
    public boolean isEatable() {
        return this.eatable;
    }

    /**
     *
     * @return changeEatable
     */
    public void changeEatable() {
        this.eatable = true;
    }

    /**
     *
     * @return die
     */
    public void die() {
        this.exist = false;
    }

    /**
     *
     * @return existPacmanEatable
     */
    public boolean existPacmanEatable(final Pacman pacman) {
        if (pacman.doesExist() && pacman.getX() == this.x && pacman.getY() == this.getY()) {
            return true;
        }
        return false;
    }

    /**
     *
     * @return eatPacman
     */
    public void eatPacman(final Pacman pacman) {
        pacman.die();
        this.exist = false;
    }

    /**
     *
     * @return moveUp
     */
    public void moveUp() {
        super.y -= WALK_DISTANCE;
    }

    /**
     *
     * @return moveDown
     */
    public void moveDown() {
        super.y += WALK_DISTANCE;
    }

    /**
     *
     * @return moveLeft
     */
    public void moveLeft() {
        super.x -= WALK_DISTANCE;
    }

    /**
     *
     * @return moveRight
     */
    public void moveRight() {
        super.x += WALK_DISTANCE;
    }

    /**
     *
     * @return isPosibleMoveDown
     */
    public boolean isPosibleMoveDown(final ArrayList<Position> wallsExtern) {
        for (Position wall : walls) {
            if (wall.getX() == this.x && wall.getY() == this.y + WALK_DISTANCE) {
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @return isPosibleMoveUp
     */
    public boolean isPosibleMoveUp(final ArrayList<Position> wallsExtern) {
        for (Position wall : walls) {
            if (wall.getX() == this.x && wall.getY() == this.y - WALK_DISTANCE) {
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @return isPosibleMoveLeft
     */
    public boolean isPosibleMoveLeft(final ArrayList<Position> wallsExtern) {
        for (Position wall : walls) {
            if (wall.getX() == this.x - WALK_DISTANCE && wall.getY() == this.y) {
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @return isPosibleMoveRight
     */
    public boolean isPosibleMoveRight(final ArrayList<Position> wallsExtern) {
        for (Position wall : walls) {
        if (wall.getX() == this.x + WALK_DISTANCE && wall.getY() == this.y) {
            return false;
        }
        }
        return true;
    }

    /**
     *
     * @return getDirecctionX
     */

    public String getDirecctionX() {
        if (isPosibleMoveRight(walls)) {
        direccion = "right";
        } else {
        if (isPosibleMoveLeft(walls)) {
            direccion = "left";
        }
        }
        return direccion;
    }

    /**
     *
     * @return getDirecctionY
     */

    public String getDirecctionY() {
        if (isPosibleMoveUp(walls)) {
        direccion = "up";
        } else {
        if (isPosibleMoveDown(walls)) {
            direccion = "down";
        }
        }
        return direccion;
    }

    /**
     *
     * @return atascado
     */
    public void atascado() {
        switch (direccion) {
        case "down":
            if (isPosibleMoveDown(walls)) {
            if (irDir == getDirecctionX()) {
                direccion = irDir;
                atascado = false;
            } else {
                direccion = "down";
            }
            } else {
            direccion = getDirecctionX();
            }
            break;
        case "up":
            if (isPosibleMoveUp(walls)) {
            if (irDir == getDirecctionX()) {
                direccion = irDir;
                atascado = false;
            } else {
                direccion = "up";
            }
            } else {
            direccion = getDirecctionX();
            }
            break;
        case "left":
            if (isPosibleMoveLeft(walls)) {
            if (irDir == getDirecctionY()) {
                direccion = irDir;
                atascado = false;
            } else {
                direccion = "left";
            }
            } else {
            direccion = getDirecctionY();
            }
            break;
        case "right":
            if (isPosibleMoveRight(walls)) {
            if (irDir == getDirecctionY()) {
                direccion = irDir;
                atascado = false;
            } else {
                direccion = "right";
            }
            } else {
            direccion = getDirecctionY();
            }
            break;
        default:
            break;
        }
    }

    /**
     *
     * @return changeDireccionGhostX
     */
    public String changeDireccionGhostX(final Pacman pacman) {
        if (pacman.getX() > this.getX()) {
        direccion = "right";
        return direccion;
        } else {
        if (pacman.getX() < this.getX()) {
            direccion = "left";
            return direccion;
        } else if (isPosibleMove(changeDireccionGhostY(pacman))) {
            direccion = changeDireccionGhostY(pacman);
        } else {
            atascado = true;
            irDir = changeDireccionGhostY(pacman);
            //atascado();
        }
        }
        return direccion;
    }

    /**
     *
     * @return changeDireccionGhostY
     */
    public String changeDireccionGhostY(final Pacman pacman) {
        if (pacman.getY() < this.getY()) {
        direccion = "up";
        } else {
        if (pacman.getY() > this.getY()) {
            direccion = "down";
        } else {
            System.out.println(" change Y X" + changeDireccionGhostX(pacman));
            if (isPosibleMove(changeDireccionGhostX(pacman))) {
            direccion = changeDireccionGhostX(pacman);
            } else {
            atascado = true;
            irDir = changeDireccionGhostX(pacman);
            //atascado();

            }
        }
        }
        return direccion;
    }

    /**
     *
     * @return isPosibleMove
     */
    public boolean isPosibleMove(final String sigtDir) {
        boolean result = false;
        switch (sigtDir) {
        case "down":
            result = isPosibleMoveDown(walls);
            break;
        case "up":
            result = isPosibleMoveUp(walls);
            break;
        case "left":
            result = isPosibleMoveLeft(walls);
            break;
        case "right":
            result = isPosibleMoveRight(walls);
            break;
        default:
            break;
        }
        return result;
    }

    /**
     *
     * @return ruta
     */
    public String ruta(final Pacman pacman) {
        if (atascado) {
        atascado();
        } else {
        String sigDX = changeDireccionGhostX(pacman);
        String sigDY = changeDireccionGhostY(pacman);
        if (isPosibleMove(sigDX)) {
            direccion = sigDX;
        } else {
            if (isPosibleMove(sigDY)) {
            direccion = sigDY;
            } else {
            atascado = true;
            }
        }
        }

        return direccion;
    }

    /**
     *
     * @return searchRouteGhost
     */
    public void searchRouteGhost(final Pacman pacman) {
        direccion = ruta(pacman);

        switch (direccion) {
        case "down":
            if (isPosibleMoveDown(walls)) {
            moveDown();

            if (existPacmanEatable(pacman)) {
                eatPacman(pacman);
            }
            }
            break;
        case "up":
            if (isPosibleMoveUp(walls)) {
            moveUp();
            if (existPacmanEatable(pacman)) {
                eatPacman(pacman);
            }
            }
            break;
        case "left":
            if (isPosibleMoveLeft(walls)) {
            moveLeft();
            if (existPacmanEatable(pacman)) {
                eatPacman(pacman);
            }
            }
            break;
        case "right":
            if (isPosibleMoveRight(walls)) {
            moveRight();
            if (existPacmanEatable(pacman)) {
                eatPacman(pacman);
            }
            }
            break;
        default:
            break;
        }
    }
}
