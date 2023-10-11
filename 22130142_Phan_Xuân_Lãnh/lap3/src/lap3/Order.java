package lap3;

import java.util.Arrays;

public class Order {
    private OrderItem[] items;
    
    public double cost() {
        double totalCost = 0.0;
        for (OrderItem item : items) {
            totalCost += item.getQuantity() * item.getProduct().getPrice();
        }
        return totalCost;
    }
    
    
    public boolean contains(Product p) {
        Product[] products = new Product[items.length];
        for (int i = 0; i < items.length; i++) {
            products[i] = items[i].getProduct();
        }
        
        Arrays.sort(products, (a, b) -> a.getId().compareTo(b.getId()));
        int index = Arrays.binarySearch(products, p, (a, b) -> a.getId().compareTo(b.getId()));
        
        return index >= 0;
    }
    
 
    public Product[] filter(String type) {
        int count = 0;
        for (OrderItem item : items) {
            if (item.getProduct().getType().equalsIgnoreCase(type)) {
                count++;
            }
        }
        
        Product[] filteredProducts = new Product[count];
        int index = 0;
        for (OrderItem item : items) {
            if (item.getProduct().getType().equalsIgnoreCase(type)) {
                filteredProducts[index++] = item.getProduct();
            }
        }
        return filteredProducts;
    }



    public static void main(String[] args) {
        
        Product product1 = new Product("P001", "Product 1", 10.0, "Type 1");
        Product product2 = new Product("P002", "Product 2", 20.0, "Type 2");
        Product product3 = new Product("P003", "Product 3", 30.0, "Type 1");

        
        OrderItem item1 = new OrderItem(product1, 2);
        OrderItem item2 = new OrderItem(product2, 3);
        OrderItem item3 = new OrderItem(product3, 1);

        
        Order order = new Order();
        order.setItems(new OrderItem[] { item1, item2, item3 });

        
        double totalCost = order.cost();
        System.out.println("Total cost: " + totalCost);

      
        Product searchProduct = new Product("P002", "Product 2", 20.0, "Type 2");
        boolean contains = order.contains(searchProduct);
        System.out.println("Contains product: " + contains);

        
        String searchType = "Type 1";
        Product[] filteredProducts = order.filter(searchType);
        System.out.println("Filtered products:");
        for (Product product : filteredProducts) {
            System.out.println("- " + product.getPrice());
        }
    }

    public void setItems(OrderItem[] items) {
        this.items = items;
    }
}

