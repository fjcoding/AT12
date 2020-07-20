import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;

public class PacmanTest{
	private ArrayList<Wall> walls = new ArrayList<Wall>();
	private ArrayList<Dot> dots = new ArrayList<Dot>();
	
	@Test
	public void testMoveUp(){
        Pacman pacman = new Pacman(60, 60, true, walls, dots);
        pacman.up();
        assertEquals(30, pacman.getY());
	}
	
	@Test
	public void testMoveDown(){
        Pacman pacman = new Pacman(60, 60, true, walls, dots);
        pacman.down();
        assertEquals(90, pacman.getY());
	}
	
	@Test
	public void testMoveLeft(){
        Pacman pacman = new Pacman(60, 60, true, walls, dots);
        pacman.left();
        assertEquals(30, pacman.getX());
	}
	
	@Test
	public void testMoveRight(){
        Pacman pacman = new Pacman(60, 60, true, walls, dots);
        pacman.right();
		assertEquals(90, pacman.getX()); 
	}
}
