class pacman extends position {

	//private int x, y;
	public pacman (int x, int y,boolean exist){
		super(x,y,exist);
	}
	//functions those add and substract pacman's positions
	public void down(){
		super.y++;
	}
	public void right(){
		super.x++;
	}
	public void left(){
		super.x--;
	}
	public void up(){
		super.y--;
	}
	
	//
}
