class Pacman extends Position {

    //private int x, y;
    public Pacman (int x, int y,boolean exist ){
        super(x,y,exist);
    }
    
    //functions those add and substract pacman's positions	
    public void down(){
        super.y++;
    }
    
    public void right(){
        super.x++;
    }
    
    public void left(){
        super.x--;
    }
    
    public void up(){
        super.y--;
    }

    public boolean isEatable(Dots dotsPosition){
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
