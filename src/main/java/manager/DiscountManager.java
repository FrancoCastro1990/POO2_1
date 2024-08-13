package manager;

public class DiscountManager {
    private static DiscountManager instance;

    private DiscountManager() {
    }

    public static DiscountManager getInstance() {
        if (instance == null) {
            instance = new DiscountManager();
        }
        return instance;
    }

    // Método para aplicar descuento
    public double applyDiscount(double price, String discountType) {
        switch (discountType) {
            case "NORMAL":
                return price * 0.95; // 5% de descuento
            case "VIP":
                return price * 0.9; // 10% de descuento
            case "SPECIAL":
                return price * 0.85; // 15% de descuento
            default:
                return price; // Sin descuento
        }
    }
}