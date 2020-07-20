import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.*;
import org.junit.Test;

public class GhostTest {
    private ArrayList<Wall> walls = new ArrayList<Wall>();
    private ArrayList<Dot> dots = new ArrayList<Dot>();

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
    public void testExistPacmanEatable() {
        Ghost ghost = new Ghost(5, 5, true, walls);
        Pacman pacman = new Pacman(5, 5, true, walls, dots);
        boolean resultToCompare = ghost.existPacmanEatable(pacman);
        assertEquals(true, resultToCompare);
    }

    @Test
    public void testEatPacman() {
        Ghost ghost = new Ghost(5, 5, true, walls);
        Pacman pacman = new Pacman(5, 5, true, walls, dots);
        ghost.eatPacman(pacman);
        assertFalse(pacman.doesExist());
    }

    @Test
    public void testIsPosibleMoveDown() {
        Ghost ghost = new Ghost(5, 5, true, walls);
        assertTrue(ghost.isPosibleMoveDown(walls));
    }

    @Test
    public void testIsPosibleMoveUp() {
        Ghost ghost = new Ghost(5, 5, true, walls);
        assertTrue(ghost.isPosibleMoveUp(walls));
    }

    @Test
    public void testIsPosibleMoveRight() {
        Ghost ghost = new Ghost(5, 5, true, walls);
        assertTrue(ghost.isPosibleMoveRight(walls));
    }

    @Test
    public void testIsPosibleMoveLeft() {
        Ghost ghost = new Ghost(5, 5, true, walls);
        assertTrue(ghost.isPosibleMoveLeft(walls));
    }

    @Test
    public void testGetDirectionX() {
        Ghost ghost = new Ghost(5, 5, true, walls);
        String expected = "right";
        assertEquals(expected, ghost.getDirecctionX());
    }

    @Test
    public void testGetDirectionY() {
        Ghost ghost = new Ghost(5, 5, true, walls);
        String expected = "up";
        assertEquals(expected, ghost.getDirecctionY());
    }
}
