import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class TicTacToe extends JFrame implements ActionListener {
    JButton b11;
    JButton b21;
    JButton b31;
    JButton b12;
    JButton b22;
    JButton b32;
    JButton b13;
    JButton b23;
    JButton b33;
    boolean myturn;
    BufferedReader br;
    BufferedWriter bw;
    Thread connection;
    Process prologProcess;
    String prolog;
    String ttt;

    public TicTacToe(String var1, String var2) {
        this.prolog = var1;
        this.ttt = var2;
        this.b11 = new JButton("");
        this.b21 = new JButton("");
        this.b31 = new JButton("");
        this.b12 = new JButton("");
        this.b22 = new JButton("");
        this.b32 = new JButton("");
        this.b13 = new JButton("");
        this.b23 = new JButton("");
        this.b33 = new JButton("");
        this.b11.setActionCommand("(1,1).");
        this.b21.setActionCommand("(2,1).");
        this.b31.setActionCommand("(3,1).");
        this.b12.setActionCommand("(1,2).");
        this.b22.setActionCommand("(2,2).");
        this.b32.setActionCommand("(3,2).");
        this.b13.setActionCommand("(1,3).");
        this.b23.setActionCommand("(2,3).");
        this.b33.setActionCommand("(3,3).");
        Font font = new Font("arial", 0, 48);

        this.b11.setFont(font);
        this.b21.setFont(font);
        this.b31.setFont(font);
        this.b12.setFont(font);
        this.b22.setFont(font);
        this.b32.setFont(font);
        this.b13.setFont(font);
        this.b23.setFont(font);
        this.b33.setFont(font);
        this.b11.addActionListener(this);
        this.b21.addActionListener(this);
        this.b31.addActionListener(this);
        this.b12.addActionListener(this);
        this.b22.addActionListener(this);
        this.b32.addActionListener(this);
        this.b13.addActionListener(this);
        this.b23.addActionListener(this);
        this.b33.addActionListener(this);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 3));
        panel.add(this.b11);
        panel.add(this.b21);
        panel.add(this.b31);
        panel.add(this.b12);
        panel.add(this.b22);
        panel.add(this.b32);
        panel.add(this.b13);
        panel.add(this.b23);
        panel.add(this.b33);
        this.setTitle("Final Project: TicTacToe");
        Border border = BorderFactory.createLoweredBevelBorder();
        panel.setBorder(border);
        this.getContentPane().add(panel);
        this.setSize(300, 300);
        this.setLocation(900, 300);
        this.myturn = true;

        Connector connector = new Connector(54321);
        connector.start();

        try {
            Socket socket = new Socket("127.0.0.1", 54321);
            this.br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (Exception e) {
            System.out.println(e);
        }

        this.connection = new Thread() {
            public void run() {
                while(true) {
                    try {
                        String s = TicTacToe.this.br.readLine();
                        TicTacToe.this.computer_move(s);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            }
        };
        this.connection.start();
        Thread var8 = new Thread() {
            public void run() {
                TicTacToe.this.setVisible(true);
            }
        };
        EventQueue.invokeLater(var8);

        try {
            this.prologProcess = Runtime.getRuntime().exec(var1 + " -f " + var2);
        } catch (Exception e) {
            System.out.println(e);
        }

        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent var1) {
                if (TicTacToe.this.prologProcess != null) {
                    TicTacToe.this.prologProcess.destroy();
                }

                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        String prologScript = "/usr/local/bin/swipl"; //execute prolog
        String prologFile = "main.pl"; //Replace with your directory .pl
        boolean noargs = true;

        try {
            prologScript = args[0];
            prologFile = args[1];
            noargs = false;
        } catch (Exception e) {
            System.out.println("Usage: java TicTactoe");
        }

        new TicTacToe(prologScript, prologFile);
    }

    void computer_move(String s) {
        String[] c = s.split(",");
        int x = Integer.parseInt(c[0].trim());
        int y = Integer.parseInt(c[1].trim());
        if (x == 1) {
            if (y == 1) {
                this.b11.setText("O");
            } else if (y == 2) {
                this.b12.setText("O");
            } else if (y == 3) {
                this.b13.setText("O");
            }
        } else if (x == 2) {
            if (y == 1) {
                this.b21.setText("O");
            } else if (y == 2) {
                this.b22.setText("O");
            } else if (y == 3) {
                this.b23.setText("O");
            }
        } else if (x == 3) {
            if (y == 1) {
                this.b31.setText("O");
            } else if (y == 2) {
                this.b32.setText("O");
            } else if (y == 3) {
                this.b33.setText("O");
            }
        }

        if (this.winner()) {
            this.connection.stop();
        } else {
            this.myturn = true;
        }

    }

    public void actionPerformed(ActionEvent var1) {
        if (this.myturn) {
            String var2 = ((JButton)var1.getSource()).getText();
            if (var2.equals("")) {
                ((JButton)((JButton)var1.getSource())).setText("X");

                try {
                    this.bw.write(var1.getActionCommand() + "\n");
                    this.bw.flush();
                } catch (Exception var4) {
                    System.out.println(var4);
                }

                this.myturn = false;
                if (this.winner()) {
                    this.connection.stop();
                }

            }
        }
    }

    boolean winner() {
        return this.line(this.b11, this.b21, this.b31) || this.line(this.b12, this.b22, this.b32) || this.line(this.b13, this.b23, this.b33) || this.line(this.b11, this.b12, this.b13) || this.line(this.b21, this.b22, this.b23) || this.line(this.b31, this.b32, this.b33) || this.line(this.b11, this.b22, this.b33) || this.line(this.b13, this.b22, this.b31);
    }

    boolean line(JButton b, JButton c, JButton d) {
        if (!b.getText().equals("") && b.getText().equals(c.getText()) && c.getText().equals(d.getText())) {
            if (b.getText().equals("O")) {
                b.setBackground(Color.red);
                c.setBackground(Color.red);
                d.setBackground(Color.red);
            } else {
                b.setBackground(Color.green);
                c.setBackground(Color.green);
                d.setBackground(Color.green);
            }

            return true;
        } else {
            return false;
        }
    }
}