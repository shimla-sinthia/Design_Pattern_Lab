// Notification interface
interface Notification {
    void notifyUser();
}

// Concrete implementations
class EmailNotification implements Notification {
    public void notifyUser() {
        System.out.println("Sending an Email Notification");
    }
}

class SMSNotification implements Notification {
    public void notifyUser() {
        System.out.println("Sending an SMS Notification");
    }
}

class PushNotification implements Notification {
    public void notifyUser() {
        System.out.println("Sending a Push Notification");
    }
}

// Singleton Factory
class NotificationFactory {

    // static instance (eager initialization)
    private static final NotificationFactory instance = new NotificationFactory();

    // private constructor
    private NotificationFactory() {}

    // public accessor
    public static NotificationFactory getInstance() {
        return instance;
    }

    // factory method
    public Notification createNotification(String type) {
        if (type == null || type.isEmpty()) {
            return null;
        }
        if (type.equalsIgnoreCase("EMAIL")) {
            return new EmailNotification();
        } else if (type.equalsIgnoreCase("SMS")) {
            return new SMSNotification();
        } else if (type.equalsIgnoreCase("PUSH")) {
            return new PushNotification();
        }
        return null;
    }
}

// Demo
public class SingletonNotificationFactory {
    public static void main(String[] args) {
        NotificationFactory factory = NotificationFactory.getInstance();

        Notification n1 = factory.createNotification("EMAIL");
        n1.notifyUser();

        Notification n2 = factory.createNotification("SMS");
        n2.notifyUser();

        Notification n3 = factory.createNotification("PUSH");
        n3.notifyUser();

        Notification n4 = factory.createNotification("UNKNOWN");
        if (n4 == null) {
            System.out.println("Unknown notification type.");
        }

        // Confirm singleton behavior
        NotificationFactory factory2 = NotificationFactory.getInstance();
        System.out.println("\nIs factory1 == factory2? " + (factory == factory2)); // should print true
    }
}
