package command;

public class UpdateQuantityCommand implements Command {
    private String product;
    private int quantity;

    public UpdateQuantityCommand(String product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    @Override
    public void execute() {
        System.out.println("Updating quantity of " + product + " to " + quantity);
    }
}
