import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;
import java.util.*;
public class app extends JFrame {


    /**
     * Launch the application.
     */
    private JLabel header;
    public ArrayList<String>team;
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
        header = new JLabel("Copy and Paste Chat log Below");
        headingPanel.add(header);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraint = new GridBagConstraints();
        constraint.insets = new Insets(5, 5, 5, 5);
        constraint.anchor = GridBagConstraints.WEST;

        constraint.gridx=0;
        constraint.gridy=0;
        JLabel chatLabel = new JLabel("Enter Chat:");

        JTextArea chatTxt = new JTextArea(20,5);
        chatTxt.setBorder(new EmptyBorder(10,50,10,50));
        panel.add(chatLabel, constraint);
        constraint.gridx=1;
        panel.add(chatTxt, constraint);
        constraint.gridx=0;
        constraint.gridy=1;

        constraint.gridwidth = 2;
        constraint.anchor = GridBagConstraints.CENTER;

        // Button with text "Run"
        JButton button = new JButton("Run");
        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                header.setText("Currently Looking it up ");
                String s[] = chatTxt.getText().split("\\r?\\n");
                ArrayList<String> data =new ArrayList<>();
                for(int i = 0; i< s.length; i++){
                    String lines[] = s[i].split("\\s+");
                    for(int j =0; j < lines.length;j++){
                        data.add(lines[j]);
                    }
                }
                team = new ArrayList<>();
                String name = "";
                Boolean discard =false;
                for(int i = 0; i< data.size(); i++){
                   if(data.get(i).equals("joined") || data.get(i).equals("the")){
                    continue;
                   }
                   else if(data.get(i).equals("left")){
                       discard = true;
                   }
                   else if(data.get(i).equals("lobby")){
                       System.out.println(team.size());
                       if(team.size() == 4){
                           i = data.size();
                       }
                       if(discard){
                           team.remove(name);
                           discard=false;
                       }
                       else if(name.length() > 1){
                           team.add(name);
                       }
                       name="";
                   }
                   else{
                       name = name +" "+ data.get(i);
                   }
                }
                //System.out.println(team);
            }

        });
        button.setBackground(new Color(120,200,34));
        panel.add(button, constraint);
        panel.setBackground(new Color(39,132,234));
        mainPanel.add(headingPanel);
        mainPanel.add(panel);

        // Add panel to frame
        add(mainPanel);


    }

}