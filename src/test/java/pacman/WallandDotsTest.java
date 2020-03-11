import static org.junit.Assert.*;

import org.junit.Test;

public class WallandDotsTest {
	@Test
	public void testExist(){
        int x=1;
        int y=1;
		wall wall1_1 = new wall(x,y, true);
        //wall1_1.positionObj(1,2);
        assertEquals(1,wall1_1.getY());
        assertEquals(1,wall1_1.getX());
    }
}