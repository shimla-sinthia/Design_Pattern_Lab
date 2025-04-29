// Step 1 - Create Notification interface
interface Notification {
    void notifyUser();
}

// Step 2 - Concrete classes for each notification type
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

// Step 3 - Factory class
class NotificationFactory {
    public static Notification createNotification(String type) {
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

// Step 4 - Demo class to test factory
public class FactoryNotificationFactory {
    public static void main(String[] args) {
        Notification notification1 = NotificationFactory.createNotification("EMAIL");
        notification1.notifyUser();

        Notification notification2 = NotificationFactory.createNotification("SMS");
        notification2.notifyUser();

        Notification notification3 = NotificationFactory.createNotification("PUSH");
        notification3.notifyUser();

        Notification notification4 = NotificationFactory.createNotification("UNKNOWN");
        if (notification4 == null) {
            System.out.println("Unknown notification type.");
        }
    }
}
