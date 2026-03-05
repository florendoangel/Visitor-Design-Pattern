// Visitor Interface
public interface BankVisitor {
    void visit(Cimb cimb);
    void visit(SeaBank seaBank);
    void visit(GoTyme goTyme);
}