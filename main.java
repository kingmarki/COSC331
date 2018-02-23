import java.util.Scanner;

public class main {

	public static void main(String[] args) 
	{
		dungeon d = new dungeon();
		Hero h = new Hero();
		Demon devil = new Demon();
		d.start();
		d.insertIntoGrid(h, 0);
		d.insertIntoGrid(devil, 7);
		
		
		
		d.print();
		System.out.println("\nWhat do you wana do?");
		Scanner in = new Scanner(System.in);
		String input= in.nextLine();

	}

}
