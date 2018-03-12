import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class main {

 public void start() {

 }

 public static void main(String[] args) throws Exception {
  
  //print out servers IP and port
  System.out.println("My IP is: "+InetAddress.getLocalHost().getHostAddress());
  System.out.println("Use port 9876");
  
  //Create recieving port for server
  DatagramSocket serverSocket = new DatagramSocket(9876);
  byte[] receiveData = new byte[1024];
  byte[] sendData = new byte[1024];
  DatagramPacket startreceivePacket;
  //		byte[] startreceiveData = new byte[1024];
  //    	byte[] startsendData = new byte[1024];  

  //recieve a packet
  startreceivePacket = new DatagramPacket(receiveData, receiveData.length);
  serverSocket.receive(startreceivePacket);
  String start = new String(startreceivePacket.getData()).trim();
  //type start to start game
  if (start.equals("start")) {
   dungeon d = new dungeon();

   InetAddress IPAddress = startreceivePacket.getAddress();
   int port = startreceivePacket.getPort();
   d.start();
   d.insertIntoGrid(new Hero(0), 0);
   d.insertIntoGrid(new Demon(6), 6);
   //		System.out.println("Enter Name:");
   //		Scanner in2 = new Scanner(System.in);
   //		String name = in2.nextLine();
   //		System.out.println("Welcome" + name + "! To the game prepair for battle!!!");
   //		d.setName(name);
   //Send map to Client
   String firstLine = d.print();
   sendData = firstLine.getBytes();
   DatagramPacket first =
    new DatagramPacket(sendData, sendData.length, IPAddress, port);
   serverSocket.send(first);


   //		System.out.println("\nIt is time for you to make a move "+name+".");
   //		System.out.println("\ntype in right if you wish to challenge the evil monster!!!");
   //		System.out.println("\ntype in left if you wish to wait to wait to challenge the evil monster!!!");

   //Recieve packets until game is over
   DatagramPacket receivePacket;
   while (!d.gameOver()) {
    receiveData = new byte[1024];
    sendData = new byte[1024];
    receivePacket = new DatagramPacket(receiveData, receiveData.length);
    serverSocket.receive(receivePacket);
    String gameInput = new String(receivePacket.getData()).trim();
    System.out.println("RECEIVED: " + gameInput);
    //Recieve packet then print it out

    //if player can move then perform the following
    if (d.move(gameInput)) {
     //check the game state
     if (d.gameState) {
      //return for game
      String gameC = "Congradulations null you have defeated the evil monster!, you win!";
      sendData = gameC.getBytes();
      DatagramPacket endGame =
       new DatagramPacket(sendData, sendData.length, IPAddress, port);
      serverSocket.send(endGame);
     }

     receiveData = new byte[1024];
     sendData = new byte[1024];
     //return for game
     String gameReturn = d.print();
     sendData = gameReturn.getBytes();
     DatagramPacket sendPacket =
      new DatagramPacket(sendData, sendData.length, IPAddress, port);
     serverSocket.send(sendPacket);


    } else {
     receiveData = new byte[1024];
     sendData = new byte[1024];
     //return for game
     String gameReturn = "*Invalid  Move*";
     sendData = gameReturn.getBytes();
     DatagramPacket sendPacket =
      new DatagramPacket(sendData, sendData.length, IPAddress, port);
     serverSocket.send(sendPacket);

    }



   }
   serverSocket.close();


   //		while(!d.gameOver())
   //		{
   //			
   //			d.move(in.nextLine());
   //			//d.print();
   //			System.out.println(d.print());
   //		}

  }
 }

}
