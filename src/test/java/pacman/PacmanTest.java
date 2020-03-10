import static org.junit.Assert.*;

import org.junit.Test;

public class PacmanTest {
	@Test
	public void testMoveUp(){
		pacman p = new pacman(5,5, true);
		p.up();
		assertEquals(4,p.getY());
	}
	
	@Test
	public void testMoveDown(){
		pacman p = new pacman(5,5, true);
		p.down();
		assertEquals(6,p.getY());
	}
	
	@Test
	public void testMoveLeft(){
		pacman p = new pacman(5,5, true);
		p.left();
		assertEquals(4,p.getX());
	}
	
	@Test
	public void testMoveRight(){
		pacman p = new pacman(5,5, true);
		p.right();
		assertEquals(6,p.getX());
	}
}
