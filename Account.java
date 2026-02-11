package Basic;

class Account {
 protected String accountNumber;
 protected String holderName;
 protected double balance;
 protected double interestRate; 

 public Account(String accountNumber, String holderName, double balance, double interestRate) {
     this.accountNumber = accountNumber;
     this.holderName = holderName;
     this.balance = balance;
     this.interestRate = interestRate;
 }

 public void deposit(double amount) {
     if (amount > 0) {
         balance = balance + amount;
     }
 }

 public void withdraw(double amount) {
     if (amount > 0 && amount <= balance) {
         balance = balance - amount;
     }
 }

 public void calculateAndAddInterest() {
     double interest = (balance * interestRate) / 100.0;
     balance = balance + interest;
     System.out.println("Interest added in Account: " + interest);
 }

 public void showDetails() {
     System.out.println("Account Number : " +accountNumber);
     System.out.println("Holder Name    : " +holderName);
     System.out.println("Balance        : " +balance);
 }
}

class SavingsAccount extends Account  {

 public SavingsAccount(String accountNumber, String holderName, double balance, double interestRate) {
     super(accountNumber, holderName, balance, interestRate);
 }

 @Override
 public void calculateAndAddInterest() {
     double interest = (balance * interestRate) / 100.0;
     balance = balance + interest;
     System.out.println("Interest added in Savings Account: " + interest);
 }

 @Override
 public void showDetails() {
     System.out.println("=== Savings Account ===");
     super.showDetails();
 }
}

class CurrentAccount extends Account  {

 private double minimumBalance;
 private double penaltyAmount;

 public CurrentAccount(String accountNumber, String holderName, double balance, double interestRate, double minimumBalance, double penaltyAmount) {
     super(accountNumber, holderName, balance, interestRate);
     this.minimumBalance = minimumBalance;
     this.penaltyAmount = penaltyAmount;
 }


 @Override
 public void calculateAndAddInterest() {
      System.out.println("No interest added for Current Account.");
 }

 @Override
 public void withdraw(double amount) {
     if (amount > 0 && amount <= balance) {
         balance = balance - amount;
         if (balance < minimumBalance) {
             balance = balance - penaltyAmount;
             System.out.println("Balance below minimum, penalty charged: " + penaltyAmount);
         }
     }
 }

 @Override
 public void showDetails() {
     System.out.println("=== Current Account ===");
     super.showDetails();
     System.out.println("Minimum Balance : " + minimumBalance);
 }
}

class BankCalculator {
 public static void main(String[] args) {

     SavingsAccount SA = new SavingsAccount("Savings101", "Pavan", 10000.0, 5.5);
     CurrentAccount CA = new CurrentAccount("Current101", "Pavan", 15000.0, 0.0, 5000.0, 200.0);

     System.out.println("===== Beforeinterest =====");
     SA.showDetails();
     CA.showDetails();
     System.out.println();
     SA.calculateAndAddInterest();
     CA.calculateAndAddInterest();
     System.out.println();
     System.out.println("===== Afterinterest =====");
     SA.showDetails();
     CA.showDetails();
     System.out.println();
     System.out.println("===== Withdraw operations =====");
     SA.withdraw(2000.0);
     CA.withdraw(12000.0); 
     System.out.println();
     System.out.println("==== Final Details ====");
     SA.showDetails();
     CA.showDetails();
 }
}
