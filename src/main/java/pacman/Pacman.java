import java.util.ArrayList;

class Pacman extends Position {
    private boolean eatable;
    protected ArrayList <Dot> dots;
    protected ArrayList<Position> walls;
    public ListWalls lWall;

    public Pacman (int x, int y, boolean exist) {
        super(x, y, exist);
        eatable = true;
        lWall = new ListWalls();
        walls = new ArrayList<Position>(); 
        walls= lWall.getWalls();
        dots = new ArrayList<Dot>();
        addDots();
    }
    
    public boolean isEatable() {
        return this.eatable;
    }

    public void setNotEatable() {
        this.eatable = false;
    }

    public void setEatable() {
        this.eatable = true;
    }

    public void die() {
        this.exist = false;
    }
    //functions those add and substract pacman's positions	
    public int down() {
        if (existWall(x, y+30)) {
            return super.y = y;
        } else {
            return super.y += 30;
        }
    }
    
    public int right() {
        if (existWall(x+30, y)) {
            return super.x = x;
        } else {
            return super.x += 30;
        }
    }
    
    public int left() {
        if (existWall(x-30, y)) {
            return super.x = x;
        } else {
            return super.x -= 30;
        }
    }
    
    public int up() {
        if (existWall(x, y-30)) {
            return super.y = y;
        } else {
            return super.y -= 30;
        }
    }

    public boolean existWall(int xx, int yy) {
        ListWalls lWall = new ListWalls();
        ArrayList<Position> walls = lWall.getWalls();
        boolean exist = false;
        for (Position wall: walls) {
            if (wall.getX()==xx && wall.getY()==yy)
                exist= true;
        }
        return exist;
    }
    //Check if there is a dot in x and y position
    public boolean existDot(int positionx, int positiony) {
        boolean exist = false;
        for(Position i : dots){
            if(i.getX() == positionx && i.getY() == positiony)
                exist = true;
        }
        return exist;
    }
    
    public void addDots() {
        boolean draw = true;
        for(int iy = 1; iy < 29; iy++) {
            for(int ix = 1; ix < 29; ix++) {
                for(Position wall : walls) {
                    if((wall.getX() == ix * 30) && (wall.getY() == iy * 30)) {
                        draw = false;
                        break;
                    }
                }
                if(draw == true) {
                    dots.add(new Dot(ix * 30, iy * 30, true));
                }
                draw = true;
            }
        }
        //The next lines change isSpecial attribute of Dot to true, at specific positions.
        dots.get(0).setSpecial();
        dots.get(27).setSpecial();
        dots.get(67).setSpecial();
        dots.get(77).setSpecial();
        dots.get(78).setSpecial();
        dots.get(113).setSpecial();
        dots.get(178).setSpecial();
        dots.get(223).setSpecial();
        dots.get(228).setSpecial();
        dots.get(238).setSpecial();
        dots.get(257).setSpecial();
        dots.get(294).setSpecial();
        dots.get(353).setSpecial();
        dots.get(dots.size() - 27).setSpecial();
        dots.get(dots.size() - 16).setSpecial();
        dots.get(dots.size() - 15).setSpecial();
        dots.get(dots.size() - 1).setSpecial();
    }

    public ArrayList<Dot> getDots() {
        return dots;
    }

    public boolean isEatable(Dot dotsPosition){
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
        if ((super.getX()==ghostPosition.getX()) && 
            (super.getY()==ghostPosition.getY()) &&
             ghostPosition.isEatable()) {
            return true;
        } else {
            super.exist = false;
            return false;
        }
    }
}