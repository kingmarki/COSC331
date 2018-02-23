public class dungeon 
{
//grid array
	public Object grid [] = new Object[8];
	public boolean gameState = false;
	
	
	public boolean canMoveLeft(int location) 
	{
		if (location==0)
			return false;
		else
			return true;
//		else if(grid[location-1] ==0)
//			return false;
//		else return true;
	}
	
	public boolean canMoveRight(int location) 
	{
		if (location+1>grid.length)
			return false;
		else
			return true;
	}
	
	public boolean gameOver() 
	{
		return gameState;
	}
	
	public void start() 
	{
		for(int i=0;i<grid.length;i++)
			grid[i]='0';
	}
	
	public void print() 
	{
		for (int i=0;i<grid.length;i++)
			System.out.print(grid[i].toString()+" ");
	}
	
	public void insertIntoGrid(Object o, int location) 
	{
		grid[location]= o;
	}

}
