package application;

public class Player {
    private String name;
    private int gamesLost;
    private int gamesWon;
    private int gamesDodged;
    private String message;

    public Player(String inputName, String inputMessage){
        name = inputName;
        message = inputMessage;
        gamesLost = 0;
        gamesWon = 0;
        gamesDodged = 0;

    }
    public Player(String inputName, int gamesLost, int gamesWon, int gamesDodged, String inputMessage){
        this.name = inputName;
        this.message = inputMessage;
        this.gamesLost = 0;
        this.gamesWon = 0;
        this.gamesDodged = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String nameIn) {
        name = nameIn;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String messageIn) {
        message = messageIn;
    }

    public int getGamesLost() {
        return gamesLost;
    }

    public int getGamesWon() {
        return gamesWon;
    }

    public int getGamesLeft() {
        return gamesDodged;
    }

    @Override
    public String toString() {
        return "Name='" + name + '\'' +
                ", Games Lost With Player=" + gamesLost +
                ", Games Won With Player=" + gamesWon +
                ", Games Dodged With Player=" + gamesDodged +
                ", Note='" + message + '\'';
    }
}
