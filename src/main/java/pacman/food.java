class food extends position {
    private boolean special;
	public food (int x, int y,boolean exist){
		super(x,y,exist);
        this.special = false;
	}
	private boolean getKindofFood()
	{
		return this.special;
	}
}