package app.model.entities;

import java.util.List;

import app.model.enums.PaymentMethod;

public class Coupon {
    private List<OrderProduct> products;
    private double total;
    private PaymentMethod paymentMethod;

    public Coupon(List<OrderProduct> products, double total, PaymentMethod paymentMethod) {
        this.products = products;
        this.total = total;
        this.paymentMethod = paymentMethod;
    }

    public List<OrderProduct> getProducts() {
        return products;
    }

    public double getTotal() {
        return total;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }
}
