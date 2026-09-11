package programming_fundamentals.class_problems;

import java.util.HashMap;

public class FirstNonRepeatingChar {

    static Character findFirstNonRepeatingChar(String text) {
        HashMap<Character, Integer> frequencyMap = new HashMap<>();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (frequencyMap.get(ch) == 1) {
                return ch;
            }
        }

        return null;
    }

    static void printFirstNonRepeatingChar(String text) {
        Character result = findFirstNonRepeatingChar(text);

        if (result == null) {
            System.out.println("No Non-Repeating Character Found");
        } else {
            System.out.println("First Non-Repeating Character: '" + result + "'");
        }
    }

    public static void main(String[] args) {
        printFirstNonRepeatingChar("swiss");
        printFirstNonRepeatingChar("aabbcc");
    }
}