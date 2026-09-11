package oop_constructs.assigment_problems;

public class CardPayment extends Payment {
    double payWithProcessingFee(double amount) {
        double totalCharged = amount + (amount * 0.02);
        System.out.println("Charged (card, incl. fee): Rs " + totalCharged);
        return totalCharged;
    }
}