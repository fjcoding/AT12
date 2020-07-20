import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;

public class PacmanGhostTest{
	
	private ArrayList<Wall> walls = new ArrayList<Wall>();
    private ArrayList<Dot> dots = new ArrayList<Dot>();
	@Test
	public void testPacmanNotEatGhost(){
		Pacman p = new Pacman(5, 5, true, walls, dots);
		Ghost g = new Ghost(5, 5, true, walls);	
		assertEquals(false, p.isEatable(g));	
	}

	@Test
	public void testPacmanEatGhost(){
		Pacman p = new Pacman(5, 5, true, walls, dots);
		Ghost g = new Ghost(5, 5, true, walls);
		g.changeEatable();		
		assertEquals(true, p.isEatable(g));
	}
}
