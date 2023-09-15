public interface IAccount {
    void deposit(double depositAmount);
    void withdraw(double withdrawAmount) throws BalanceBelowZeroException;
    double getBalance();
}