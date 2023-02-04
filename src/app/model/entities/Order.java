package app.model.entities;

import java.util.List;
import java.util.Random;

import app.model.enums.PaymentMethod;

public class Order {
    private String orderId;
    private Client client;
    private List<OrderProduct> products;
    private double total;
    private PaymentMethod paymentMethod;
    private boolean isPaid;

    public Order(Client client, List<OrderProduct> products, PaymentMethod paymentMethod) {
        this.client = client;
        this.products = products;
        this.total = calculateTotal();
        this.paymentMethod = paymentMethod;
        this.isPaid = false;

        startSystemParameters();
    }

    private double calculateTotal() {
        double total = 0;
        for (OrderProduct op : products) {
            total += op.getProduct().getPrice() * op.getQuantity();
        }
        return total;
    }

    public void addProduct(OrderProduct product) {
        products.add(product);
        calculateTotal();
    }

    public void removeProduct(OrderProduct product) {
        products.remove(product);
        calculateTotal();
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<OrderProduct> getProducts() {
        return products;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public double getTotal() {
        return total;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public boolean getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }

    private void startSystemParameters() {
        Random generator = new Random();
        orderId = ("" + System.currentTimeMillis() + "" + generator.nextInt(100)).substring(0, 10);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("ID Pedido: " + orderId);
        sb.append("\nID do Cliente: " +client.getClientId());
        sb.append("\nNome do Cliente: " + client.getFirstName() + " " + client.getLastName());
        sb.append("\nForma de Pagamento: " + paymentMethod);
        sb.append("\nProdutos:");
        for (OrderProduct op : products) {
            sb.append("\n" + op.getProduct().getName() 
            + ", preço por unidade: R$" 
            + String.format("%.2f", op.getProduct().getPrice()) 
            + ", quantidade: " 
            + op.getQuantity());
        }
        return sb.toString();
    }
}