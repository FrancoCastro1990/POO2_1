package command;

public class AddToCartCommand implements Command {
    private String product;

    public AddToCartCommand(String product) {
        this.product = product;
    }

    @Override
    public void execute() {
        System.out.println("Adding " + product + " to cart");
    }
}
