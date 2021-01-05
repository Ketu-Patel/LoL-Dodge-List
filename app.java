import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;

public class app extends JFrame implements ActionListener {


    /**
     * Launch the application.
     */
    private JLabel header;
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
        setSize(400, 400);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        JPanel headingPanel = new JPanel();
        header = new JLabel("Type Summoner Name Below");
        headingPanel.add(header);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constr = new GridBagConstraints();
        constr.insets = new Insets(5, 5, 5, 5);
        constr.anchor = GridBagConstraints.WEST;

        constr.gridx=0;
        constr.gridy=0;
        JLabel chatLabel = new JLabel("Enter Chat:");

        JTextArea chatTxt = new JTextArea(20,5);
        chatTxt.setBorder(new EmptyBorder(10,50,10,50));
        panel.add(chatLabel, constr);
        constr.gridx=1;
        panel.add(chatTxt, constr);
        constr.gridx=0; constr.gridy=1;

        constr.gridwidth = 2;
        constr.anchor = GridBagConstraints.CENTER;

        // Button with text "Run"
        JButton button = new JButton("Run");
        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                header.setText("Currently Looking it up");
            }
        });
        button.setBackground(new Color(120,200,34));
        panel.add(button, constr);
        panel.setBackground(new Color(39,132,234));
        mainPanel.add(headingPanel);
        mainPanel.add(panel);

        // Add panel to frame
        add(mainPanel);


    }
    public void actionPerformed(ActionEvent e)
    {

    }

}