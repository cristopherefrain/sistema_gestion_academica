package WebSocket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wizard
 */
public class Server {

    private ArrayList<ConnectionToClient> clientList;
    private LinkedBlockingQueue<Object> messages;
    private ServerSocket serverSocket;

    public Server(int port) {
        clientList = new ArrayList<ConnectionToClient>();
        messages = new LinkedBlockingQueue<Object>();
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        Thread accept = new Thread() {
            public void run() {
                while (true) {
                    try {
                        Socket s = serverSocket.accept();
                        clientList.add(new ConnectionToClient(s));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        accept.setDaemon(true);
        accept.start();

        Thread messageHandling = new Thread() {
            public void run() {
                while (true) {
                    try {
                        Object message = messages.take();
                        // Do some handling here...
                        System.out.println("Message Received: " + message);
                        sendToAll(message);
                    } catch (InterruptedException e) {
                    }
                }
            }
        };

        messageHandling.setDaemon(true);
        messageHandling.start();
    }

    private class ConnectionToClient {

        ObjectInputStream in;
        ObjectOutputStream out;
        Socket socket;

        ConnectionToClient(Socket socket) throws IOException {
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
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            };

            read.setDaemon(true); // terminate when main ends
            read.start();
        }

        public void write(Object obj) {
            try {
                out.writeObject(obj);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void sendToOne(int index, Object message) throws IndexOutOfBoundsException {
        clientList.get(index).write(message);
    }

    public void sendToAll(Object message) {
        for (ConnectionToClient client : clientList) {
            client.write(message);
        }
    }

}
