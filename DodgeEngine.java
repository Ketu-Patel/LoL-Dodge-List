
import java.util.*;
import java.io.*;

public class DodgeEngine {
    ArrayList<Player> inters = new ArrayList<Player>();

    public DodgeEngine(){

    }

    /**
     * Stores Content of Inters Arraylist in Text File as CSV
     */
    public void StoreText(){
        try {
            FileWriter csvWriter = new FileWriter("Dodge_List.txt");
            for (Player a : inters) {
                String[] temp = {a.getName(), a.getMessage()};
                csvWriter.append(String.join(",", temp));
                csvWriter.append("\n");
            }
            csvWriter.flush();
            csvWriter.close();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Reads in CSV to populate inters Arraylist
     */
    public void ReadIn(){
        inters.clear();
        try {
            BufferedReader csvReader = new BufferedReader(new FileReader("Dodge_List.txt"));
            String row;
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(",");
                AddPlayer(data[0], data[1]);
            }
            csvReader.close();
        }
        catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public void AddPlayer(String name, String message){
        inters.add(new Player(name, message));
    }

    public void RemovePlayer(Player player){
        inters.remove(player);
    }

    /**
     * Getter for Inters
     * @return
     */
    public ArrayList<Player> getInters() {
        return inters;
    }

    /**
     * Setter for Inters
     * @param inters
     */
    public void setInters(ArrayList<String> inters) {
        inters = inters;
    }
}
