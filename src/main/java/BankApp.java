import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class BankApp {
    Bank newBank = new Bank();

    public void bankAppRunner() {

        ArrayList<Integer> accountNumbers = csvToBankAccounts();
        //newBank.printAllAccounts();

        IAccount newAccount1 = newBank.getAccountByNumber(accountNumbers.get(0));
        IAccount newAccount2 = newBank.getAccountByNumber(accountNumbers.get(4));
        System.out.println(newAccount1.getBalance());
        System.out.println(newAccount2.getBalance());
        boolean didItWork = false;
        didItWork = newBank.transferMoney(newAccount2, newAccount1, 500.00);
        if (didItWork) {
            System.out.println("Yes");
        }
        System.out.println(newAccount1.getBalance());
        System.out.println(newAccount2.getBalance());

    }

    public ArrayList<Integer> csvToBankAccounts() {
        ArrayList<Integer> accountNumbers = new ArrayList<>();
        try (Scanner fileScanner = new Scanner(new File("src/main/resources/BankAccounts.csv"))) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] accountDetails = line.split(", ");
                int accountNumber = newBank.createAccount(accountDetails[0], Double.parseDouble(accountDetails[1]));
                accountNumbers.add(accountNumber);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Hey, we couldn't find the file!");
        }
        return accountNumbers;
    }

}


