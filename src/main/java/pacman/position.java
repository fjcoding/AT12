class position {
	
	private int x;
	private int y;
	private boolean exist;
	private String symbol;
	
	public position(int x, int y,boolean exist){
		this.x = x;
		this.y = y;
		this.exist = exist;
		System.out.println(x+"  "+y);
	}

	public position(int x, int y,boolean exist, String symbol){
		this.x = x;
		this.y = y;
		this.exist = exist;
		this.symbol = symbol;
		System.out.println(x+"  "+y);
	}

}
