package conecta4.models;

public interface PlayerVisitor {

    void visit(UserPlayer player);

    void visit(MachinePlayer player);
}
