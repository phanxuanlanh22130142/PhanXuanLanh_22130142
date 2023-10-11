package lap3;

public class OrderItem {
    private Product p;
    private int quantity;
    
    public OrderItem(Product p, int quantity) {
        this.p = p;
        this.quantity = quantity;
    }
    
    public Product getProduct() {
        return p;
    }
    
    public int getQuantity() {
        return quantity;
    }
}