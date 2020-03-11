class ghost extends position implements Runnable{

	private boolean eatable;
	public ghost (int x, int y,boolean exist){
	 super(x,y,exist);
			this.eatable = false;
	}
	
	public boolean getExist(){
	 return exist;
	}
	public void setX(int x){
	 super.x = x;
	}
	public void setY(int y){
	 super.y = y;
	}
	public boolean setExist(boolean exist){
	 super.exist = exist;
	 return true;
	}
	public void moveUp(){
	 super.y--;
	}
	public void moveDown(){
	 super.y++;
	}
	public void moveLeft(){
	 super.x--;
	}
	public void moveRight(){
	 super.x++;
	}
	
	public boolean isPosibleMoveDown(){
		return true;
	}
	public void searchRoute(){
		if(isPosibleMoveDown()){
			moveDown();
		}
		else{
			moveUp();
		}
	}
	@Override
	public void run(){
		while(exist){
			searchRoute();
		}
	}
	public void stopRun(){
			exist = false;
		}
	}