package DemoServerAndClient;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * 
 * @author DannyYip
 *
 */
public class ListServer {

	public static void main(String[] args) throws IOException {
		Socket allSockets[] = null ;
		ServerSocket serverSocket = null;  // 1. serversocket
		int clientNum = 0; // keeps track of how many clients were created
		int numOfClientToConnect = 0;

		// 1. CREATE A NEW SERVERSOCKET
		try {
			serverSocket = new ServerSocket(4444); // provide MYSERVICE at port 
													// 4444
			System.out.println(serverSocket);
			System.out.println("How many client to connect? (please enter an Integer)");
			Scanner toScan = new Scanner(System.in);
			numOfClientToConnect = toScan.nextInt();
			allSockets = new Socket[numOfClientToConnect];
			
			
		} catch (IOException e) {
			System.out.println("Could not listen on port: 4444");
			System.exit(-1);
		}



		// 2. LOOP FOREVER - SERVER IS ALWAYS WAITING TO PROVIDE SERVICE!
		while (true) { // 3.
			try {

				Socket clientSocket = null;
	
				// 2.1 WAIT FOR CLIENT TO TRY TO CONNECT TO SERVER
				
				if(clientNum >= numOfClientToConnect)
				{
					System.out.println("no more client can be connected");
					
				}
				else
				{
				
				System.out.println("Waiting for client " + (clientNum + 1)
						+ " to connect!");
				}
				
				clientSocket = serverSocket.accept(); // // 4.
				
				// 2.2 SPAWN A THREAD TO HANDLE CLIENT REQUEST
				System.out.println("Server got connected to a client"
						+ ++clientNum);
				
				allSockets[clientNum-1] = clientSocket;
				
				Boolean check = true;
				
				for(int num =0; num<numOfClientToConnect; num++)
				{
				if(allSockets[num] == null )
				{
					check = false;
					
				}
				}
				
				if(check)
				{
				for(int i =0; i< numOfClientToConnect; i++)
				{
					Thread t = new Thread(new ListClientHandler(allSockets[i], clientNum, allSockets, numOfClientToConnect));
					t.start();
				}
				}
				
			}
			 catch (IOException e) {
				System.out.println("Accept failed: 4444");
				System.exit(-1);
				
			}

			// 2.3 GO BACK TO WAITING FOR OTHER CLIENTS
			// (While the thread that was created handles the connected client's
			// request)

		} // end while loop

	} // end of main method

} // end of class MyServer

class ListClientHandler implements Runnable {
	Socket s; // this is socket on the server side that connects to the CLIENT
	int num; // keeps track of its number just for identifying purposes
	Socket allSockets[] = new Socket [2];
	int numOfClientToConnect;
	
	ListClientHandler(Socket s, int n, Socket allSockets[], int numOfClientToConnect) {
		
		for(int i =0; i< 2 ; i++)
		{
			this.allSockets[i] = allSockets[i];
		}
		this.numOfClientToConnect = numOfClientToConnect;
		this.s = s;
		num = n;
	}

	// This is the client handling code
	// This keeps running handling client requests 
	// after initially sending some stuff to the client
	public void run() { 
		Scanner in;
		PrintWriter out[] = new PrintWriter[numOfClientToConnect];
		
		try {
			// 1. GET SOCKET IN/OUT STREAMS
			in = new Scanner(new BufferedInputStream(s.getInputStream())); 
			for(int i=0; i< numOfClientToConnect; i++)
			{
				if(allSockets[i] != null)
				{
			out[i] = new PrintWriter(new BufferedOutputStream(allSockets[i].getOutputStream()));
				}
				else
				{
					out[i] = null;
				}
			}
			
			// 3. KEEP LISTENING AND RESPONDING TO CLIENT REQUESTS
			String s = new String();
			while (true) {
			
				System.out.println("Server - waiting to read");
				 s = in.nextLine();
				 
				handleRequest(s);
				
//				// 2. PRINT SOME STUFF TO THE CLIENT
				for(int i =0; i<numOfClientToConnect;i++)
				{
					if(out[i] != null)
					{
						out[i].println(s);
						out[i].flush(); // force the output
					}
				}
			
			}
			

			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// This handling code dies after doing all the printing
	} // end of method run()
	
	void handleRequest(String s) {
		System.out.println("server side: "  +s);
	}

} // end of class ClientHandler
