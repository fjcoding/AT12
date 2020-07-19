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
    private final int INDEX_OF_SPECIAL_DOT_0 = 0;
    private final int INDEX_OF_SPECIAL_DOT_1 = 27;
    private final int INDEX_OF_SPECIAL_DOT_2 = 67;
    private final int INDEX_OF_SPECIAL_DOT_3 = 77;
    private final int INDEX_OF_SPECIAL_DOT_4 = 78;
    private final int INDEX_OF_SPECIAL_DOT_5 = 113;
    private final int INDEX_OF_SPECIAL_DOT_6 = 178;
    private final int INDEX_OF_SPECIAL_DOT_7 = 223;
    private final int INDEX_OF_SPECIAL_DOT_8 = 228;
    private final int INDEX_OF_SPECIAL_DOT_9 = 238;
    private final int INDEX_OF_SPECIAL_DOT_10 = 257;
    private final int INDEX_OF_SPECIAL_DOT_11 = 294;
    private final int INDEX_OF_SPECIAL_DOT_12 = 353;
    private final int INDEX_OF_SPECIAL_DOT_13 = 400;
    private final int INDEX_OF_SPECIAL_DOT_14 = 420;
    private final int INDEX_OF_SPECIAL_DOT_15 = 430;
    private final int INDEX_OF_SPECIAL_DOT_16 = 450;
    private final int FRAME_X_SIZE = 30;
    private final int FRAME_Y_SIZE = 30;
    private final int POSITION_DIMENSION = 30;
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
        //The next lines change isSpecial attribute of Dot to true, at specific positions.
        dots.get(INDEX_OF_SPECIAL_DOT_0).setSpecial();
        dots.get(INDEX_OF_SPECIAL_DOT_1).setSpecial();
        dots.get(INDEX_OF_SPECIAL_DOT_2).setSpecial();
        dots.get(INDEX_OF_SPECIAL_DOT_3).setSpecial();
        dots.get(INDEX_OF_SPECIAL_DOT_4).setSpecial();
        dots.get(INDEX_OF_SPECIAL_DOT_5).setSpecial();
        dots.get(INDEX_OF_SPECIAL_DOT_6).setSpecial();
        dots.get(INDEX_OF_SPECIAL_DOT_7).setSpecial();
        dots.get(INDEX_OF_SPECIAL_DOT_8).setSpecial();
        dots.get(INDEX_OF_SPECIAL_DOT_9).setSpecial();
        dots.get(INDEX_OF_SPECIAL_DOT_10).setSpecial();
        dots.get(INDEX_OF_SPECIAL_DOT_11).setSpecial();
        dots.get(INDEX_OF_SPECIAL_DOT_12).setSpecial();
        dots.get(INDEX_OF_SPECIAL_DOT_13).setSpecial();
        dots.get(INDEX_OF_SPECIAL_DOT_14).setSpecial();
        dots.get(INDEX_OF_SPECIAL_DOT_15).setSpecial();
        dots.get(INDEX_OF_SPECIAL_DOT_16).setSpecial();
        return dots;
    }
}
