import java.util.ArrayList;
public class GhostCreator {

    private static final int CANT_GHOST = 4;
    public static final int POS_GHOST_1_X = 30;
    public static final int POS_GHOST_2_Y = 180;
    public static final int POS_GHOST_3_Y = 60;
    public static final int POS_GHOST_4_X = 210;
    private ArrayList<Ghost> ghosts = new ArrayList<Ghost>();
    public ArrayList<Ghost> createGhots() {
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