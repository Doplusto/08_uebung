import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Iterator;

/**
 * check ports
 */
public class PortScanner {

    /**
     * Represents the IPRange
     */
    private static class IPRange implements Iterable<Integer> {

        int startIPAddress, endIPAddress;

        IPRange(int start, int end) {
            this.startIPAddress = start;
            this.endIPAddress   = end;
        }

        /**
         * This Iterator makes live easy.
         * @return Iterator
         */
        public Iterator<Integer> iterator() {
            return new Iterator<Integer>() {

                int index = startIPAddress;

                @Override
                public boolean hasNext() {
                    return index <= endIPAddress;
                }

                @Override
                public Integer next() {
                    return index++;
                }
            };
        }
    }

    /**
     * This method tries to connect and checks if port ist open.
     * @param ip IP address of host
     * @param port Port to connect to
     * @param timeout Timeout
     * @return Returns wether it was possible to connect or not.
     */
   static boolean portIsOpen(String ip, int port, int timeout) {
        try {
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress(ip, port), timeout);
            socket.close();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    /**
     * Starts port scna.
     * @param args
     */
    public static void main(String[] args) {
        String IP = "localhost";
        IPRange[] portRanges = new IPRange[]{new IPRange(5005, 5015), new IPRange(5501, 5509), new IPRange(6003, 6010), new IPRange(6997,7013)};
        for (int i = 0; i < portRanges.length; i++) {
            for (int port: portRanges[i]) {
                System.out.println( port + " is " + ((portIsOpen(IP, port, 2000)) ? "open" : "closed"));
            }
        }
    }
}
