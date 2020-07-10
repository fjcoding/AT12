import static org.junit.Assert.*;
import org.junit.Test;

public class WallsTest {
    @Test
	public void testWall(){
		Wall w = new Wall(5, 5, true);		
        assertEquals(5,w.getX());
        assertEquals(5,w.getY());	
        assertEquals(true,w.exist);
	}
}