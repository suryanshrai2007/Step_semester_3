package oop_constructs.assigment_problems;

public class PaymentDispatcher {
    double totalCollected = 0;

    void processTransaction(Payment payment, double amount) {
        if (payment instanceof CardPayment) {
            CardPayment cardPayment = (CardPayment) payment;
            totalCollected += cardPayment.payWithProcessingFee(amount);
        } else {
            payment.pay(amount);
            totalCollected += amount;
        }
    }

    public static void main(String[] args) {
        Payment[] payments = {
                new CardPayment(),
                new Payment(),
                new CardPayment(),
                new Payment(),
                new CardPayment()
        };

        double[] amounts = {100, 50, 200, 75, 120};

        PaymentDispatcher dispatcher = new PaymentDispatcher();

        for (int i = 0; i < payments.length; i++) {
            dispatcher.processTransaction(payments[i], amounts[i]);
        }

        System.out.println("Total Collected: Rs " + dispatcher.totalCollected);
    }
}