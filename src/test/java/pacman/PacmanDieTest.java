import static org.junit.Assert.*;

import org.junit.Test;

public class PacmanDieTest {

    @Test
    public void testPacmanDie() {
        Pacman p = new Pacman(5, 5, true);
        p.die();
        assertFalse(p.doesExist());
    }
}
