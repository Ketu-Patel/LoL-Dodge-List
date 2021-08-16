package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("DodgeListDisplay.fxml"));
        AnchorPane root;
        try {
            root = (AnchorPane) loader.load();
            Controller c = loader.getController();
            c.listInters(primaryStage);
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("theme.css").toString());
            primaryStage.setScene(scene);
            primaryStage.setTitle("LoL Dodge List");
            //primaryStage.getIcons().add(new Image(Main.class.getResourceAsStream("lol-512.png")));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}












/*
import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        DodgeEngine DodgeEngine1 = new DodgeEngine();
        DodgeEngine1.AddPlayer("mani", "noob");
        DodgeEngine1.AddPlayer("k2", "smurf riven main");
        DodgeEngine1.AddPlayer("hari", "katarina griefer");
        ArrayList<String> inters1 = new ArrayList<String>();
        inters1.add("hari");
        inters1.add("vismay");
        inters1.add("k2");
        System.out.println(DodgeEngine1.FindPlayers(inters1).size());

        System.out.println(DodgeEngine1.FindPlayers(inters1).get(0).getName());
        System.out.println(DodgeEngine1.FindPlayers(inters1).get(0).getMessage());

        System.out.println(DodgeEngine1.FindPlayers(inters1).get(1).getName());
        System.out.println(DodgeEngine1.FindPlayers(inters1).get(1).getMessage());
    }
}
*/