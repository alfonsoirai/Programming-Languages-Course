import java.awt.Component;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
import javax.swing.JOptionPane;

public class Connector extends Thread {
    int clientNum = 1;
    int port;
    ServerSocket portalSocket;
    Vector collaborators;

    public Connector(int var1) {
        this.port = var1;
        this.collaborators = new Vector();
    }

    public void run() {
        try {
            this.portalSocket = new ServerSocket(this.port);

            while(true) {
                while(true) {
                    try {
                        Socket var1 = this.portalSocket.accept();
                        BufferedWriter var2 = new BufferedWriter(new OutputStreamWriter(var1.getOutputStream()));
                        this.collaborators.add(var2);
                        System.out.println("Spawning Transducer for " + this.clientNum);
                        Transducer var3 = new Transducer(this, new BufferedReader(new InputStreamReader(var1.getInputStream())), var2, this.clientNum);
                        var3.start();
                        ++this.clientNum;
                    } catch (Exception var4) {
                        JOptionPane.showMessageDialog((Component)null, var4.toString(), "CONNECTOR EXCEPTION #2", 2);
                    }
                }
            }
        } catch (Exception var5) {
            JOptionPane.showMessageDialog((Component)null, var5.toString(), "CONNECTOR EXCEPTION #1", 2);
        }
    }

    public static void main(String[] var0) {
        try {
            int var1 = Integer.parseInt(var0[0]);
            Connector var2 = new Connector(var1);
            var2.start();
        } catch (Exception var3) {
            System.out.println(var3);
            System.out.println("usage: java -classpath <> Connector <port>");
        }

    }
}