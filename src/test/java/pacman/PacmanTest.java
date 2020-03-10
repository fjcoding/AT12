import static org.junit.Assert.*;

import org.junit.Test;

public class PacmanTest {
	@Test
	public void testMoveUp(){
		
		pacman p = new pacman(5,5, true);
		p.up();
		assertEquals(4,p.getY());
	}
}
