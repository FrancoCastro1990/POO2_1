package decorator;

public abstract class Decorator implements Component {
    protected Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public double applyDiscount(double price) {
        return component.applyDiscount(price);
    }
}