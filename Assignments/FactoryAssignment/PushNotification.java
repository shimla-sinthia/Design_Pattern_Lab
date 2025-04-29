class PushNotification implements Notification {
  @Override
  public void notifyUser(String s) {
      System.out.println("Push Notification: " + s);
  }
}