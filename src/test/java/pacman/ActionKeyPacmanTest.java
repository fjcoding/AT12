import static org.junit.Assert.*;
import org.junit.Test;
import java.awt.event.KeyEvent;
import static org.mockito.Mockito.*;

public class ActionKeyPacmanTest {

	@Test
	public void testAssignMovement() {
		DrawComponents dComponents = new DrawComponents();
		ActionKeyPacman action =  new ActionKeyPacman(dComponents);
		int keyRight = 39;
		int keyLeft = 37;
		int keyDown = 40;
		int keyUp = 38;
		assertEquals("right", action.assignMovement(keyRight));
		assertEquals("left", action.assignMovement(keyLeft));
		assertEquals("down", action.assignMovement(keyDown));
		assertEquals("up", action.assignMovement(keyUp));
	}
	@Test
	public void testKeyPressed() {
		DrawComponents dComponents = new DrawComponents();
		ActionKeyPacman action =  new ActionKeyPacman(dComponents);
		KeyEvent event = mock(KeyEvent.class);
		action.keyPressed(event);
		int y =event.getKeyCode();
		assertEquals("left", action.assignMovement(event.VK_LEFT));
		assertEquals("right", action.assignMovement(event.VK_RIGHT));
		assertEquals("down", action.assignMovement(event.VK_DOWN));
		assertEquals("up", action.assignMovement(event.VK_UP));
		assertNotEquals("hoi", action.assignMovement(y));
	}
}
