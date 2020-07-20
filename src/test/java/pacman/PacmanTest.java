import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;

public class PacmanTest{
	private ArrayList<Wall> walls = new ArrayList<Wall>();
	private ArrayList<Dot> dots = new ArrayList<Dot>();
	private ArrayList<Ghost> ghosts = new ArrayList<>();
	
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

	@Test
	public void testMove() {
		Pacman pacman = new Pacman(60, 60, true, walls, dots);
		String left = "left";
		String right = "right";
		String up = "up";
		String down = "down";
		assertEquals("pacmanLeft.gif", pacman.move(left));
		assertEquals("pacmanRight.gif", pacman.move(right));
		assertEquals("pacmanUp.gif", pacman.move(up));
		assertEquals("pacmanDown.gif", pacman.move(down));
	}

	@Test
	public void testExistWall() {
		Wall wall1 = new Wall(0, 0, true);
		walls.add(wall1);
		Pacman pacman = new Pacman(60, 60, true, walls, dots);
		assertEquals(false,pacman.existWall(30, 30));
		assertEquals(true, pacman.existWall(0, 0));
	}

	@Test
	public void testExistDot() {
		Dot dot = new Dot(60, 60, true);
		dots.add(dot);
		Pacman pacman = new Pacman(60, 60, true, walls, dots);
		assertEquals(false, pacman.existDot(77, 77));
		assertEquals(true,pacman.existDot(60, 60));
	}

	@Test
	public void testpacmanEatGhosts(){
		Ghost ghost = new Ghost(60, 60, true, walls);
		ghost.setEatable(true);
		Ghost ghost2 = new Ghost(60, 60, true, walls);
		ghost2.setEatable(false);
		ghosts.add(ghost);
		ghosts.add(ghost2);
		Pacman pacman = new Pacman(60, 60, true, walls, dots);
		pacman.pacmanEatGhosts(ghosts);
		assertEquals(false,ghost.doesnotExist());
		assertEquals(true,ghost2.doesExist());
	}

	@Test
	public void testpacmanEatDot() {
		Pacman pacman = new Pacman(60, 60, true, walls, dots);
		Ghost ghost = new Ghost(90, 60, true, walls);
		ghosts.add(ghost);
		Dot dot = new Dot(60, 60, true);
		assertEquals(1, pacman.pacmanEatDot(dot, ghosts, 1));
		Dot dotSpecial = new Dot(60, 60, true);
		dotSpecial.setSpecial();
		pacman.setNotEatable();
		ghost.changeEatable();
		assertNotEquals(0, pacman.pacmanEatDot(dotSpecial, ghosts, 1));
	}

	@Test 
	public void testIsEatable(){
		Pacman pacman = new Pacman(60, 60, true, walls, dots);
		boolean eatable = true;
		assertEquals(true, pacman.isEatable());
	}

	@Test
	public void testSetEatable() {
		Pacman pacman = new Pacman(60, 60, true, walls, dots);
		boolean eatable = false;
		pacman.setEatable();
		assertEquals(true, pacman.isEatable());
	}

	@Test
	public void testSetNotEatable() {
		Pacman pacman = new Pacman(60, 60, true, walls, dots);
		boolean eatable = false;
		pacman.setNotEatable();
		assertEquals(false, pacman.isEatable());
	}
}
