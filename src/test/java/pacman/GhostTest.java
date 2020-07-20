import static org.junit.Assert.*;

import java.util.*;

import org.junit.Ignore;
import org.junit.Test;

public class GhostTest {
    private ListWalls listWalls = new ListWalls();
    private ArrayList<Position> walls = listWalls.getWalls();
    private String parametroDir = "right";

    @Test
    public void testMoveUp() {
        Ghost g = new Ghost(0, 30, true);
        g.moveUp();
        assertEquals(0, g.getY());
    }

    @Test
    public void testMoveDown() {
        Ghost g = new Ghost(5, 5, true);
        g.moveDown();
        assertEquals(35, g.getY());
    }

    @Test
    public void testMoveLeft() {
        Ghost g = new Ghost(30, 5, true);
        g.moveLeft();
        assertEquals(0, g.getX());
    }

    @Test
    public void testMoveRight() {
        Ghost g = new Ghost(5, 5, true);
        g.moveRight();
        assertEquals(35, g.getX());
    }

    @Test
    public void testDie() {
        Ghost ghost = new Ghost(5, 5, true);
        ghost.die();
        assertFalse(ghost.doesExist());
    }

    @Test
    public void testLive() {
        Ghost ghost = new Ghost(5, 5, false);
        ghost.live();
        assertTrue(ghost.doesExist());
    }

    @Test
    public void testExistPacmanEatable() {
        Ghost g = new Ghost(5, 5, true);
        Pacman p = new Pacman(5, 5, true);
        boolean resultToCompare = g.existPacmanEatable(p);
        assertEquals(true, resultToCompare);
    }
    @Test
    public void testExistGhostEatable() {
        Ghost g = new Ghost(5, 5, true);
        Pacman p = new Pacman(5, 5, true);
        boolean resultToCompare = g.existGhostEatable(p);
        assertEquals(true, resultToCompare);
    }

    @Test
    public void testIsPosibleMoveDown() {
        Ghost ghost = new Ghost(60, 90, true);
        assertTrue(ghost.isPosibleMoveDown(walls));
    }

    @Test
    public void testIsPosibleMoveUp() {
        Ghost ghost = new Ghost(120, 90, true);
        assertTrue(ghost.isPosibleMoveUp(walls));
    }

    @Test
    public void testIsPosibleMoveRight() {
        Ghost ghost = new Ghost(60, 90, true);
        assertTrue(ghost.isPosibleMoveRight(walls));
    }

    @Test
    public void testIsPosibleMoveLeft() {
        Ghost ghost = new Ghost(90, 90, true);
        assertTrue(ghost.isPosibleMoveLeft(walls));
    }

    @Test
    public void testSolveStuckGhost() {
        Ghost ghost = new Ghost(270, 90, true,walls);
        ghost.setStuckGhost(true);
        ghost.setDirectionNeedToGo("down");
        String direction = "right";
        String expected = "right";
        assertEquals(expected,ghost.solveStuckGhost(direction));
    }

    @Test
    public void testSetEatable() {
        Ghost ghost = new Ghost(270, 90, true,walls);
        ghost.setEatable(true);
        assertTrue(ghost.isEatable());
    }

    @Test
    public void testGetStuckGhost() {
        Ghost ghost = new Ghost(270, 90, true,walls);
        assertFalse(ghost.getStuckGhost());
    }

    @Test
    public void testSetStuckGhost() {
        Ghost ghost = new Ghost(270, 90, true,walls);
        ghost.setStuckGhost(true);
        assertTrue(ghost.getStuckGhost());
    }

    @Test
    public void getDirectionNeedToGo() {
        Ghost ghost = new Ghost(270, 90, true);
        ghost.setDirectionNeedToGo("left");
        assertEquals("left", ghost.getDirectionNeedToGo());
    }

    @Test
    public void testSetDirectionNeedToGo() {
        Ghost ghost = new Ghost(270, 90, true);
        ghost.setDirectionNeedToGo("up");
        assertEquals("up", ghost.getDirectionNeedToGo());
    }

    @Test
    public void testGetNextDirectionGhostX() {
        Ghost ghost = new Ghost(90, 90, true);
        Pacman pacman = new Pacman(30,90,true);
        String expected = "left";
        assertEquals(expected,ghost.getNextDirectionGhostX(pacman));
    }

    @Test
    public void testGetNextDirectionGhostY() {
        Ghost ghost = new Ghost(30, 60, true);
        Pacman pacman = new Pacman(30,60,true);
        String expected = "intersection";
        assertEquals(expected,ghost.getNextDirectionGhostY(pacman));
    }

    @Test
    public void testIsPosibleMoveR() {
        Ghost ghost = new Ghost(60, 90, true,walls);
        String direction = "right";
        assertTrue(ghost.isPosibleMove(direction));
    }

    @Test
    public void testIsPosibleMoveL() {
        Ghost ghost = new Ghost(60, 90, true,walls);
        String direction = "left";
        assertTrue(ghost.isPosibleMove(direction));
    }
    @Test
    public void testIsPosibleMoveU() {
        Ghost ghost = new Ghost(300, 90, true,walls);
        String direction = "up";
        assertTrue(ghost.isPosibleMove(direction));
    }

    @Test
    public void testIsPosibleMoveD() {
        Ghost ghost = new Ghost(300, 90, true,walls);
        String direction = "down";
        assertTrue(ghost.isPosibleMove(direction));
    }

    @Test
    public void testGetRoute() {
        Ghost ghost = new Ghost(300, 90, true, walls);
        Pacman pacman = new Pacman(300,300,true);
        String expected = "down";
        assertEquals(expected, ghost.getRoute(pacman));
    }

    @Test
    public void testGetRoute2() {
        Ghost ghost = new Ghost(270, 90, true, walls);
        Pacman pacman = new Pacman(300,300,true);
        ghost.setDirectionNeedToGo("down");
        String expected = "right";
        assertEquals(expected, ghost.getRoute(pacman));
    }

    @Test
    public void testGetRoute3() {
        Ghost ghost = new Ghost(270, 90, true, walls);
        Pacman pacman = new Pacman(300,300,true);
        ghost.setEatable(true);
        String rutax = "right";
        String rutay = "down";
        String expected = "right";
        assertEquals(expected, ghost.getRoute(pacman));
    }

    @Test
    public void testGetDirecctionX() {
        Ghost ghost = new Ghost(30, 30, true, walls);
        Pacman pacman = new Pacman(300,300,true);
        String expected = "right";
        assertEquals(expected, ghost.getDirecctionX());
    }

    @Test
    public void testGetDirecctionY() {
        Ghost ghost = new Ghost(30, 30, true, walls);
        Pacman pacman = new Pacman(300,300,true);
        String expected = "down";
        assertEquals(expected, ghost.getDirecctionY());
    }

    @Test
    public void testEatableChangeRoute() {
        Ghost ghost = new Ghost(270, 90, true, walls);
        Pacman pacman = new Pacman(300,300,true);
        ghost.setEatable(true);
        String rutax = "right";
        String rutay = "down";
        String expected = "right";
        assertEquals(expected, ghost.eatableChangeRoute(rutax,rutay,pacman));
    }

    @Test
    public void testEatableChangeRoute2() {
        Ghost ghost = new Ghost(60, 270, true, walls);
        Pacman pacman = new Pacman(300,300,true);
        ghost.setEatable(true);
        String rutax = "right";
        String rutay = "down";
        String expected = "left";
        assertEquals(expected, ghost.eatableChangeRoute(rutax,rutay,pacman));
    }

    @Test
    public void testSearchRouteGhost() {
        Ghost ghost = new Ghost(300, 90, true, walls);
        Pacman pacman = new Pacman(300,300,true);
        String expected = "down";
        ghost.searchRouteGhost(pacman);
        assertEquals(expected, ghost.getDirection());
    }

    @Test
    public void testSearchRouteGhost2() {
        Ghost ghost = new Ghost(270, 90, true, walls);
        Pacman pacman = new Pacman(270,270,true);
        String expected = "down";
        ghost.searchRouteGhost(pacman);
        assertEquals(expected, ghost.getDirection());
    }

    @Test
    public void testSearchRouteGhost3() {
        Ghost ghost = new Ghost(210, 30, true, walls);
        Pacman pacman = new Pacman(210,90,true);
        ghost.setStuckGhost(true);
        ghost.setDirectionNeedToGo("down");
        ghost.searchRouteGhost(pacman);
        String result = ghost.getDirection();
        boolean expected = false;
        if(result == "left" || result == "right") {
            expected = true;
        }
        assertTrue(expected);
    }

    @Test
    public void testGetRoutePosible() {
        Ghost ghost = new Ghost(300, 30, true, walls);
        Pacman pacman = new Pacman(300,300,true);
        String expected = "down";
        assertEquals(expected, ghost.getRoutePosible("intersection", "down"));
    }

    @Test
    public void testRouteEscape() {
        Ghost ghost = new Ghost(300, 30, true, walls);
        Pacman pacman = new Pacman(300,300,true);
        String expected = "left";
        assertEquals(expected, ghost.routeEscape("down"));
    }

}
