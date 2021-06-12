package application;

public class Player {
    private String name;
    private String message;

    public Player(String inputName, String inputMessage){
        name = inputName;
        message = inputMessage;

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
}
