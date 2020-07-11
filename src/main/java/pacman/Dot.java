class Dot extends Position {
    
    public boolean isSpecial;    //this special means that it makes pacman to eat ghost
    
    public Dot(int x, int y, boolean exist) {
        super(x, y, exist);
        this.isSpecial = false;
    }
    
    public boolean isSpecialFood(){
        return this.isSpecial;
    }

    public boolean setNotSpecial(){
        this.isSpecial=false;
        return true;
    }

    public boolean setSpecial(){
        this.isSpecial=true;
        return true;
    }
}
