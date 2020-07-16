class Wall extends Position {
    Wall(final int x, final int y, final boolean exist) {
        super(x, y, exist);
    }
    Wall(final int x, final int y, final boolean exist, final String symbol) {
       super(x, y, exist, symbol);
   }
}
