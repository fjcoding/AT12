import static org.junit.Assert.*;
import org.junit.Test;

public class PacmanTest{

	@Test
	public void testMoveUp() {
        Pacman pacman = new Pacman(60, 60, true);
        pacman.up();
		assertEquals(30, pacman.getY());
	}
	
	@Test
	public void testMoveDown() {
        Pacman pacman = new Pacman(60, 60, true);
        pacman.down();
        assertEquals(90, pacman.getY());
	}
	
	@Test
	public void testMoveLeft() {
        Pacman pacman = new Pacman(60, 60, true);
        pacman.left();
        assertEquals(30, pacman.getX());
	}
	
	@Test
	public void testMoveRight() {
        Pacman pacman = new Pacman(30, 30, true);
        pacman.right();
        assertEquals(60, pacman.getX());
	}
}
