import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {
	private ServerSocket connection; // mechanism for the server program to listen for clients and establish
										// connections with them

	public Server(int port) throws IOException {
		connection = new ServerSocket(port);
		//connection.setSoTimeout(100);//a call for accept is blocked for 1000milliseconds
	}

	public void run() {
		System.out.println("Waiting for client on port " + connection.getLocalPort() + "...");

		try (Socket server = connection.accept()) {
			System.out.println("Just connected to " + server.getRemoteSocketAddress());
			DataInputStream messageFromClient = new DataInputStream(server.getInputStream());

			System.out.println(messageFromClient.readUTF());
			DataOutputStream out = new DataOutputStream(server.getOutputStream());
			out.writeUTF("Thank you for connecting to " + server.getLocalSocketAddress() + "\nGoodbye!");
		} catch (IOException ioe) {
			System.out.println("Error while connecting to server!");
			ioe.printStackTrace();
		}

	}
	public static void main(String[] args) {
		 int port = Integer.valueOf(args[0]);
	      try {
	         Thread t = new Server(port);
	         t.start();
	      } catch (IOException e) {
	         e.printStackTrace();
	      }
	}
}
