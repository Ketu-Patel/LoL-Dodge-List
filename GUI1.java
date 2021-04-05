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
    private JButton dodgePlayer;
    private JTextField banPlayerName;
    private JTextArea dodgeReason;
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
                team = new ArrayList<>();
                //For if a whole team is inputted
                if (s.length > 1) {

                    ArrayList<String> data = new ArrayList<>();
                    for (int i = 0; i < s.length; i++) {
                        String lines[] = s[i].split("\\s+");
                        for (int j = 0; j < lines.length; j++) {
                            data.add(lines[j]);
                        }
                    }
                    //sift data and place in team
                    //TODO Filter out duplicate "has joined the lobby"

                    String name = "";
                    Boolean discard = false;
                    for (int i = 0; i < data.size(); i++) {
                        if (data.get(i).equals("joined") || data.get(i).equals("the")) {
                            continue;
                        } else if (data.get(i).equals("left")) {
                            discard = true;
                        } else if (data.get(i).equals("lobby")) {
                            System.out.println(team.size());
                            if (team.size() == 4) {
                                i = data.size();
                            }
                            if (discard) {
                                team.remove(name);
                                discard = false;
                            } else if (name.length() > 1) {
                                team.add(name);
                            }
                            name = "";
                        } else {
                            name = name + " " + data.get(i);
                        }
                    }
                }

                if (s.length == 1){
                    team.add(s[0]);
                }

                //Check against DodgeList
                DodgeEngine DodgeEngine2 = new DodgeEngine();
                DodgeEngine2.ReadIn();
                ArrayList<Player> found_inters = DodgeEngine2.FindPlayers(team);
                dodgePlayerFound(found_inters);
                System.out.println(found_inters.get(0).getName());
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
        dodgePlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DodgeEngine DodgeEngine1 = new DodgeEngine();
                DodgeEngine1.AddPlayer(banPlayerName.getText(), dodgeReason.getText());
                DodgeEngine1.StoreText();
                message_board.setText("Task is complete");
            }
        });
        banPlayerName.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                banPlayerName.setText("");
            }
        });
        dodgeReason.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                dodgeReason.setText("");
            }
        });
    }
    public void dodgePlayerFound(ArrayList<Player> found_inters){
        JFrame inter_frame = new JFrame("League Dodge App");
        ImageIcon img = new ImageIcon("icon.png");
        inter_frame.setIconImage(img.getImage());
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout());
        JLabel label = new JLabel("Here are the players found and their reasons:");
        JLabel players_info = new JLabel("");
        String players_string= "";
        for(int i = 0; i< found_inters.size();i++){
            players_string+=found_inters.get(i).getName()+"\t"+found_inters.get(i).getMessage()+"\n";
        }
        players_info.setText(players_string);
        JButton button = new JButton();
        button.setText("Exit");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inter_frame.dispose();
            }
        });
        panel.add(label);
        panel.add(players_info);
        panel.add(button);
        inter_frame.add(panel);
        inter_frame.setSize(200, 300);
        inter_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inter_frame.setVisible(true);
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("League Dodge App");
        ImageIcon img = new ImageIcon("icon.png");
        frame.setIconImage(img.getImage());
        frame.setContentPane(new GUI1().initial_panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
