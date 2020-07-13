import java.util.ArrayList;

class Pacman extends Position {
    protected ArrayList<Position> walls;

    public Pacman(int x, int y, boolean exist) {
        super(x, y, exist);
        walls = new ArrayList<Position>();
        addWall();
    }

    //functions those add and substract pacman's positions
    public int down() {
        if (existDistintPacman(x, y + 30)) {
        return super.y = y;
        } else {
        return super.y += 30;
        }
    }

    public int right() {
        if (existDistintPacman(x + 30, y)) {
        return super.x = x;
        } else {
        return super.x += 30;
        }
    }

    public int left() {
        if (existDistintPacman(x - 30, y)) {
        return super.x = x;
        } else {
        return super.x -= 30;
        }
    }

    public int up() {
        if (existDistintPacman(x, y - 30)) {
        return super.y = y;
        } else {
        return super.y -= 30;
        }
    }

    public boolean existDistintPacman(int xx, int yy) {
        boolean exist = false;
        for (Position i : walls) {
        if (i.getX() == xx && i.getY() == yy) exist = true;
        }
        return exist;
    }

    public void addWall() {
        for (int i = 0; i < 900; i += 30) {
        walls.add(new Wall(0, i, true)); //left
        walls.add(new Wall(i, 0, true)); //up
        }
        for (int i = 870; i > 0; i -= 30) {
        walls.add(new Wall(870, i, true)); //right
        walls.add(new Wall(i, 870, true)); //down
        }
        walls.add(new Wall(660, 570, true));
        walls.add(new Wall(150, 450, true));
        walls.add(new Wall(600, 780, true));
        walls.add(new Wall(630, 780, true));
        walls.add(new Wall(690, 780, true));
        walls.add(new Wall(750, 780, true));
        walls.add(new Wall(810, 780, true));
        walls.add(new Wall(390, 750, true));
        walls.add(new Wall(390, 780, true));
        walls.add(new Wall(390, 840, true));

        for (int i = 60; i < 840; i += 30) {
        if (i != 180 && i != 690) walls.add(new Wall(i, 60, true)); //row2
        if (i != 90 && i != 270) walls.add(new Wall(i, 120, true)); //row3
        }
        for (int i = 300; i < 840; i += 30) {
        if (i != 390 && i != 510 && i != 570) walls.add(new Wall(i, 180, true)); // row4
        }
        for (int i = 450; i < 840; i += 30) {
        if (i != 510 && i != 570 && i != 630 && i != 780) walls.add(
            new Wall(i, 240, true)
        ); // row5
        }
        for (int i = 630; i < 810; i += 30) {
        if (i != 630 && i != 780) walls.add(new Wall(i, 300, true)); // row6
        if (i != 780) walls.add(new Wall(i, 360, true)); // row7
        walls.add(new Wall(i, 420, true)); //row8
        walls.add(new Wall(i, 720, true)); //row13
        if (i != 630) {
            walls.add(new Wall(i, 480, true)); // row9
            walls.add(new Wall(i, 540, true)); //row10
            walls.add(new Wall(i, 600, true)); //row11
            walls.add(new Wall(i, 660, true)); //row12
        }
        }
        for (int i = 60; i < 840; i += 30) {
        if (
            i != 180 && i != 360 && i != 420 && i != 660 && i != 720 && i != 780
        ) walls.add(new Wall(i, 810, true)); //row14
        }

        for (int i = 120; i < 750; i += 30) {
        if (i == 360 || i == 630) {} else walls.add(new Wall(60, i, true)); // column 2
        walls.add(new Wall(120, i, true)); // column 3
        if (i != 150 && i != 270 && i != 420 && i != 480) walls.add(
            new Wall(180, i, true)
        ); // column4
        walls.add(new Wall(240, i, true)); // column 5
        if (i != 150 && i != 240 && i != 510) walls.add(new Wall(300, i, true)); //column 6
        if (i != 150 && i != 690) walls.add(new Wall(360, i, true)); // column7
        if (i != 150 && i != 270 && i != 570 && i != 720 && i != 750) walls.add(
            new Wall(420, i, true)
        ); //column8
        if (i != 150 && i != 210 && i != 450) walls.add(new Wall(480, i, true)); // column 9
        walls.add(new Wall(540, i, true)); //column10
        if (i != 150 && i != 330 && i != 390 && i != 750) walls.add(
            new Wall(600, i, true)
        ); // column11
        if (i != 150 && i != 450 && i != 570 && i != 690 && i != 750) walls.add(
            new Wall(810, i, true)
        ); // column12
        }
    }

    public ArrayList<Position> getWalls() {
        return walls;
    }

    public boolean isEatable(Dot dotsPosition) {
        if (
        (super.getX() == dotsPosition.getX()) &&
        (super.getY() == dotsPosition.getY()) &&
        dotsPosition.exist
        ) {
        dotsPosition.exist = false;
        return true;
        }
        return false;
    }

    public boolean isEatable(Ghost ghostPosition) {
        if (
        (super.getX() == ghostPosition.getX()) &&
        (super.getY() == ghostPosition.getY()) &&
        ghostPosition.isEatable()
        ) {
        return true;
        } else {
        super.exist = false;
        return false;
        }
    }
}
