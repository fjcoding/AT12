import java.util.ArrayList;

class Pacman extends Position {

    protected ArrayList <Position> walls;

    public Pacman (int x, int y, boolean exist){
        super(x, y, exist);
        walls = new ArrayList<Position>(); 
        addWall();
    }
    
    //functions those add and substract pacman's positions	
    public int down(){
        if(existDistintPacman(x, y+30)){
            return super.y = y;
        }else{
            return super.y += 30;
        }
    }
    
    public int right(){
        if(existDistintPacman(x+30, y)){
            return super.x = x;
        }else{
            return super.x += 30;
        }
    }
    
    public int left(){
        if(existDistintPacman(x-30, y)){
            return super.x = x;
        }else{
            return super.x -= 30;
        }
    }
    
    public int up(){
        if(existDistintPacman(x, y-30)){
            return super.y = y;
        }else{
            return super.y -= 30;
        }
    }

    public boolean existDistintPacman(int xx, int yy){
        boolean exist=false;
        for(Position i: walls){
            if(i.getX() ==xx && i.getY()==yy)
                exist= true;
        }
        return exist;
    }

    public void addWall(){
        for (int i=0; i<900; i+=30){
            walls.add(new Wall(0,i, true));//izquierda
            walls.add(new Wall(i,0, true));//arriba
        }
        for (int i=870; i>0; i-=30){
            walls.add(new Wall(870,i, true));// derecha
            walls.add(new Wall(i,870, true));// abajo
        } 
    }
    public ArrayList<Position> getWalls(){
        return walls;
    }
    public boolean isEatable(Dot dotsPosition){
        if((super.getX() == dotsPosition.getX()) && (super.getY() == dotsPosition.getY()) && dotsPosition.exist){
            dotsPosition.exist = false;
            return true;
        }
            return false;
    }

    public boolean isEatable(Ghost ghostPosition){
        if((super.getX() == ghostPosition.getX()) && (super.getY() == ghostPosition.getY()) && ghostPosition.getEatable()){
            return true;		
        } else {
            super.exist = false;
            return false;
        }
    }
}