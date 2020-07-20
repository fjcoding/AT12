import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;

public class PacmanDieTest {

    private ArrayList<Wall> walls = new ArrayList<Wall>();
    private ArrayList<Dot> dots = new ArrayList<Dot>();
    @Test
    public void testPacmanDie() {
        Pacman p = new Pacman(5, 5, true, walls, dots);
        p.die();
        assertFalse(p.doesExist());
    }
}
