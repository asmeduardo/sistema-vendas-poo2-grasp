package app.service;

import app.model.enums.PaymentMethod;

public class PaymentService {
    public boolean processPayment(double total, PaymentMethod method) {
        if (method == PaymentMethod.CARTAO_CREDITO) {
            return processCreditCardPayment(total);
        } else if (method == PaymentMethod.CARTAO_DEBITO) {
            return processDebitCardPayment(total);
        } else {
            return false;
        }
    }

    private boolean processCreditCardPayment(double total) {
        // Process credit card payment
        System.out.println("Processando pagamento com cartão de crédito...");
        System.out.println("Valor do Pedido: R$" + String.format("%.2f",total));
        return true;
    }

    private boolean processDebitCardPayment(double total) {
        // Process debit card payment
        System.out.println("Processando pagamento com cartão de débito...");
        System.out.println("Valor do Pedido: R$" + String.format("%.2f",total));
        return true;
    }
}
