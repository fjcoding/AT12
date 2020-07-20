import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.*;

import org.junit.Ignore;
import org.junit.Test;

public class GhostTest {
    private Creator creator = new Creator();
    private ArrayList<Wall> walls = creator.createWalls();
    private String parametroDir = "right";

    @Test
    public void testMoveUp() {
        Ghost ghost = new Ghost(0, 30, true, walls);
        ghost.moveUp();
        assertEquals(0, ghost.getY());
    }

    @Test
    public void testMoveDown() {
        Ghost ghost = new Ghost(5, 5, true, walls);
        ghost.moveDown();
        assertEquals(35, ghost.getY());
    }

    @Test
    public void testMoveLeft() {
        Ghost ghost = new Ghost(30, 5, true, walls);
        ghost.moveLeft();
        assertEquals(0, ghost.getX());
    }

    @Test
    public void testMoveRight() {
        Ghost ghost = new Ghost(5, 5, true, walls);
        ghost.moveRight();
        assertEquals(35, ghost.getX());
    }

    @Test
    public void testMove() {
        Ghost g = new Ghost(5, 5, true);
        g.move("right");
        assertEquals(35, g.getX());
        g.move("left");
        assertEquals(5, g.getX());
        g.move("down");
        assertEquals(35, g.getY());
        g.move("up");
        assertEquals(5, g.getY());
        g.move("other");
        assertEquals(5, g.getY());
    }

    @Test
    public void testDie() {
        Ghost ghost = new Ghost(5, 5, true, walls);
        ghost.die();
        assertFalse(ghost.doesExist());
    }

    @Test
    public void testLive() {
        Ghost ghost = new Ghost(5, 5, false, walls);
        ghost.live();
        assertTrue(ghost.doesExist());
    }

    @Test
    public void testSetDirection() {
        String direction = "right";
        Ghost ghost = new Ghost(5, 5, false);
        ghost.setDirection(direction);
        assertEquals(direction,ghost.getDirection());
    }

    @Test
    public void testExistPacmanEatable() {
        Ghost g = new Ghost(5, 5, true);
        Pacman p = new Pacman(5, 5, true);
        assertTrue(g.existPacmanEatable(p));
        g.setX(10);
        assertFalse(g.existPacmanEatable(p));
        p.doesnotExist();
        assertFalse(g.existPacmanEatable(p));
    }
    @Test
    public void testExistGhostEatable() {
        Ghost g = new Ghost(5, 5, true);
        Pacman p = new Pacman(5, 5, true);
        assertTrue(g.existGhostEatable(p));
        g.setX(10);
        p.setY(10);
        assertFalse(g.existGhostEatable(p));
        g.doesnotExist();
        assertFalse(g.existGhostEatable(p));
    }

    @Test
    public void testIsPosibleMoveDown() {
        Ghost ghost = new Ghost(60, 90, true);
        assertTrue(ghost.isPosibleMoveDown());
    }

    @Test
    public void testIsPosibleMoveUp() {
        Ghost ghost = new Ghost(120, 90, true);
        assertTrue(ghost.isPosibleMoveUp());
    }

    @Test
    public void testIsPosibleMoveRight() {
        Ghost ghost = new Ghost(60, 90, true);
        assertTrue(ghost.isPosibleMoveRight());
    }

    @Test
    public void testIsPosibleMoveLeft() {
        Ghost ghost = new Ghost(90, 90, true);
        assertTrue(ghost.isPosibleMoveLeft());
    }

    @Test
    public void testSolveStuckGhost() {
        Ghost ghost = new Ghost(270, 90, true);
        ghost.setStuckGhost(true);
        ghost.setDirectionNeedToGo("down");
        String direction = "right";
        String expected = "right";
        assertEquals(expected,ghost.solveStuckGhost(direction));
        ghost.setDirectionNeedToGo("up");
        direction = "left";
        assertEquals("left",ghost.solveStuckGhost(direction));
        ghost.setX(300);
        ghost.setY(120);
        ghost.setDirectionNeedToGo("rigth");
        direction = "up";
        assertEquals("up",ghost.solveStuckGhost(direction));
        ghost.setDirectionNeedToGo("left");
        direction = "down";
        assertEquals("down",ghost.solveStuckGhost(direction));
        ghost.setDirectionNeedToGo("up");
        direction = "up";
        assertEquals("up",ghost.solveStuckGhost(direction));
        assertFalse(ghost.getStuckGhost());
    }

    @Test
    public void testSetEatable() {
        Ghost ghost = new Ghost(270, 90, true);
        ghost.setEatable(true);
        assertTrue(ghost.isEatable());
    }

    @Test
    public void testGetStuckGhost() {
        Ghost ghost = new Ghost(270, 90, true);
        assertFalse(ghost.getStuckGhost());
    }

    @Test
    public void testSetStuckGhost() {
        Ghost ghost = new Ghost(270, 90, true);
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
        Ghost ghost = new Ghost(60, 90, true);
        String direction = "right";
        assertTrue(ghost.isPosibleMove(direction));
    }

    @Test
    public void testIsPosibleMoveL() {
        Ghost ghost = new Ghost(60, 90, true);
        String direction = "left";
        assertTrue(ghost.isPosibleMove(direction));
    }
    @Test
    public void testIsPosibleMoveU() {
        Ghost ghost = new Ghost(300, 90, true);
        String direction = "up";
        assertTrue(ghost.isPosibleMove(direction));
    }

    @Test
    public void testIsPosibleMoveD() {
        Ghost ghost = new Ghost(300, 90, true);
        String direction = "down";
        assertTrue(ghost.isPosibleMove(direction));
    }

    @Test
    public void testGetRoute() {
        Ghost ghost = new Ghost(300, 90, true);
        Pacman pacman = new Pacman(300,300,true);
        String expected = "down";
        assertEquals(expected, ghost.getRoute(pacman));
    }

    @Test
    public void testGetRoute2() {
        Ghost ghost = new Ghost(270, 90, true);
        Pacman pacman = new Pacman(300,300,true);
        ghost.setDirectionNeedToGo("down");
        String expected = "right";
        assertEquals(expected, ghost.getRoute(pacman));
    }

    @Test
    public void testGetRoute3() {
        Ghost ghost = new Ghost(270, 90, true);
        Pacman pacman = new Pacman(300,300,true);
        ghost.setEatable(true);
        String rutax = "right";
        String rutay = "down";
        String expected = "right";
        assertEquals(expected, ghost.getRoute(pacman));
    }

    @Test
    public void testGetDirecctionX() {
        Ghost ghost = new Ghost(30, 30, true);
        Pacman pacman = new Pacman(300,300,true);
        assertEquals("right", ghost.getDirecctionX());
        ghost.setX(400);
    }

    @Test
    public void testGetDirecctionY() {
        Ghost ghost = new Ghost(30, 30, true);
        Pacman pacman = new Pacman(300,300,true);
        assertEquals("down", ghost.getDirecctionY());
        ghost.setX(400);
    }

    @Test
    public void testEatableChangeRoute() {
        Ghost ghost = new Ghost(270, 90, true);
        Pacman pacman = new Pacman(300,300,true);
        ghost.setEatable(true);
        String rutax = "right";
        String rutay = "down";
        String expected = "right";
        assertEquals(expected, ghost.eatableChangeRoute(rutax,rutay,pacman));
    }

    @Test
    public void testEatableChangeRoute2() {
        Ghost ghost = new Ghost(60, 270, true);
        Pacman pacman = new Pacman(300,300,true);
        ghost.setEatable(true);
        String rutax = "right";
        String rutay = "down";
        String expected = "left";
        assertEquals(expected, ghost.eatableChangeRoute(rutax,rutay,pacman));
    }

    @Test
    public void testSearchRouteGhost() {
        Ghost ghost = new Ghost(300, 90, true);
        Pacman pacman = new Pacman(300,300,true);
        String expected = "down";
        ghost.searchRouteGhost(pacman);
        assertEquals(expected, ghost.getDirection());
        ghost.setY(360);
        expected = "up";
        ghost.searchRouteGhost(pacman);
        assertEquals(expected, ghost.getDirection());
        pacman.setEatable();
        expected = "up";
        ghost.searchRouteGhost(pacman);
        assertEquals(expected, ghost.getDirection());
    }

    @Test
    public void testSearchRouteGhost2() {
        Ghost ghost = new Ghost(270, 90, true);
        Pacman pacman = new Pacman(270,270,true);
        String expected = "down";
        ghost.searchRouteGhost(pacman);
        assertEquals(expected, ghost.getDirection());
    }

    @Test
    public void testSearchRouteGhost3() {
        Ghost ghost = new Ghost(210, 30, true);
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
        Ghost ghost = new Ghost(300, 30, true);
        Pacman pacman = new Pacman(300,300,true);
        String expected = "down";
        assertEquals(expected, ghost.getRoutePosible("intersection", "down"));
    }

    @Test
    public void testRouteEscape() {
        Ghost ghost = new Ghost(300, 30, true);
        Pacman pacman = new Pacman(300,300,true);
        String expected = "left";
        assertEquals(expected, ghost.routeEscape("down"));
        expected = "down";
        assertEquals(expected, ghost.routeEscape("up"));
        expected = "right";
        assertEquals(expected, ghost.routeEscape("left"));
    }

}
