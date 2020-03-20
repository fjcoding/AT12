import static org.junit.Assert.*;
import org.junit.Test;

public class PacmanTest{
	
	@Test
	public void testMoveUp(){
		Pacman pacman = new Pacman(60, 60, true);
		assertEquals(30, pacman.up());
	}
	
	@Test
	public void testMoveDown(){
		Pacman pacman = new Pacman(60, 60, true);
		assertEquals(90, pacman.down());
	}
	
	@Test
	public void testMoveLeft(){
		Pacman pacman = new Pacman(60, 60, true);
		assertEquals(30, pacman.left());
	}
	
	@Test
	public void testMoveRight(){
		Pacman pacman = new Pacman(60, 60, true);
		assertEquals(90, pacman.right());
	}
}
