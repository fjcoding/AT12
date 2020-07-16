class Position {

    private int x;	       // positionInX
    private int y;		   // positionInY
    private boolean exist; // possible change itExists
    private String symbol;
    
    public Position(int x, int y, boolean exist) {
        this.x = x;
        this.y = y;
        this.exist = exist;		
    }

    public Position(int x, int y, boolean exist, String symbol) {
        this.x = x;
        this.y = y;
        this.exist = exist;
        this.symbol = symbol;
    }
    
    public int getX() {
        return  this.x;
    }
    
    public int getY() {
        return  this.y;
    }

    public boolean doesExist() {
        return exist;
    }
}
