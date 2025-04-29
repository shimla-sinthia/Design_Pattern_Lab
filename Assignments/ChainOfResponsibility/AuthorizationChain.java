abstract class AuthorizationHandler {

  protected AuthorizationHandler nextHandler;

  public void setNextHandler(AuthorizationHandler nextHandler) {
      this.nextHandler = nextHandler;
  }

  public abstract void authorize(double amount);
}


class Cashier extends AuthorizationHandler {

  @Override
  public void authorize(double amount) {
      if (amount < 10000) {
          System.out.println("Cashier: Authorized withdraw of Tk. " + amount);
      } else if (nextHandler != null) {
          System.out.println("Cashier: Forwarding request for Tk. " + amount + " to Senior Officer.");
          nextHandler.authorize(amount);
      }
  }
}


class SeniorOfficer extends AuthorizationHandler {

  @Override
  public void authorize(double amount) {
      if (amount >= 10000 && amount <= 1000000) {
          System.out.println("Senior Officer: Authorized withdraw of Tk. " + amount);
          System.out.println("Cashier: Finalizing withdraw of Tk. " + amount);
      } else if (nextHandler != null) {
          System.out.println("Senior Officer: Forwarding request for Tk. " + amount + " to Manager.");
          nextHandler.authorize(amount);
      }
  }
}

class Manager extends AuthorizationHandler {

  @Override
  public void authorize(double amount) {
      if (amount > 1000000) {
          System.out.println("Manager: Authorized withdraw of Tk. " + amount);
          System.out.println("Senior Officer: Finalizing withdraw of Tk. " + amount);
      }
  }
}


public class AuthorizationChain {
  private static AuthorizationHandler getAuthorizationChain() {
      AuthorizationHandler cashier = new Cashier();
      AuthorizationHandler seniorOfficer = new SeniorOfficer();
      AuthorizationHandler manager = new Manager();

      cashier.setNextHandler(seniorOfficer);
      seniorOfficer.setNextHandler(manager);

      return cashier;
  }

  public static void main(String[] args) {
      AuthorizationHandler chain = getAuthorizationChain();

      // chain.authorize(5000);         
    //   chain.authorize(50000);       
      chain.authorize(1500000);     
  }
}
