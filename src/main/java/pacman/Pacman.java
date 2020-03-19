class Pacman extends Position{

    //private int x, y;
    public Pacman (int x, int y, boolean exist){
        super(x, y, exist);
    }
    
    //functions those add and substract pacman's positions	
    public int down(){
        return super.y += 30;
    }
    
    public int right(){
        return super.x += 30;
    }
    
    public int left(){
        return super.x -= 30;
    }
    
    public int up(){
        return super.y -= 30;
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