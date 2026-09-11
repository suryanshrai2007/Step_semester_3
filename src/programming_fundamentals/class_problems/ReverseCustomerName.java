package programming_fundamentals.class_problems;

public class ReverseCustomerName {

    static String reverseCustomerName(String customerName) {
        char[] nameChars = customerName.toCharArray();
        StringBuilder reversedName = new StringBuilder();

        for (int i = nameChars.length - 1; i >= 0; i--) {
            reversedName.append(nameChars[i]);
        }

        return reversedName.toString();
    }

    public static void main(String[] args) {
        String customerName = "Sunil";
        String reversedName = reverseCustomerName(customerName);

        System.out.println("Original Name: " + customerName);
        System.out.println("Reversed Name: " + reversedName);
    }
}