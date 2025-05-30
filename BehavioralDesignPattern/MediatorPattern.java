import java.util.Date;

// Step 1 - Mediator class
class ChatRoom {
    public static void showMessage(User user, String message) {
        System.out.println(new Date().toString() + " [" + user.getName() + "] : " + message);
    }
}

// Step 2 - User class
class User {
    private String name;

    public User(String name){
        this.name  = name;
    }

    public String getName() {
        return name;
    }

    public void sendMessage(String message){
        ChatRoom.showMessage(this, message);
    }
}

public class MediatorPattern{
    public static void main(String[] args) {
        User robert = new User("Robert");
        User john = new User("John");

        robert.sendMessage("Hi! John!");
        john.sendMessage("Hello! Robert!");
    }
}
