package application;


import java.util.*;
import java.io.*;

public class DodgeEngine {
    Map<String, Player> playerMap;

    public DodgeEngine(){

    }

    /**
     * Searches bad Players to find instances current team members
     * @param team
     * @return
     */
    public Set<Player> FindPlayers(List<String> team){
        Set<Player> foundPlayers = new HashSet<>();
        for (String teammate : team){
            if(playerMap.containsKey(teammate)){
                foundPlayers.add(playerMap.get(teammate));
            }
        }
        return foundPlayers;
    }

    /**
     * Stores Content of Map in Text File as CSV
     */
    public void StoreText(){
        try(FileWriter csvWriter = new FileWriter("application/Dodge_List.txt")) {
            for (Player a : playerMap.values()) {
                csvWriter.append(a.toString() + "\n");
            }
            csvWriter.flush();
        }
        catch (IOException e){
            //You need to switch to an external error log
            System.out.println(e.getMessage());
        }
    }

    /**
     * Reads in CSV to populate Map of bad players
     */
    public void ReadIn(){
        try( BufferedReader csvReader = new BufferedReader(new FileReader("application/Dodge_List.txt"))) {
            String row;
            playerMap = new HashMap<String, Player>();
            while ((row = csvReader.readLine()) != null) {
                String[] split1 = row.split(", | =");
                playerMap.put(split1[1], new Player(split1[1], Integer.parseInt(split1[3]), Integer.parseInt(split1[5]),
                        Integer.parseInt(split1[7]), split1[9]));

            }
            csvReader.close();
        }
        catch (FileNotFoundException e){
            playerMap = new HashMap<String, Player>();
            //You need to switch to an external error log
            System.out.println(e.getMessage());
        }
        catch (IOException e){
            //You need to switch to an external error log
            System.out.println(e.getMessage());
        }
    }

    public void AddPlayer(String name, String message){
        if(!playerMap.containsKey(name)){
            playerMap.put(name, new Player(name, message));
        }
    }

    public void RemovePlayer(Player player){
        if(playerMap.containsKey(player.getName())){
            playerMap.remove(player.getName());
        }
        else{
            throw new IllegalArgumentException("No player of Name " + player.getName()+ " was Found");
        }
    }

    /**
     * Getter for playerMap
     * @return
     */
    public Set<Player> getInters() {
        Set<Player> inters = new HashSet<>(playerMap.values());
        return inters;
    }
}
