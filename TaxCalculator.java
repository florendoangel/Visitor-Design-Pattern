public class TaxCalculator implements BankVisitor {
    private double totalTax = 0;
    private static final double TAX_RATE = 0.20; // 20% tax on interest
    
    @Override
    public void visit(Cimb cimb) {
        double interest = cimb.getBalance() * 0.026;
        double tax = interest * TAX_RATE;
        totalTax += tax;
        System.out.printf("Cimb Tax: ₱%.2f%n", tax);
    }
    
    @Override
    public void visit(SeaBank seaBank) {
        double interest = seaBank.getBalance() * 0.05;
        double tax = interest * TAX_RATE;
        totalTax += tax;
        System.out.printf("SeaBank Tax: ₱%.2f%n", tax);
    }
    
    @Override
    public void visit(GoTyme goTyme) {
        double interest = goTyme.getBalance() * 0.045;
        double tax = interest * TAX_RATE;
        totalTax += tax;
        System.out.printf("GoTyme Tax: ₱%.2f%n", tax);
    }
    
    public double getTotalTax() {
        return totalTax;
    }
}