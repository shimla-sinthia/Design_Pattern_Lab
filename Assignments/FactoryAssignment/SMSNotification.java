class SMSNotification implements Notification {
  @Override
  public void notifyUser(String s) {
      System.out.println("SMS Notification: " + s);
  }
}