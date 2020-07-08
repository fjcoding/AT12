class Dot extends Position{
    
    private boolean special;    //this special means that it makes pacman to eat ghost
    
    public Dot(int x, int y, boolean exist){
        super(x, y, exist);
        this.special = false;
    }
    
    private boolean getKindofFood(){
        return this.special;
    }
    
}