import java.awt.Component;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.Iterator;
import javax.swing.JOptionPane;

class Transducer extends Thread {
    BufferedReader in;
    BufferedWriter out;
    int client;
    Connector portal;

    Transducer(Connector var1, BufferedReader var2, BufferedWriter var3, int var4) {
        this.portal = var1;
        this.in = var2;
        this.out = var3;
        this.client = var4;
    }

    public void run() {
        while(true) {
            try {
                String var1 = this.in.readLine();
                if (var1 == null) {
                    this.portal.collaborators.remove(this.out);
                    return;
                }

                Iterator var2 = this.portal.collaborators.iterator();

                while(var2.hasNext()) {
                    BufferedWriter var3 = null;

                    try {
                        var3 = (BufferedWriter)((BufferedWriter)var2.next());
                        if (var3 != this.out) {
                            var3.write(var1 + "\r");
                            var3.flush();
                        }
                    } catch (Exception var5) {
                        JOptionPane.showMessageDialog((Component)null, var5.toString(), "TRANSDUCER EXCEPTION #2", 2);
                    }
                }
            } catch (Exception var6) {
                JOptionPane.showMessageDialog((Component)null, var6.toString(), "TRANSDUCER EXCEPTION #1", 2);
            }
        }
    }
}
