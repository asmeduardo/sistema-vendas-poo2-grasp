package app.controller;

import java.util.List;
import java.util.Map;

import app.model.entities.Client;
import app.model.entities.Order;
import app.model.entities.OrderProduct;
import app.model.enums.PaymentMethod;
import app.service.OrderService;
import app.service.PaymentService;
import app.service.ProductService;
import app.view.View;

public class OrderController {
    private View view;
    private ProductService productService;
    private OrderService orderService;
    private PaymentService paymentService;

    public OrderController(View view, ProductService productService, OrderService orderService,
            PaymentService paymentService) {
        this.view = view;
        this.productService = productService;
        this.orderService = orderService;
        this.paymentService = paymentService;
    }

    public void displayProducts() {
        view.displayProducts(productService.getAllProducts());
    }

    public void createOrder(Client client, Map<Integer, Integer> ids, PaymentMethod method) {
        List<OrderProduct> orderProducts = productService.getProductsById(ids);
        if (!orderProducts.isEmpty()) {
            Order order = orderService.createOrder(client, orderProducts, method);
            boolean isPaid = paymentService.processPayment(order.getTotal(), method);
            order.setIsPaid(isPaid);
            view.displayOrder(order);
        } else {
            System.out.println();
            view.displayMessage("Nenhum produto selecionado ou alguns dos produtos estão esgotados.");
        }
    }
}
