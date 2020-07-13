class Dot extends Position {
    private boolean isSpecial; //this special means that it makes pacman to eat ghost

    public Dot(int x, int y, boolean exist) {
        super(x, y, exist);
        this.isSpecial = false;
    }

    private boolean isSpecialFood() {
        return this.isSpecial;
    }
}
