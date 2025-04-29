class NotificationFactory {

    private static NotificationFactory instance;
    private NotificationFactory() {}
    public static NotificationFactory getInstance() {
        if (instance == null) {
            instance = new NotificationFactory();
        }
        return instance;
    }
    public Notification createNotification(String type) {
        if (type == null || type.isEmpty()) {
            return null;
        } else if (type.equalsIgnoreCase("1")) {
            return new SMSNotification();
        } else if (type.equalsIgnoreCase("2")) {
            return new EmailNotification();
        } else if (type.equalsIgnoreCase("3")) {
            return new PushNotification();
        } else {
            throw new IllegalArgumentException("Unknown notification type: " + type);
        }
    }
}








