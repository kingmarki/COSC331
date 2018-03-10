public class Demon extends Actor
{
	public String toString() 
	{
		return "D";
	}
	
	public Demon(int location)
	{
		type = "Deamon";
		this.location=location;
	}
	
	public char print()
	{
		return 'D';
	}
}
