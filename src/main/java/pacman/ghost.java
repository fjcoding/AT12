class ghost extends position {
    private boolean eatable;
	public ghost (int x, int y,boolean exist){
		super(x,y,exist);
        this.eatable = false;
	}
}