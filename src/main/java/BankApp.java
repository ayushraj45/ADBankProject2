public class BankApp {
    public void bankAppRunner() {

        Bank newBank = new Bank();

        int account1Number = newBank.createAccount("Ayush", 100000.0);
        int account2Number = newBank.createAccount("Tom", 100000.0);
        int account3Number = newBank.createAccount("John", 100000.0);
        int account4Number = newBank.createAccount("Roney", 100000.0);

        IAccount newAccount2 = newBank.getAccountByNumber(account2Number);
        IAccount newAccount3 = newBank.getAccountByNumber(account3Number);
        IAccount newAccount1 = newBank.getAccountByNumber(account1Number);
        IAccount newAccount4 = newBank.getAccountByNumber(account4Number);


        System.out.println(newAccount3);

        System.out.println(newAccount4.getAccountNumber());
        System.out.println(newAccount4.getAccountHolderName());

        System.out.println(newAccount4.toString());

        boolean moneyIsTranfered;

        System.out.println(newAccount4.getBalance());


        moneyIsTranfered = newBank.transferMoney(newAccount1, newAccount4, 299000.67);
        if (moneyIsTranfered) System.out.println("it worked!");
        else System.out.println("It didn't work");


        System.out.println(newAccount3.getBalance());

        System.out.println(newAccount1.getBalance());

        System.out.println(newAccount4.getBalance());



    }
}
