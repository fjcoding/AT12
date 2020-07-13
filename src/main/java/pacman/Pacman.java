import java.util.ArrayList;

class Pacman extends Position {

    protected ArrayList <Position> walls;
    public ListWalls lWall;

    public Pacman (int x, int y, boolean exist){
        super(x, y, exist);
        lWall = new ListWalls();
        walls = new ArrayList<Position>(); 
        walls= lWall.getWalls();
    }
    
    //functions those add and substract pacman's positions	
    public int down() {
        if(existWall(x, y+30)){
            return super.y = y;
        }else{
            return super.y += 30;
        }
    }
    
    public int right(){
        if(existWall(x+30, y)){
            return super.x = x;
        }else{
            return super.x += 30;
        }
    }
    
    public int left(){
        if(existWall(x-30, y)){
            return super.x = x;
        }else{
            return super.x -= 30;
        }
    }
    
    public int up(){
        if(existWall(x, y-30)){
            return super.y = y;
        }else{
            return super.y -= 30;
        }
    }

    public boolean existWall(int xx, int yy) {
        boolean exist=false;
        for(Position i: walls) {
            if(i.getX() ==xx && i.getY()==yy)
                exist= true;
        }
        return exist;
    }

    
    public boolean isEatable(Dot dotsPosition){
        if((super.getX() == dotsPosition.getX()) && (super.getY() == dotsPosition.getY()) && dotsPosition.exist){
            dotsPosition.exist = false;
            return true;
        }
            return false;
    }

    public boolean isEatable(Ghost ghostPosition){
        if((super.getX() == ghostPosition.getX()) && (super.getY() == ghostPosition.getY()) && ghostPosition.isEatable()){
            return true;		
        } else {

            super.exist = false;
            return false;
        }
    }
}