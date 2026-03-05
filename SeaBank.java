public class SeaBank implements BankAccount {
    private final double balance;  // Add 'final' keyword
    
    public SeaBank(double balance) {
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
        return String.format("SeaBank Account [Balance: ₱%.2f]", balance);
    }
}