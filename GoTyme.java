public class GoTyme implements BankAccount {
    private final double balance;  // Add 'final' keyword
    
    public GoTyme(double balance) {
        this.balance = balance;
    }
    
    @Override
    public void accept(BankVisitor visitor) {
        visitor.visit(this);
    }
    
    @Override
    public double getBalance() {
        return balance;
    }
    
    @Override
    public String toString() {
        return String.format("GoTyme Account [Balance: ₱%.2f]", balance);
    }
}