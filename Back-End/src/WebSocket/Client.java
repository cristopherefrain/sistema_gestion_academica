package WebSocket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wizard
 */
public class Client {

    private ConnectionToServer server;
    private LinkedBlockingQueue<Object> messages;
    private Socket socket;

    public Client(InetAddress host, int port) throws IOException {

        socket = new Socket(host, port);
        messages = new LinkedBlockingQueue<Object>();
        server = new ConnectionToServer(socket);

        Thread messageHandling = new Thread() {
            public void run() {
                while (true) {
                    try {
                        Object message = messages.take();
                        // Do some handling here...
                        System.out.println("Message Received: " + message);
                    } catch (InterruptedException e) {
                    }
                }
            }
        };

        messageHandling.setDaemon(true);
        messageHandling.start();
    }

    private class ConnectionToServer {

        ObjectInputStream in;
        ObjectOutputStream out;
        Socket socket;

        ConnectionToServer(Socket socket) throws IOException {
            this.socket = socket;
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());

            Thread read = new Thread() {
                public void run() {
                    while (true) {
                        try {
                            Object obj = in.readObject();
                            messages.put(obj);
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            };

            read.setDaemon(true);
            read.start();
        }

        private void write(Object obj) {
            try {
                out.writeObject(obj);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void send(Object obj) {
        server.write(obj);
    }
}
