package app.view;

import java.util.List;

import app.model.entities.Order;
import app.model.entities.Product;

public class ConsoleView implements View {
    public void displayProducts(List<Product> products) {
        for (Product p : products) {
            System.out.println(
                    p.getId() 
                    + " - " 
                    + p.getName() 
                    + " - R$" 
                    + String.format("%.2f", p.getPrice())
                    + " - " 
                    + p.getStock() 
                    + " em estoque");
        }
    }

    @Override
    public void displayOrder(Order order) {
        System.out.println(order);
    }

    public void displayMessage(String message) {
        System.out.print(message);
    }

}