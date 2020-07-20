import java.util.ArrayList;

public class Ghost extends Position {
    private boolean eatable;
    private ArrayList<Wall> walls;
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

    public Ghost(final int x, final int y, final boolean exist, final ArrayList<Wall> createdWalls) {
        super(x, y, exist);
        this.eatable = false;
        walls = createdWalls;
    }

    /**
     *
     * @param x
     */
    public void setX(final int x) {
        super.setX(x);
    }

    /**
     *
     * @param y
     */
    public void setY(final int y) {
        super.setY(y);
    }

    /**
     *
     * @return x
     */
    public int getX() {
        return super.getX();
    }

    /**
     *
     * @return y
     */
    public int getY() {
        return super.getY();
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
     * changeEatable
     */
    public void changeEatable() {
        this.eatable = true;
    }

    /**
     *
     * @return changeEatable
     */
    public void setEatable(final boolean doesEatable) {
        this.eatable = doesEatable;
    }

    /**
     *
     * @return die
     */
    public void die() {
        super.doesnotExist();
    }

    /**
     *
     * @return existPacmanEatable
     */
    public boolean existPacmanEatable(final Pacman pacman) {
        if (pacman.doesExist() && pacman.getX() == super.getX() && pacman.getY() == super.getY()) {
            return true;
        }
        return false;
    }

    /**
     *
     *  eatPacman
     */
    public void eatPacman(final Pacman pacman) {
        pacman.die();
        this.doesnotExist();
    }

    /**
     *
     *  moveUp
     */
    public void moveUp() {
        super.setY(super.getY() - WALK_DISTANCE);
    }

    /**
     *
     *  moveDown
     */
    public void moveDown() {
        super.setY(super.getY() + WALK_DISTANCE);
    }

    /**
     *
     *  moveLeft
     */
    public void moveLeft() {
        super.setX(super.getX() - WALK_DISTANCE);
    }

    /**
     *
     *  moveRight
     */
    public void moveRight() {
        super.setX(super.getX() + WALK_DISTANCE);
    }

    /**
     *
     * @return isPosibleMoveDown
     */
    public boolean isPosibleMoveDown(final ArrayList<Wall> wallsExtern) {
        for (Position wall : walls) {
            if (wall.getX() == super.getX() && wall.getY() == super.getY() + WALK_DISTANCE) {
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @return isPosibleMoveUp
     */
    public boolean isPosibleMoveUp(final ArrayList<Wall> wallsExtern) {
        for (Position wall : walls) {
            if (wall.getX() == super.getX() && wall.getY() == super.getY() - WALK_DISTANCE) {
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @return isPosibleMoveLeft
     */
    public boolean isPosibleMoveLeft(final ArrayList<Wall> wallsExtern) {
        for (Position wall : walls) {
            if (wall.getX() == super.getX() - WALK_DISTANCE && wall.getY() == super.getY()) {
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @return isPosibleMoveRight
     */
    public boolean isPosibleMoveRight(final ArrayList<Wall> wallsExtern) {
        for (Position wall : walls) {
            if (wall.getX() == super.getX() + WALK_DISTANCE && wall.getY() == super.getY()) {
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @return string direction X
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
     * @return string direction y
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
     * atascado
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
     * @return string direction X
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
     * @return string direction Y
     */
    public String changeDireccionGhostY(final Pacman pacman) {
        if (pacman.getY() > this.getY()) {
            direccion = "down";
        } else {
            if (pacman.getY() < this.getY()) {
                direccion = "up";
            } else {
                if (isPosibleMove(changeDireccionGhostX(pacman))) {
                    direccion = changeDireccionGhostX(pacman);
                } else {
                    atascado = true;
                    irDir = changeDireccionGhostX(pacman);
                }
            }
        }
        return direccion;
    }

    /**
     *
     * @return boolean isPosibleMove
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
     * @return string ruta
     */
    public String ruta(final Pacman pacman) {
        if (atascado) {
            atascado();
        } else {
            if (isEatable()) {
                direccion = eatableChangeRuta(pacman);
            } else {
                final String sigDX = changeDireccionGhostX(pacman);
                final String sigDY = changeDireccionGhostY(pacman);
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
        }
        return direccion;
    }

    /**
     *
     *  searchRouteGhost
     */
    public void searchRouteGhost(final Pacman pacman) {
        if (this.doesExist()) {
            direccion = ruta(pacman);
            switch (direccion) {
            case "down":
                if (isPosibleMoveDown(walls)) {
                    moveDown();
                    if (isEatable()) {
                        if (existGhostEatable(pacman)) {
                            eatGhost();
                        }
                    } else {
                        if (existPacmanEatable(pacman)) {
                            eatPacman(pacman);
                        }
                    }
                }
                break;
            case "up":
                if (isPosibleMoveUp(walls)) {
                    moveUp();
                    if (isEatable()) {
                        if (existGhostEatable(pacman)) {
                            eatGhost();
                        }
                    } else {
                        if (existPacmanEatable(pacman)) {
                            eatPacman(pacman);
                        }
                    }
                }
                break;
            case "left":
                if (isPosibleMoveLeft(walls)) {
                    moveLeft();
                    if (isEatable()) {
                        if (existGhostEatable(pacman)) {
                            eatGhost();
                        }
                    } else {
                        if (existPacmanEatable(pacman)) {
                            eatPacman(pacman);
                        }
                    }
                }
                break;
            case "right":
                if (isPosibleMoveRight(walls)) {
                moveRight();
                    if (isEatable()) {
                        if (existGhostEatable(pacman)) {
                            eatGhost();
                        }
                    } else {
                        if (existPacmanEatable(pacman)) {
                            eatPacman(pacman);
                        }
                    }
                }
                break;
            default:
                break;
            }
        }
    }

    /**
     *
     * @return existPacmanEatable
     */
    public boolean existGhostEatable(final Pacman pacman) {
        if (this.doesExist() && pacman.getX() == this.getX() && pacman.getY() == this.getY()) {
            return true;
        }
        return false;
    }

    /**
     *
     * @return eatPacman
     */
    public void eatGhost() {
        die();
    }

    /**
     *
     * @return eatableChangeRuta
     */
    public String eatableChangeRuta(final Pacman pacman) {
        final String posPX = changeDireccionGhostX(pacman);
        final String posPY = changeDireccionGhostY(pacman);
        String dirGX = "left";
        String dirGY = "up";
        if (posPX.equals("left")) {
            dirGX = "right";
        }
        if (posPY.equals("up")) {
            dirGY = "down";
        }
        if (isPosibleMove(dirGX)) {
            direccion = dirGX;
        } else {
            if (isPosibleMove(dirGY)) {
                direccion = dirGY;
            } else {
                atascado = true;
            }
        }
        return direccion;
    }
}
