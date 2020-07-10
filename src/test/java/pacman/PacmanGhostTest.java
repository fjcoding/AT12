import static org.junit.Assert.*;
import org.junit.Test;

public class PacmanGhostTest{
	
	@Test
	public void testPacmanNotEatGhost(){
		Pacman p = new Pacman(5, 5, true);
		Ghost g = new Ghost(5, 5, true);	
		assertEquals(false, p.isEatable(g));	
	}

	@Test
	public void testPacmanEatGhost(){
		Pacman p = new Pacman(5, 5, true);
		Ghost g = new Ghost(5, 5, true);
		g.changeEatable();		
		assertEquals(true, p.isEatable(g));
	}
}
