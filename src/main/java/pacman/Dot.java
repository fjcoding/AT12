class Dot extends Position {
    
    private boolean isSpecial; //this special means that it makes pacman to eat ghost

    public Dot(int x, int y, boolean exist) {
        super(x, y, exist);
        this.isSpecial = false;
    }
    
    public boolean isSpecialDot(){
        return this.isSpecial;
    }

    public void setSpecial(){
        this.isSpecial=true;
    }
    
    public boolean setExist(boolean exist) {
        super.exist = exist;
        return true;
    }
}
}
