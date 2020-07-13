import static org.junit.Assert.*;
import org.junit.Test;

public class PacmanDieTest {

    @Test
	public void testPacmanDie() {
		Pacman p = new Pacman(5, 5, true);
		assertEquals(true, p.die());	
	}

	@Test
	public void testPacmanDoesNotExist() {
		Pacman p = new Pacman(5, 5, false);	
		assertEquals(false, p.die());		
	}
}