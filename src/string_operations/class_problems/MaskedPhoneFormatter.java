package string_operations.class_problems;

public class MaskedPhoneFormatter {

    static String maskPhoneNumber(String phone) {
        if (phone.length() != 10 || !phone.matches("[0-9]+")) {
            return "Invalid phone number";
        }

        StringBuilder masked = new StringBuilder();
        masked.append("XXXXXX");
        masked.append("-");
        masked.append(phone.substring(6));

        return masked.toString();
    }

    public static void main(String[] args) {
        System.out.println(maskPhoneNumber("9876543210"));
        System.out.println(maskPhoneNumber("98765"));
    }
}