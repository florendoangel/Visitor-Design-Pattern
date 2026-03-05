import java.util.ArrayList;
import java.util.List;

public class BankVisitorDemo {
    
    public static void main(String[] args) {
        System.out.println("============================================================");
        System.out.println("VISITOR DESIGN PATTERN - BANK INTEREST & INSURANCE DEMO");
        System.out.println("============================================================\n");
        
        // Create different bank accounts with various balances
        List<BankAccount> accounts = createSampleAccounts();
        
        // Display all accounts
        System.out.println("Bank Accounts:");
        System.out.println("----------------------------------------");
        displayAccounts(accounts);
        
        System.out.println("\n============================================================");
        System.out.println("PART 1: INTEREST CALCULATION");
        System.out.println("------------------------------------------------------------");
        
        // Calculate interest for all accounts
        InterestCalculator interestCalc = new InterestCalculator();
        processAccounts(accounts, interestCalc);
        System.out.printf("%n%s%n", "------------------------------------------------------------");
        System.out.printf("SUMMARY: Total Interest Earned: ₱%.2f%n", 
                         interestCalc.getTotalInterest());
        
        System.out.println("\n============================================================");
        System.out.println("PART 2: INSURANCE CALCULATION");
        System.out.println("------------------------------------------------------------");
        
        // Calculate insurance coverage for all accounts
        InsuranceCalculator insuranceCalc = new InsuranceCalculator();
        processAccounts(accounts, insuranceCalc);
        System.out.printf("%n%s%n", "------------------------------------------------------------");
        System.out.printf("SUMMARY: Total Insurance Coverage: ₱%.2f%n", 
                         insuranceCalc.getTotalInsurance());
        
        System.out.println("\n============================================================");
        System.out.println("PART 3: TAX CALCULATION (NEW OPERATION)");
        System.out.println("------------------------------------------------------------");
        System.out.println("Note: This operation was added without modifying bank classes!");
        System.out.println("------------------------------------------------------------");
        
        // Calculate tax on interest
        TaxCalculator taxCalc = new TaxCalculator();
        processAccounts(accounts, taxCalc);
        System.out.printf("%n%s%n", "------------------------------------------------------------");
        System.out.printf("SUMMARY: Total Tax Payable: ₱%.2f%n", 
                         taxCalc.getTotalTax());
        
        System.out.println("\n============================================================");
    }
    
    private static List<BankAccount> createSampleAccounts() {
        List<BankAccount> accounts = new ArrayList<>();
        accounts.add(new Cimb(100000));      // ₱100,000 balance
        accounts.add(new SeaBank(200000));    // ₱200,000 balance
        accounts.add(new GoTyme(150000));      // ₱150,000 balance
        accounts.add(new Cimb(25000));        // Below insurance threshold
        accounts.add(new SeaBank(750000));      // High balance
        return accounts;
    }
    
    private static void displayAccounts(List<BankAccount> accounts) {
        for (int i = 0; i < accounts.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, accounts.get(i));
        }
    }
    
    private static void processAccounts(List<BankAccount> accounts, BankVisitor visitor) {
        for (BankAccount account : accounts) {
            account.accept(visitor);
        }
    }
}