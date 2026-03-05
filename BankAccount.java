// Visitable Interface
public interface BankAccount {
    void accept(BankVisitor visitor);
    double getBalance();
}