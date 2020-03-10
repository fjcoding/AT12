class pacman extends position {

	//private int x, y;
	public pacman (int x, int y,boolean exist){
		super(x,y,exist);
	}
	//functions those add and substract pacman's positions
	public String down(){
		this.y++;
		return ("x="+this.x+", y="+this.y);
	}
	public String right(){
		this.x++;
		return ("x="+this.x+", y="+this.y);
	}
	public String left(){
		this.x--;
		return ("x="+this.x+", y="+this.y);
	}
	public String up(){
		this.y--;
		return ("x="+this.x+", y="+this.y);
	}
	public int getX(){
		return  this.x;
	}
	public int getY(){
		return  this.y;
	}
	//
}