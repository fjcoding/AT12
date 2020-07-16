import static org.junit.Assert.*;

import java.util.*;
import org.junit.Test;

public class GhostTest {
    private ListWalls listWalls = new ListWalls();
    private ArrayList<Position> walls = listWalls.getWalls();

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
        assertFalse(ghost.getExist());
    }

    @Test
    public void testLive() {
        Ghost ghost = new Ghost(5, 5, false);
        ghost.live();
        assertTrue(ghost.getExist());
    }

    @Test
    public void testExistPacmanEatable() {
        Ghost g = new Ghost(5, 5, true);
        Pacman p = new Pacman(5, 5, true);
        boolean resultToCompare = g.existPacmanEatable(p);
        assertEquals(true, resultToCompare);
    }

    @Test
    public void testEatPacman() {
        Ghost ghost = new Ghost(5, 15, true);
        Pacman pacman = new Pacman(5, 5, true);
        ghost.eatPacman(pacman);
        assertFalse(pacman.getExist());
    }

    @Test
    public void testIsPosibleMoveDown() {
        Ghost ghost = new Ghost(60, 60, true);
        assertTrue(ghost.isPosibleMoveDown(walls));
    }

    @Test
    public void testIsPosibleMoveUp() {
        Ghost ghost = new Ghost(60, 60, true);
        assertFalse(ghost.isPosibleMoveUp(walls));
    }

    @Test
    public void testIsPosibleMoveRight() {
        Ghost ghost = new Ghost(60, 60, true);
        assertTrue(ghost.isPosibleMoveRight(walls));
    }

    @Test
    public void testIsPosibleMoveLest() {
        Ghost ghost = new Ghost(60, 60, true);
        assertFalse(ghost.isPosibleMoveLeft(walls));
    }

    @Test
    public void testGetDirectionX() {
        Ghost ghost = new Ghost(60, 60, true);
        String expected = "right";
        assertEquals(expected, ghost.getDirecctionX());
    }

    @Test
    public void testGetDirectionY() {
        Ghost ghost = new Ghost(60, 60, true);
        String expected = "down";
        assertEquals(expected, ghost.getDirecctionY());
    }
}
