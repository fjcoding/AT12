import static org.junit.Assert.*;

import org.junit.Test;

public class PacmanFoodTest {
	@Test
	public void testFood(){
		pacman p = new pacman(5,5, true);
		food   f = new food(5,5,true);
		
		assertEquals(true,p.isEatable(f));
	}

	@Test
	public void testFoodNoExists(){
		pacman p = new pacman(5,5, true);
		food   f = new food(5,5,false);
		
		assertEquals(false,p.isEatable(f));
	}
	@Test
	public void testFoodNoEatable(){
		pacman p = new pacman(5,5, true);
		food   f = new food(5,4,true);
		
		assertEquals(false,p.isEatable(f));
	}
	@Test
	public void testFoodGhostNoEatable(){
		pacman p = new pacman(5,5, true);
		ghost   g = new ghost(5,5,true);
		
		assertEquals(false,p.isEatable(g));
	}

	@Test
	public void testFoodGhostEatable(){
		pacman p = new pacman(5,5, true);
		ghost   g = new ghost(5,5,true);
		g.changeEatable();
		
		assertEquals(true,p.isEatable(g));
	}

	
	
	



	
	
	

}
