package app.model.entities;

import java.util.Random;

public class OrderProduct {
    private String orderProductId;
    private Product product;
    private int quantity;

    public OrderProduct(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;

        startSystemParameters();
    }

    public String getOrderProductId() {
        return orderProductId;
    }

    public void setOrderProductId(String orderProductId) {
        this.orderProductId = orderProductId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    private void startSystemParameters() {
        Random generator = new Random();
        orderProductId = ("" + System.currentTimeMillis() + "" + generator.nextInt(100)).substring(0, 8);
    }
}
