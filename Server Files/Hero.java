
public class Hero extends Actor 
{
	private int location;
	
	public String toString() 
	{
		return "H";
	}
	
	public Hero(int location)
	{
		this.location = location;
		type = "Hero";
	}
	
	public int getLocation()
	{
		return location;
	}
	
	public char print()
	{
		return 'H';
	}
}
