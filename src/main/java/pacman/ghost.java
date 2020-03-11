class ghost extends position {
    private boolean eatable;
	public ghost (int x, int y,boolean exist){
		super(x,y,exist);
        this.eatable = false;
	}
	protected boolean getEatable(){

		return this.eatable;
	}

	protected void changeEatable(){

		this.eatable= true;
	}
}