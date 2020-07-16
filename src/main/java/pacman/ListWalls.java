import java.util.ArrayList;

public class ListWalls {

    private ArrayList<Position> walls;
    public static final int NUMBER_ZERO = 0;
    public static final int PIXEL_SIZE = 30;
    public static final int SCENARIO_SIZE = 870;
    public static final int[] WALL_POSITIONS_X = {90, 150, 180, 210, 240, 270, 330, 360, 390, 420, 450, 480, 510, 570, 630, 690, 720, 750, 780 };
    public static final int[] WALL_POSITIONS_Y = {60, 120, 570, 450, 780, 150, 840, 180, 240, 300, 360, 420, 720, 480, 540, 600, 810 };

    public ListWalls() {
        walls = new ArrayList<>();
        addWall();
    }

   /**
    *  Draw the map
   */
    public void addWall() {

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
    }

    /**
     @return  ArrayList<Position> walls
    */
    public ArrayList<Position> getWalls() {
        return walls;
    }
}
