class Dots extends Position {
	
    private boolean special;
    
	public Dots (int x, int y,boolean exist){
		super(x,y,exist);
        this.special = false;
	}
	
	private boolean getKindofFood()
	{
		return this.special;
	}
	
}
