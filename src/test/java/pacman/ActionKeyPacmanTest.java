import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;
import java.awt.event.KeyEvent;

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
}
