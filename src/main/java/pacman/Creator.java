import java.util.ArrayList;
public class Creator {

    private static final int CANT_GHOST = 4;
    public static final int POS_GHOST_1_X = 30;
    public static final int POS_GHOST_2_Y = 150;
    public static final int POS_GHOST_3_Y = 90;
    public static final int POS_GHOST_4_X = 210;
    private ArrayList<Ghost> ghosts = new ArrayList<Ghost>();

   /**
    *  Create ghost on arraylist
   */
    public ArrayList<Ghost> createGhost() {
        for (int i = 1; i <= CANT_GHOST; i++) {
            if (i % 2 == 0) {
                ghosts.add(new Ghost(i * POS_GHOST_1_X, i * POS_GHOST_2_Y, true));
            } else {
                ghosts.add(new Ghost(i * POS_GHOST_4_X, i * POS_GHOST_3_Y, true));
            }
        }
        return ghosts;
    }
}
