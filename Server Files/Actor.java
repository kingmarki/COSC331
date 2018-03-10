public class Actor 
{
	public String type;
	public int location;
	
	public String getType()
	{
		return type;
	}
	
	public char print()
	{
		return '_';
	}
	
	public Actor(){
		type = "blank";
	}
}
