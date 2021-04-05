import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;

public class GUI1 {
    private JPanel initial_panel;
    private JTextField yourSummonerNameTextField;
    private JButton checkPlayersButton;
    private JTextArea placeLobbyChatHereTextArea;
    private JLabel message_board;
    public ArrayList<String>team;

    public GUI1() {
        initial_panel.setBackground(new Color(39,132,234));
        checkPlayersButton.setBackground(new Color(120,200,34));

        message_board.setText("Place Summoner Name and chat lobby below");
        message_board.setHorizontalAlignment(JLabel.CENTER);
        yourSummonerNameTextField.setHorizontalAlignment(JTextField.CENTER);
        yourSummonerNameTextField.setText("Your Summoner Name");
        checkPlayersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //places data into arraylist
                String s[] = placeLobbyChatHereTextArea.getText().split("\\r?\\n");
                ArrayList<String> data =new ArrayList<>();
                for(int i = 0; i< s.length; i++){
                    String lines[] = s[i].split("\\s+");
                    for(int j =0; j < lines.length;j++){
                        data.add(lines[j]);
                    }
                }
                //sift data and place in team
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

        yourSummonerNameTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                yourSummonerNameTextField.setText("");
            }
        });
        placeLobbyChatHereTextArea.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                placeLobbyChatHereTextArea.setText("");
            }
        });

        yourSummonerNameTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                if(yourSummonerNameTextField.getText().isBlank()){
                    yourSummonerNameTextField.setText("Your Summoner Name Here");
                }

            }
        });
        placeLobbyChatHereTextArea.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                if(placeLobbyChatHereTextArea.getText().isBlank()){
                    placeLobbyChatHereTextArea.setText("Place Lobby Chat Here");
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("League Dodge App");
        frame.setContentPane(new GUI1().initial_panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
