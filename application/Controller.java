package application;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class Controller {

    public ArrayList<String>team;
    private DodgeEngine Engine;

    @FXML
    public TextArea lobbyChat;
    public TextField dodgePlayer;
    public TextArea dodgeReason;
    public Label displayInters;
    @FXML Tab griefers, add, lobby;
    public Stage stage;

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

        Set<Player> found_inters = Engine.FindPlayers(team);
        //dodgePlayerFound(found_inters);
        //System.out.println(found_inters.get(0).getName());
    }

    public void addToDodgeList(ActionEvent actionEvent) {
        Engine.AddPlayer(dodgePlayer.getText(), dodgeReason.getText());
        Engine.StoreText();
    }

    @FXML
    private void initialize() {
        Engine = new DodgeEngine();
    }

    public void listInters(Stage stage){
        this.stage = stage;
        griefers.setOnSelectionChanged(new EventHandler<Event>() {
            @Override
            public void handle(Event t) {
                if (griefers.isSelected()) {
                    displayInters.setText(Engine.playerMap.values().toString().replaceAll("\\[", "")
                            .replaceAll("\\]", "").replaceAll(", N", "\nN"));
                }
            }
        });

    }

}