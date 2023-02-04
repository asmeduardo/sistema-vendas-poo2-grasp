package app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import app.model.entities.OrderProduct;
import app.model.entities.Product;

public class ProductService {
    private List<Product> products;

    public ProductService(List<Product> products) {
        this.products = products;
    }

    public List<Product> getAllProducts() {
        List<Product> result = new ArrayList<Product>();
        for (Product product : products) {
            result.add(product);
        }
        return result;
    }

    public List<OrderProduct> getProductsById(Map<Integer, Integer> ids) {
        List<OrderProduct> result = new ArrayList<OrderProduct>();
        for (Map.Entry<Integer, Integer> entry : ids.entrySet()) {
            int id = entry.getKey();
            int quantity = entry.getValue();
            for (Product product : products) {
                if (product.getId() == id) {
                    result.add(new OrderProduct(product, quantity));
                    break;
                }
            }
        }
        return result;
    }
}