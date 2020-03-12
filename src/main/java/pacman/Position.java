class Position{
    
    protected int x;	     // positionInX
    protected int y;		 // positionInY
    protected boolean exist; // possible change itExists
    protected String symbol;
    
    public Position(int x, int y, boolean exist){
        this.x = x;
        this.y = y;
        this.exist = exist;		
    }

    public Position(int x, int y, boolean exist, String symbol){
        this.x = x;
        this.y = y;
        this.exist = exist;
        this.symbol = symbol;
    }
    
    public int getX(){
        return  this.x;
    }
    
    public int getY(){
        return  this.y;
    }

}
