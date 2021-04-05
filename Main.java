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
