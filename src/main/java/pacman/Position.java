class Position {

    private int x;         // positionInX
    private int y;         // positionInY
    private boolean exist; // possible change itExists
    private String symbol; // possible kindOfSymbol

    Position(final int positionInX, final int positionInY, final boolean itExists) {
        this.x = positionInX;
        this.y = positionInY;
        this.exist = itExists;
    }

    Position(final int positionInX, final int positionInY, final boolean itExists, final String kindOfSymbol) {
        this.x = positionInX;
        this.y = positionInY;
        this.exist = itExists;
        this.symbol = kindOfSymbol;
    }

    public int getX() {
        return  this.x;
    }

    public int getY() {
        return  this.y;
    }

    public void setX(final int xx) {
        this.x = xx;
    }

    public void setY(final int yy) {
        this.y = yy;
    }

    public boolean doesExist() {
        return exist;
    }

    public boolean doesnotExist() {
        this.exist = false;
        return this.exist;
    }
    public void die() {
        this.exist = false;
    }
    public void live() {
        this.exist = true;
    }
}
