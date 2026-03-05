public class InterestCalculator implements BankVisitor {
    private double totalInterest = 0;
    
    @Override
    public void visit(Cimb cimb) {
        double interest = cimb.getBalance() * 0.026; // 2.6% interest
        totalInterest += interest;
        System.out.printf("Cimb Interest: ₱%.2f%n", interest);
    }
    
    @Override
    public void visit(SeaBank seaBank) {
        double interest = seaBank.getBalance() * 0.05; // 5% interest
        totalInterest += interest;
        System.out.printf("SeaBank Interest: ₱%.2f%n", interest);
    }
    
    @Override
    public void visit(GoTyme goTyme) {
        double interest = goTyme.getBalance() * 0.045; // 4.5% interest
        totalInterest += interest;
        System.out.printf("GoTyme Interest: ₱%.2f%n", interest);
    }
    
    public double getTotalInterest() {
        return totalInterest;
    }
}