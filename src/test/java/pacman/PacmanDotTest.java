import static org.junit.Assert.*;
import org.junit.Test;

public class PacmanDotTest{
	
	@Test
	public void testFood(){
		Pacman p = new Pacman(5, 5, true);
		Dot   f = new Dot(5,5,true);		
		assertEquals(true,p.isEatable(f));	
	}

	@Test
	public void testFoodNoExists(){
		Pacman p = new Pacman(5, 5, true);
		Dot   f = new Dot(5,5,false);		
		assertEquals(false,p.isEatable(f));		
	}
	
	@Test
	public void testFoodNoEatable(){
		Pacman p = new Pacman(5, 5, true);
		Dot   f = new Dot(5, 4, true);	
		assertEquals(false,p.isEatable(f));		
	}
	
	@Test
	public void testFoodGhostNoEatable(){
		Pacman p = new Pacman(5, 5, true);
		Ghost   g = new Ghost(5, 5, true);	
		assertEquals(false,p.isEatable(g));	
	}

	@Test
	public void testFoodGhostEatable(){
		Pacman p = new Pacman(5, 5, true);
		Ghost   g = new Ghost(5, 5, true);
		g.changeEatable();		
		assertEquals(true,p.isEatable(g));		
	}

	
	
	



	
	
	

}
