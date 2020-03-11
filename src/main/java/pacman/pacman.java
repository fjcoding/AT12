class pacman extends position {

	//private int x, y;
	public pacman (int x, int y,boolean exist ){
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

	public boolean isEatable(food foodPosition){
		if((super.getX() == foodPosition.getX()) && (super.getY() == foodPosition.getY()) && foodPosition.exist){
			foodPosition.exist = false;
			return true;

		}
		return false;

	}

	public boolean isEatable(ghost ghostPosition){
		if((super.getX() == ghostPosition.getX()) && (super.getY() == ghostPosition.getY()) && ghostPosition.getEatable()){
			return true;
			
		} else {
			super.exist = false;
			return false;
		}
		

	}
	
	
}
