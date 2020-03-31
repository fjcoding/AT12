import java.util.ArrayList;

class Pacman extends Position {

    protected ArrayList <Position> positions;

    public Pacman (int x, int y, boolean exist){
        super(x, y, exist);
        positions = new ArrayList<Position>();
        positions.add(new Wall(0,0, true));
        positions.add(new Wall(0,30, true));
        positions.add(new Wall(0,60, true));
        positions.add(new Wall(0,90, true));
        positions.add(new Wall(0,120, true));

        positions.add(new Wall(30,0, true));
        positions.add(new Wall(60,0, true));
        positions.add(new Wall(90,0, true));
        positions.add(new Wall(120,0, true));
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
        for(Position i: positions){
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
        if((super.getX() == ghostPosition.getX()) && (super.getY() == ghostPosition.getY()) && ghostPosition.getEatable()){
            return true;		
        } else {
            super.exist = false;
            return false;
        }
    }
}