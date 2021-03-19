package DemoServerAndClient;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * 
 * @author DannyYip
 *
 */
public class ListClient {

	Socket serverSocket;
	String serverHostName = "localhost";
	int serverPortNumber = 4444;
	ServerListener sl;
	String userName;
	String userMessage;
	
	ListClient() {
		// 1. CONNECT TO THE SERVER
		try {
			System.out.println(">​ Enter your Name: (After giving input “your name”, need to press Enter)");
			Scanner s = new Scanner(System.in);
			userName = s.nextLine();
			System.out.println("Your Name is " + userName);			
			
			//connect to server after get the username
			serverSocket = new Socket(serverHostName, serverPortNumber);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 2. SPAWN A LISTENER FOR THE SERVER. THIS WILL KEEP RUNNING
		// when a message is received, an appropriate method is called
		sl = new ServerListener(this, serverSocket);
		new Thread(sl).start();

		PrintWriter out;
		try {
			out = new PrintWriter(new BufferedOutputStream(serverSocket.getOutputStream()));
			
			// 3. SEND THREE WISHES TO SERVER
			Boolean test = true;
			System.out.println(">​ Enter your Message to chat : (After giving input “your message”, need to press Enter)");
			while(test) 
			{
			Scanner scan = new Scanner(System.in);
		    userMessage = scan.nextLine();
			out.println(userName + ": " + userMessage); 			
			out.flush(); // force the output
			}
				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		


	}

	public void handleMessage( String s) {
		switch (s) {
		case "exit":
			System.exit(-1);
			break;
		default:
			System.out.println(s);
		}
	}

	public static void main(String[] args) {
		ListClient lc = new ListClient();
	} // end of main method

} // end of ListClient

class ServerListener implements Runnable {
	ListClient lc;
	Scanner in; // this is used to read which is a blocking call

	ServerListener(ListClient lc, Socket s) {
		try {
			this.lc = lc;
			in = new Scanner(new BufferedInputStream(s.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (true) { // run forever
			System.out.println("Client - waiting to read");
			String s = in.nextLine();
			lc.handleMessage(s);
		}

	}
}
