import java.util.Scanner;

public class NotificationService {
  public static void main(String[] args) {

    
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter the type of notification you want to send\n1.sms\n2.email\n3.push ");
      String type = sc.nextLine();
      sc.close();


      NotificationFactory factory = NotificationFactory.getInstance();

      Notification notification = factory.createNotification(type);
      if (notification != null) {
          notification.notifyUser("Hello ");
      }
  }
}
