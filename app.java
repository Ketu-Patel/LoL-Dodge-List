import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;

public class app extends JFrame implements ActionListener {


    /**
     * Launch the application.
     */

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    app frame = new app();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */

    public app() {
        setTitle("Lol Dodge List");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        JPanel p1 = new JPanel(new BorderLayout());
        //contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        //contentPane.setLayout(new BorderLayout(0, 0));
        JTextField name = new JTextField("Add Summoner Name");
        name.setPreferredSize(new Dimension(100,100));
        JButton runButton = new JButton("Run");
        runButton.setPreferredSize(new Dimension(100,100));
        p1.add(name);
        contentPane.add(p1);
    }

    public void actionPerformed(ActionEvent e){


    }
}