public class Main {
    public static void main(String[] args){
        DodgeEngine DodgeEngine1 = new DodgeEngine();
        DodgeEngine1.AddPlayer("mani", "noob");
        DodgeEngine1.AddPlayer("k2", "smurf riven main");
        DodgeEngine1.AddPlayer("hari", "katarina griefer");
        DodgeEngine1.StoreText();
        DodgeEngine1.ReadIn();
        System.out.println(DodgeEngine1.inters.get(2).getMessage());
    }
}
