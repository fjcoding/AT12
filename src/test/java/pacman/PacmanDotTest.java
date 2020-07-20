import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;

public class PacmanDotTest {
	
	private ArrayList<Wall> walls = new ArrayList<Wall>();
    private ArrayList<Dot> dots = new ArrayList<Dot>();
	@Test
	public void testFoodIsEatable() {
		Pacman p = new Pacman(5, 5, true, walls, dots);
		Dot f = new Dot(5, 5, true);		
		assertEquals(true, p.isEatable(f));	
	}

	@Test
	public void testFoodDoesNotExist() {
		Pacman p = new Pacman(5, 5, true, walls, dots);
		Dot f = new Dot(5, 5, false);		
		assertEquals(false, p.isEatable(f));		
	}

	@Test
	public void testFoodIsSpecial() {
		Dot f = new Dot(5, 5, false);
		f.setSpecial();
		assertEquals(true, f.isSpecialDot());		
	}

	@Test
	public void testFoodIsNotSpecial() {
		Dot f = new Dot(5, 5, false);
		assertEquals(false, f.isSpecialDot());		
	}

	@Test
	public void testGhostIsNotEatable() {
		Pacman p = new Pacman(5, 5, true, walls, dots);
		Ghost  g = new Ghost(5, 5, true, walls);	
		assertEquals(false,p.isEatable(g));	
	}

	@Test
	public void testGhostIsEatable() {
		Pacman p = new Pacman(5, 5, true, walls, dots);
		Ghost   g = new Ghost(5, 5, true, walls);
		g.changeEatable();		
		assertEquals(true,p.isEatable(g));
	}
    
}
