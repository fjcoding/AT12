import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.*;
import org.junit.Test;

public class CreatorTest {
    private ArrayList<Wall> walls;
    private ArrayList<Dot> dots;
    private ArrayList<Ghost> ghosts;
    Creator creator;
    @Test
    public void testCreateWalls() {
        creator = new Creator();
        walls = creator.createWalls();
        assertTrue(walls.size() > 0);
    }

    @Test
    public void testCreateGhosts() {
        creator = new Creator();
        walls = creator.createWalls();
        ghosts = creator.createGhost(walls);
        assertTrue(ghosts.size() > 0);  
    }

    @Test
    public void testCreateDots() {
        creator = new Creator();
        walls = creator.createWalls();
        dots = creator.createDots(walls);
        assertTrue(dots.size() > 0);  
    }
}
