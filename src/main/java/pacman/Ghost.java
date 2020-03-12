class Ghost extends Position{
    
    private boolean eatable;    //it becomes the ghost eatable
    
    public Ghost (int x, int y, boolean exist){
        super(x, y, exist);
        this.eatable = false;
    }
    
    protected boolean getEatable(){
        return this.eatable;
    }

    protected void changeEatable(){
        this.eatable= true;
    }
    
}
