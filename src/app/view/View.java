package app.view;

import java.util.List;

import app.model.entities.Order;
import app.model.entities.Product;

public interface View {
    void displayProducts(List<Product> products);
    void displayOrder(Order order);
    void displayMessage(String message);
}