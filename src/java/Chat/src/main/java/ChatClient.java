import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClient {

    private String hostname;
    private int port;

    public ChatClient(String hostname, int port) {
        this.hostname = hostname;
        this.port = port;
    }

    public void run() {

        try {
            Socket socket = new Socket(hostname, port);

            System.out.println("Client connected");

            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);

            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            Console console = System.console();
            String text, msg;

            do {
                text = console.readLine("ME >> ");
                writer.println(text);
                msg = reader.readLine();
                System.out.println("Server >> " + msg);
            } while ( !text.equals("bye"));

            socket.close();

        } catch (UnknownHostException ex) {
            System.out.println("Server not found: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("I/O Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        ChatClient client = new ChatClient("localhost", 7001);
        client.run();
    }
}
