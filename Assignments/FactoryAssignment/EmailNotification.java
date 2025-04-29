class EmailNotification implements Notification {
  @Override
  public void notifyUser(String s) {
      System.out.println("Email Notification: " + s);
  }
}