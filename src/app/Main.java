package app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import app.controller.OrderController;
import app.model.entities.Client;
import app.model.entities.Product;
import app.model.enums.PaymentMethod;
import app.service.OrderService;
import app.service.PaymentService;
import app.service.ProductService;
import app.view.ConsoleView;
import app.view.View;

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1, "Arroz", 25.40, 20));
        products.add(new Product(2, "Ovos (30 uni.)", 14.00, 30));
        products.add(new Product(3, "Feijão", 8.75, 40));
        products.add(new Product(4, "Leite", 4.50, 50));
        products.add(new Product(5, "Açucar", 15.90, 50));

        Client client1 = new Client(1, "João", "Silva", "joao@gmail.com");

        View view = new ConsoleView();
        ProductService productService = new ProductService(products);
        OrderService orderService = new OrderService();
        PaymentService paymentService = new PaymentService();
        OrderController sales = new OrderController(view, productService, orderService, paymentService);

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println();
            view.displayMessage("1. Mostrar produtos\n");
            view.displayMessage("2. Criar pedido\n");
            view.displayMessage("3. Sair\n");

            System.out.print("Escolha uma opção: ");
            int option = sc.nextInt();
            sc.nextLine();
            if (option == 1) {
                System.out.println();
                sales.displayProducts();
            } else if (option == 2) {
                System.out.println();
                view.displayMessage("Selecione os produtos (id do produto:quantidade, separados por vírgulas): ");
                String[] productQuantities = sc.nextLine().split(",");
                Map<Integer, Integer> ids = new HashMap<>();
                for (String p : productQuantities) {
                    String[] temp = p.split(":");
                    ids.put(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
                }
                System.out.println();
                view.displayMessage("Selecione a forma de pagamento (CARTAO_CREDITO ou CARTAO_DEBITO): ");
                String paymentMethod = sc.nextLine();
                PaymentMethod method = PaymentMethod.valueOf(paymentMethod);
                System.out.println();
                sales.createOrder(client1, ids, method);
            } else if (option == 3) {
                break;
            }
        }
        sc.close();
    }
}
