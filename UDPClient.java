import java.io.*;
import java.net.*;

class UDPClient
{
   public static void main(String args[]) throws Exception
   {
      System.out.println("******CLIENT**********");
	   BufferedReader inFromUser =
         new BufferedReader(new InputStreamReader(System.in));
      DatagramSocket clientSocket = new DatagramSocket();
      InetAddress IPAddress = InetAddress.getByName("localhost");
      byte[] sendData = new byte[1024];
      byte[] receiveData = new byte[1024];
      String sentence = inFromUser.readLine();
      boolean gameOver = false;
      while (!gameOver)
      {
    	  sendData = sentence.getBytes();
          DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
          clientSocket.send(sendPacket);
          DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
          clientSocket.receive(receivePacket);
          String modifiedSentence = new String(receivePacket.getData());
          System.out.println("FROM SERVER:" + modifiedSentence);
          if (modifiedSentence.contains("Congradulations"))
          {
        	  gameOver=true;
        	  clientSocket.close();
          }
          else        	  
        	  sentence=inFromUser.readLine();
      }
      
      System.out.println("Game terminated");
   }
}
