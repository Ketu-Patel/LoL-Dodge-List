package application;

import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class Controller {

    public ArrayList<String>team;
    public TextArea lobbyChat;
    public TextField dodgePlayer;
    public TextArea dodgeReason;
    private DodgeEngine Engine = new DodgeEngine();

    public void checkPlayers(ActionEvent actionEvent) {
        //places data into arraylist
        String s[] = lobbyChat.getText().split("\\r?\\n");
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
                    } else if (name.length() > 1 && !team.contains(name)) {
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
        Engine.ReadIn();
        ArrayList<Player> found_inters = Engine.FindPlayers(team);
        //dodgePlayerFound(found_inters);
        System.out.println(found_inters.get(0).getName());
    }

    public void addToDodgeList(ActionEvent actionEvent) {
        Engine.AddPlayer(dodgePlayer.getText(), dodgeReason.getText());
        Engine.StoreText();
    }
}