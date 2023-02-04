package app.service;

import java.util.List;

import app.model.entities.Client;
import app.model.entities.Order;
import app.model.entities.OrderProduct;
import app.model.enums.PaymentMethod;

public class OrderService {
    public Order createOrder(Client client, List<OrderProduct> products, PaymentMethod method) {
        return new Order(client, products, method);
    }
}