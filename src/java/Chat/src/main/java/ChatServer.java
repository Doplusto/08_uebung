import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {

    private int port;

    ChatServer(int port) {
        this.port = port;
    }

    public void run() {
        try {
            ServerSocket s = new ServerSocket(port);
            s.setReuseAddress(true);

            System.out.println("Wait for client!");

            while(true) {
                Socket socket  = s.accept();
                System.out.println("Client connected");

                OutputStream output = socket.getOutputStream();
                PrintWriter writer = new PrintWriter(output, true);

                InputStream input = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));

                Console console = System.console();
                String text, msg;

                do {
                    msg = reader.readLine();
                    System.out.println("Client >> " + msg);
                    text = console.readLine("ME >> ");
                    writer.println(text);
                } while ( !msg.equals("bye"));

                socket.close();
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        ChatServer serv = new ChatServer(7001);
        serv.run();
    }
}
