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
