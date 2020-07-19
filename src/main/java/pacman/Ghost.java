import java.util.ArrayList;
import java.util.Random;

public class Ghost extends Position {
    private boolean eatable;
    private ListWalls lWall = new ListWalls();
    private ArrayList<Position> walls = lWall.getWalls();
    private String direction = "right";
    private String directionNeedToGo;
    private boolean stuckGhost = false;
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
    public boolean isPosibleMoveDown(final ArrayList<Position> wallsExtern) {
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
    public boolean isPosibleMoveUp(final ArrayList<Position> wallsExtern) {
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
    public boolean isPosibleMoveLeft(final ArrayList<Position> wallsExtern) {
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
    public boolean isPosibleMoveRight(final ArrayList<Position> wallsExtern) {
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
        final int numRand = new Random().nextInt(100);
        final String dirRand1 = "left";
        final String dirRand2 = "right";
        String dirY = dirRand1;
        if (isPosibleMove(dirRand1) && isPosibleMove(dirRand2)) {
            if (numRand % 2 == 0) {
                dirY = dirRand2;
             }
        } else {
            if (isPosibleMove(dirRand2)) {
                dirY = dirRand2;
            }
        }
        return dirY;
    }

    /**
     *
     * @return string direction y
     */
    public String getDirecctionY() {
        final int numRand = new Random().nextInt(100);
        final String dirRand1 = "up";
        final String dirRand2 = "down";
        String dirX = dirRand1;
        if (isPosibleMove(dirRand1) && isPosibleMove(dirRand2)) {
            if (numRand % 2 == 0) {
                dirX = dirRand2;
             }
        } else {
            if (isPosibleMove(dirRand2)) {
                dirX = dirRand2;
            }
        }
        return dirX;
    }

    /**
     *
     * stuckGhost
     */
    public String solveStuckGhost(final String dirOptional) {
        String routeOptional = dirOptional;
        switch (dirOptional) {
        case "down":
                if (isPosibleMove(directionNeedToGo)) {
                    routeOptional = directionNeedToGo;
                    stuckGhost = false;
                } else if (!isPosibleMoveDown(walls)) {
                    routeOptional = getDirecctionX();
                }
            break;
        case "up":
                if (isPosibleMove(directionNeedToGo)) {
                    routeOptional = directionNeedToGo;
                    stuckGhost = false;
                } else  if (!isPosibleMoveUp(walls)) {
                    routeOptional = getDirecctionX();
                }
            break;
        case "left":
                if (isPosibleMove(directionNeedToGo)) {
                    routeOptional = directionNeedToGo;
                    stuckGhost = false;
                } else if (!isPosibleMoveLeft(walls)) {
                    routeOptional = getDirecctionY();
                }
            break;
        case "right":
                if (isPosibleMove(directionNeedToGo)) {
                    routeOptional = directionNeedToGo;
                    stuckGhost = false;
                } else if (!isPosibleMoveRight(walls)) {
                    routeOptional = getDirecctionY();
                }
            break;
        default:
            break;
        }
        return routeOptional;
    }

    /**
     *
     * @return string direction X
     */
    public String getNextDirectionGhostX(final Pacman pacman) {
        String nextDirX = "";
        if (pacman.getX() > this.getX()) {
            nextDirX = "right";
        } else {
            if (pacman.getX() < this.getX()) {
                nextDirX = "left";
            } else {
                nextDirX = "intersection";
            }
        }
        return nextDirX;
    }

    /**
     *
     * @return string direction Y
     */
    public String getNextDirectionGhostY(final Pacman pacman) {
        String nextDirY = "";
        if (pacman.getY() > super.getY()) {
            nextDirY = "down";
        } else {
            if (pacman.getY() < super.getY()) {
                nextDirY = "up";
            } else {
                nextDirY = "intersection";
            }
        }
        return nextDirY;
    }

    /**
     *
     * @return boolean isPosibleMove
     */
    public boolean isPosibleMove(final String nextDirection) {
        boolean result = false;
        switch (nextDirection) {
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
            result = false;
            break;
        }
        return result;
    }

    /**
     *
     * @return string getRoute
     */
    public String getRoute(final Pacman pacman) {
        String dirToGo = "";
        if (stuckGhost) {
            dirToGo = solveStuckGhost(direction);
        } else {
            final String sigDX = getNextDirectionGhostX(pacman);
            final String sigDY = getNextDirectionGhostY(pacman);
            if (isEatable()) {
                dirToGo = eatableChangeRoute(sigDX, sigDY, pacman);
            } else {
                System.out.println("direccion noatable" + dirToGo);
                System.out.println("direccion irdir" + directionNeedToGo);
                if (directionNeedToGo != null) {
                    if (isPosibleMove(directionNeedToGo) && directionNeedToGo == (getRoutePosible(sigDX, sigDY))) {
                        dirToGo = directionNeedToGo;
                    } else {
                        dirToGo = getRoutePosible(sigDX, sigDY);
                        directionNeedToGo = null;
                    }
                } else {
                    dirToGo = getRoutePosible(sigDX, sigDY);
                    if (stuckGhost) {
                        directionNeedToGo = dirToGo;
                    }
                }
            }
        }
        return dirToGo;
    }


    /**
     *
     *  searchRouteGhost
     */
    public void searchRouteGhost(final Pacman pacman) {
        if (this.doesExist()) {
            direction = getRoute(pacman);
            switch (direction) {
            case "down":
                if (isPosibleMoveDown(walls)) {
                    moveDown();
                    if (isEatable()) {
                        if (existGhostEatable(pacman)) {
                            super.die();
                        }
                    } else {
                        if (existPacmanEatable(pacman)) {
                            pacman.die();
                        }
                    }
                }
                break;
            case "up":
                if (isPosibleMoveUp(walls)) {
                    moveUp();
                    if (isEatable()) {
                        if (existGhostEatable(pacman)) {
                            super.die();
                        }
                    } else {
                        if (existPacmanEatable(pacman)) {
                            pacman.die();
                        }
                    }
                }
                break;
            case "left":
                if (isPosibleMoveLeft(walls)) {
                    moveLeft();
                    if (isEatable()) {
                        if (existGhostEatable(pacman)) {
                            super.die();
                        }
                    } else {
                        if (existPacmanEatable(pacman)) {
                            pacman.die();
                        }
                    }
                }
                break;
            case "right":
                if (isPosibleMoveRight(walls)) {
                    moveRight();
                    if (isEatable()) {
                        if (existGhostEatable(pacman)) {
                            super.die();
                        }
                    } else {
                        if (existPacmanEatable(pacman)) {
                            pacman.die();
                        }
                    }
                }
                break;
            default:
                break;
            }
        } else {
            System.out.println("el ghost exist " + doesExist());
        }
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
     * @return existGhostEatable
     */
    public boolean existGhostEatable(final Pacman pacman) {
        if (this.doesExist() && pacman.getX() == this.getX() && pacman.getY() == this.getY()) {
            return true;
        }
        return false;
    }

    /**
     *
     * @return eatableChangeRoute
     */
    public String eatableChangeRoute(final String routeX, final String routeY, final Pacman pacman) {
        String eatableRoute;
        final int distanciamin = 200;
        if (Math.abs(pacman.getX() - this.getX()) < distanciamin) {
            if (routeX == "intersection") {
                eatableRoute = getDirecctionY();
            }
            eatableRoute = routeEscape(routeX);
        } else if (Math.abs(pacman.getY() - this.getY()) < distanciamin) {
            eatableRoute = routeEscape(routeY);
        } else {
            eatableRoute = getRoutePosible(routeX, routeY);
        }
        return eatableRoute;
    }

    /**
     *
     * @return getRoutePosible
     */
    public String getRoutePosible(final String routeX, final String routeY) {
        String routePosible = "right";
        if (isPosibleMove(routeX)) {
            routePosible = routeX;
        } else if (isPosibleMove(routeY)) {
            routePosible = routeY;
        } else if (routeX != "intersection") {
            routePosible = routeX;
            stuckGhost = true;
        } else if (routeY != "intersection") {
            routePosible = routeY;
            stuckGhost = true;
        }
        return routePosible;
    }
    /**
     *
     * @return routeEscape
     */
    public String routeEscape(final String route) {
        String routeEscape = route;
        if (route == "right") {
            routeEscape = getDirecctionY();
            if (isPosibleMove("left")) {
                routeEscape = "left";
            }
        } else if (route == "left") {
            routeEscape = getDirecctionY();
            if (isPosibleMove("right")) {
                routeEscape = "right";
            }
        } else if (route == "up") {
            routeEscape = getDirecctionX();
            if (isPosibleMove("down")) {
                routeEscape = "down";
            }
        } else if (route == "down") {
            routeEscape = getDirecctionX();
            if (isPosibleMove("up")) {
                routeEscape = "up";
            }
        } else if (route == "intersection") {
            routeEscape = getDirecctionX();
            if (isPosibleMove(getDirecctionY())) {
                routeEscape = getDirecctionY();
            }
        }
        return routeEscape;
    }
}
