import java.util.*;

public class BankAccount 
{
    private int accountNumber;
    private double balance;
    private String accountName;
    BankAccount(int accountNumber, String accountName, double balance)
    {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.balance = balance;
    }

    //methods
    public double displayBalance() {
        return this.balance;
    }

    public void withdraw(double money)
    {
        System.out.println("=============================\n");
        if (money > this.balance)
            System.out.println("    Insufficient Balance.");

        else
        {
            System.out.println("\n  Withdrawal succesful: " + money);
            this.balance -= money;
        }
    }

    public void deposit(double money)
    {
        System.out.println("==============================");
        System.out.println("\n  Deposit successful: " + money);
        this.balance += money;
    }
    

    public static void main(String[] args)
    {
        int userChoice;
        Scanner scan = new Scanner (System.in);
        System.out.println("\n==============================");
        System.out.println("     BANK ACCOUNT SYSTEM");
        System.out.println("==============================\n");

        System.out.print("Enter account id: ");
        int accId = scan.nextInt();
        scan.nextLine();
        System.out.print("Enter account name: ");
        String accName = scan.nextLine();
        System.out.print("Enter account balance: ");
        double balance = scan.nextDouble();
        scan.nextLine();

        BankAccount account = new BankAccount(accId, accName, balance);
        do 
        {
            System.out.println("\n==============================");
            System.out.printf("Balance: %.2f", account.displayBalance());
            System.out.println("\n==============================\n");

            System.out.println("1. Deposit \n2. Withdraw \n3. Exit");
            System.out.println("\n==============================");
            System.out.print("Enter choice: ");
            userChoice = scan.nextInt();

            if (userChoice == 1) {
                System.out.print("\nDeposit amount: ");
                double money = scan.nextDouble();
                account.deposit(money);
            }   

            else if (userChoice == 2) {
                System.out.print("\nWithdrawal amount: ");
                double money = scan.nextDouble();
                account.withdraw(money);
            }

            else
                System.out.println("\nGoodbye!");
        } while (userChoice != 3);
        scan.close();
    }
}
