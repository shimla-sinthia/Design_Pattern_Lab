// WithdrawalApprovalDemo.java

// Abstract handler
abstract class Approver {
    protected Approver nextApprover;

    public void setNextApprover(Approver nextApprover) {
        this.nextApprover = nextApprover;
    }

    public void approveWithdrawal(int amount) {
        if (canApprove(amount)) {
            processRequest(amount);
        } else if (nextApprover != null) {
            nextApprover.approveWithdrawal(amount);
        } else {
            System.out.println("No approver available for Tk. " + amount);
        }
    }

    protected abstract boolean canApprove(int amount);
    protected abstract void processRequest(int amount);
}

// Concrete handler: Cashier
class Cashier extends Approver {
    @Override
    protected boolean canApprove(int amount) {
        return amount < 10000;
    }

    @Override
    protected void processRequest(int amount) {
        System.out.println("Cashier approved withdrawal of Tk. " + amount);
    }
}

// Concrete handler: Senior Officer
class SeniorOfficer extends Approver {
    @Override
    protected boolean canApprove(int amount) {
        return amount >= 10000 && amount <= 1000000;
    }

    @Override
    protected void processRequest(int amount) {
        System.out.println("Senior Officer approved withdrawal of Tk. " + amount);
    }
}

// Concrete handler: Manager
class Manager extends Approver {
    @Override
    protected boolean canApprove(int amount) {
        return amount > 1000000;
    }

    @Override
    protected void processRequest(int amount) {
        System.out.println("Manager approved withdrawal of Tk. " + amount);
    }
}

public class ChainWithdrawalApproval {
    public static void main(String[] args) {
        // Create the chain
        Approver cashier = new Cashier();
        Approver seniorOfficer = new SeniorOfficer();
        Approver manager = new Manager();

        cashier.setNextApprover(seniorOfficer);
        seniorOfficer.setNextApprover(manager);

        // Sample test cases
        System.out.println("Trying to withdraw Tk. 5,000:");
        cashier.approveWithdrawal(5000);

        System.out.println("\nTrying to withdraw Tk. 250,000:");
        cashier.approveWithdrawal(250000);

        System.out.println("\nTrying to withdraw Tk. 2,000,000:");
        cashier.approveWithdrawal(2000000);
    }
}
