class Ghost extends Position{
    
    private boolean isEatable;    //it becomes the ghost eatable
    
    public Ghost (int x, int y, boolean exist){
        super(x, y, exist);
        this.isEatable = false;
    }
    
    protected boolean isEatable(){
        return this.isEatable;
    }

    protected void changeEatable(){
        this.isEatable = true;
    }
    
}