import static org.junit.Assert.*;

import org.junit.Test;

public class GhostTest {
	@Test
	public void testMoveUp(){
		Ghost g = new Ghost(0,30, true);
		g.moveUp();
		assertEquals(0,g.getY());
	}
	
	@Test
	public void testMoveDown(){
		Ghost g = new Ghost(5,5, true);
		g.moveDown();
		assertEquals(35,g.getY());
	}
	
	@Test
	public void testMoveLeft(){
		Ghost g = new Ghost(30,5, true);
		g.moveLeft();
		assertEquals(0,g.getX());
	}
	
	@Test
	public void testMoveRight(){
		Ghost g = new Ghost(5,5, true);
		g.moveRight();
		assertEquals(35,g.getX());
	}

	@Test
	public void testIsPosible(){
		Ghost g = new Ghost(5,5, true);
		g.moveRight();
		assertEquals(35,g.getX());
	}
}
