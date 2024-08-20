package command;


public class RemoveFromCartCommand implements Command {
    private String product;

    public RemoveFromCartCommand(String product) {
        this.product = product;
    }

    @Override
    public void execute() {
        System.out.println("Removing " + product + " from cart");
    }
}