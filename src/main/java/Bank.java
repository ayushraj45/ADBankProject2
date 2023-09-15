import java.util.HashMap;

public class Bank {
    HashMap<Integer, IAccount> accounts = new HashMap<Integer, IAccount>();


    int createAccount(String accountName, double initialBalance) { // creates a new account
        int accountNumber;
       do
       {
           accountNumber= (int) (Math.random()*1000);
       }
       while(accounts.containsKey(accountNumber));

       Account newAccount = new Account(accountNumber, accountName, initialBalance);
       accounts.put(accountNumber, newAccount);
       return accountNumber;
    }

    IAccount getAccountByNumber(int accountNumber) {

        if (accounts.containsKey(accountNumber)) {
            return accounts.get(accountNumber);
        } else throw new IllegalArgumentException("This account doesn't exist");
    }

    boolean transferMoney(IAccount fromAccount, IAccount toAccount, double amount) {

        double fromAccountBalance = fromAccount.getBalance();
        double toAccountBalance = toAccount.getBalance();
        try {
            fromAccount.withdraw(amount);
            toAccount.deposit(amount);
            return true;
        } catch (Exception e) {
            if ((fromAccountBalance != fromAccount.getBalance()) && (toAccountBalance == toAccount.getBalance())) {
                fromAccount.deposit(amount);
                return false;

            }
            return false;
        }
    }

    void printAllAccounts() {
        for (IAccount account: accounts.values()
             ) {
            System.out.println(account.toString());
        }
    }
}
