import java.util.Scanner;

public class main {

	public static void main(String[] args) 
	{
		
		system.out.println("Welcome" + name + "! To the game prepair for battle!!!")
		dungeon d = new dungeon();
		
		d.start();
		d.insertIntoGrid(new Hero(0), 0);
		d.insertIntoGrid(new Demon(6), 6);
		
		d.print();
		Scanner in = new Scanner(System.in);
		String input;
		
		while(!d.gameOver())
		{
			System.out.println("\nIt is time for you to make a move "+name+".");
			System.out.println("\ntype in right if you wish to challenge the evil monster!!!");
			System.out.println("\ntype in left if you wish to wait to challenge the evil monster"!!!)
			d.move(in.nextLine());
			d.print();
		}
		

	}

}
