public class dungeon 
{
//grid array
	public Actor grid [] = new Actor[8];
	public boolean gameState = false;
	public int heroLocation, deamonLocation ;
	
	
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
		if (location>grid.length)
			return false;
		else if (!grid[location+1].type.equals("blank"))
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
			grid[i]=new Actor();
	}
	
	public void print() 
	{
		if (!gameState)
			for (int i=0;i<grid.length;i++)
				System.out.print(grid[i].print()+" ");
			
	}
	
	public void insertIntoGrid(Actor o, int location) 
	{
		grid[location]= o;
		if(o.getType().equals("Hero"))
				heroLocation = location;
		else if(o.getType().equals("Deamon"))
				deamonLocation = location;
	}
	
	public void kill()
	{
		if (grid[heroLocation-1].type.equals("Deamon")||
				grid[heroLocation+1].type.equals("Deamon"))
			grid[deamonLocation] = new Actor();
		else
			System.out.println("Invalid");
	}
	
	private void check()
	{
		if (heroLocation == grid.length-1)
		{
			gameState = true;
			System.out.println("Congradulations "+name+" you have defeated the evil monster!");
		}
			
	}

	public void move(String input) 
	{
		if (input.equals("left"))
			{
				if (canMoveLeft(heroLocation))
				{
					grid[heroLocation-1] = grid[heroLocation];
					grid[heroLocation]=new Actor();
					heroLocation--;
					check();
				}
				else
					System.out.println("INVALID MOVE "+name+" please type in a different move to continue your quest to slay the evil monster!!");
			}
		else if (input.equals("right"))
		{
			if(canMoveRight(heroLocation))
				{
					grid[heroLocation+1] = grid[heroLocation];
					grid[heroLocation]=new Actor();
					heroLocation++;
					check();
				}
			else
				System.out.println("INVALID MOVE");
		}
		else if (input.equals("kill"))
		{
			kill();
		}
		
	}

}
