package programming_fundamentals.assigment_problems;

public class TypingAccuracyChecker {

    static void checkTypingAccuracy(String original, String typed) {
        int matchedCount = 0;
        int firstMismatchPosition = -1;
        char firstMismatchOriginalChar = ' ';
        char firstMismatchTypedChar = ' ';

        for (int i = 0; i < original.length(); i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matchedCount++;
            } else if (firstMismatchPosition == -1) {
                firstMismatchPosition = i + 1;
                firstMismatchOriginalChar = original.charAt(i);
                firstMismatchTypedChar = typed.charAt(i);
            }
        }

        double accuracy = (matchedCount * 100.0) / original.length();
        double roundedAccuracy = Math.round(accuracy * 100.0) / 100.0;

        if (firstMismatchPosition == -1) {
            System.out.println("Matched: " + matchedCount + "/" + original.length()
                    + " | Accuracy: " + roundedAccuracy + "% | No Mismatches");
        } else {
            System.out.println("Matched: " + matchedCount + "/" + original.length()
                    + " | Accuracy: " + roundedAccuracy + "% | First Mismatch at position "
                    + firstMismatchPosition + " ('" + firstMismatchOriginalChar + "' vs '"
                    + firstMismatchTypedChar + "')");
        }
    }

    public static void main(String[] args) {
        checkTypingAccuracy("hello world", "hello worlt");
        checkTypingAccuracy("coding", "coding");
    }
}