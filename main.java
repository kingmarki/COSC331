import java.util.Scanner;

public class main {

	public static void main(String[] args) 
	{
		dungeon d = new dungeon();
		
		d.start();
		d.insertIntoGrid(new Hero(0), 0);
		d.insertIntoGrid(new Demon(6), 6);
		
		d.print();
		Scanner in = new Scanner(System.in);
		String input;
		
		while(!d.gameOver())
		{
			System.out.println("\nWhat do you wana do?");
			d.move(in.nextLine());
			d.print();
		}
		

	}

}
