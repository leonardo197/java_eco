
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
public class eco_server {
    public static void main(String[] args) throws IOException {

        if (args.length != 1) {
            System.err.println("Usage: java server_eco <port number>");
            System.exit(1);
        }

        int portNumber = Integer.parseInt(args[0]);

        try (ServerSocket serverSocket = new ServerSocket(portNumber);
             Socket clientSocket = serverSocket.accept();
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));) {
//-------------------
            String inputLine, outputLine;
            inputLine=in.readLine();
            System.out.println("Client: " + inputLine);
           System.out.println("server: " + inputLine);
            out.println("eco"+inputLine);
//------------

        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                    + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }

    }
}
