public class InsuranceCalculator implements BankVisitor {
    private static final double MIN_BALANCE_FOR_INSURANCE = 50000;
    private double totalInsurance = 0;
    
    @Override
    public void visit(Cimb cimb) {
        double balance = cimb.getBalance();
        if (balance >= MIN_BALANCE_FOR_INSURANCE) {
            double insurance = Math.min(balance, 250000);
            totalInsurance += insurance;
            System.out.printf("Cimb Insurance: ₱%.2f%n", insurance);
        } else {
            System.out.println("Cimb: No insurance (balance below ₱50,000)");
        }
    }
    
    @Override
    public void visit(SeaBank seaBank) {
        double balance = seaBank.getBalance();
        if (balance >= MIN_BALANCE_FOR_INSURANCE) {
            double insurance = Math.min(balance, 1000000);
            totalInsurance += insurance;
            System.out.printf("SeaBank Insurance: ₱%.2f%n", insurance);
        } else {
            System.out.println("SeaBank: No insurance (balance below ₱50,000)");
        }
    }
    
    @Override
    public void visit(GoTyme goTyme) {
        System.out.println("GoTyme: No insurance offered");
    }
    
    public double getTotalInsurance() {
        return totalInsurance;
    }
}