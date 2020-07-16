class Position {

    private int x;	       // positionInX
    private int y;		   // positionInY
    private boolean exist; // possible change itExists
    private String symbol;

    Position(final int x, final int y, final boolean exist) {
        this.x = x;
        this.y = y;
        this.exist = exist;
    }

    Position(final int x, final int y, final boolean exist, final String symbol) {
        this.x = x;
        this.y = y;
        this.exist = exist;
        this.symbol = symbol;
    }

    private int getX() {
        return  this.x;
    }

    private int getY() {
        return  this.y;
    }

    public boolean doesExist() {
        return exist;
    }
}
