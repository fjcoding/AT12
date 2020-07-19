import java.util.ArrayList;
public class Creator {
    //constants used by createGhosts().
    private static final int CANT_GHOST = 4;
    public static final int POS_GHOST_1_X = 30;
    public static final int POS_GHOST_2_Y = 180;
    public static final int POS_GHOST_3_Y = 60;
    public static final int POS_GHOST_4_X = 210;
    //constants used by createWalls().
    public static final int NUMBER_ZERO = 0;
    public static final int PIXEL_SIZE = 30;
    public static final int SCENARIO_SIZE = 870;
    public static final int[] WALL_POSITIONS_X = {90, 150, 180, 210, 240, 270, 330, 360, 390, 420, 450, 480, 510, 570, 630, 690, 720, 750, 780 };
    public static final int[] WALL_POSITIONS_Y = {60, 120, 570, 450, 780, 150, 840, 180, 240, 300, 360, 420, 720, 480, 540, 600, 810 };
    //constants used by createDots().
    private static final int[] INDEX_OF_SPECIAL_DOTS = {0, 27, 67, 77, 78, 113, 178, 223, 228, 238, 257, 294, 353, 400, 420, 430, 450};

    private static final int FRAME_X_SIZE = 30;
    private static final int FRAME_Y_SIZE = 30;
    private static final int POSITION_DIMENSION = 30;
    //ArrayLists used by add new objects.
    private ArrayList<Ghost> ghosts = new ArrayList<Ghost>();
    private ArrayList<Dot> dots = new ArrayList<Dot>();
    private ArrayList<Wall> walls = new ArrayList<Wall>();
   /**
    *  Create ghost on arraylist
   */
    public ArrayList<Ghost> createGhost(final ArrayList<Wall> wallsCreated) {
        for (int i = 1; i <= CANT_GHOST; i++) {
            if (i % 2 == 0) {
                ghosts.add(new Ghost(i * POS_GHOST_1_X, i * POS_GHOST_2_Y, true, wallsCreated));
            } else {
                ghosts.add(new Ghost(i * POS_GHOST_4_X, i * POS_GHOST_3_Y, true, wallsCreated));
            }
        }
        return ghosts;
    }

    /**
    *  Create walls on arraylist
    */
    public ArrayList<Wall> createWalls() {
        for (int i = 0; i <= SCENARIO_SIZE; i += PIXEL_SIZE) {
            walls.add(new Wall(NUMBER_ZERO, i, true)); // left
            walls.add(new Wall(i, NUMBER_ZERO, true)); // up
            walls.add(new Wall(SCENARIO_SIZE, SCENARIO_SIZE - i, true)); // right
            walls.add(new Wall(SCENARIO_SIZE - i, SCENARIO_SIZE, true)); // down
        }
        for (int i = NUMBER_ZERO; i < SCENARIO_SIZE; i++) {
            int randX = i % WALL_POSITIONS_X.length;
            int randY = i % WALL_POSITIONS_Y.length;

            walls.add(new Wall(WALL_POSITIONS_X[randX], WALL_POSITIONS_Y[randY], true));
        }
        return walls;
    }

    /**
    *  Create dots and special dots on arraylist
    */
    public ArrayList<Dot> createDots(final ArrayList<Wall> wallsCreated) {
        boolean draw = true;
        for (int iy = 1; iy < FRAME_Y_SIZE - 1; iy++) {
            for (int ix = 1; ix < FRAME_X_SIZE - 1; ix++) {
                for (Position wall : wallsCreated) {
                    if ((wall.getX() == ix * POSITION_DIMENSION) && (wall.getY() == iy * POSITION_DIMENSION)) {
                        draw = false;
                        break;
                    }
                }
                if (draw) {
                    dots.add(new Dot(ix * POSITION_DIMENSION, iy * POSITION_DIMENSION, true));
                }
                draw = true;
            }
        }
        //Change isSpecial attribute of Dot to true, at specific positions.
        for (int index : INDEX_OF_SPECIAL_DOTS) {
            dots.get(index).setSpecial();
        }
        return dots;
    }
}
