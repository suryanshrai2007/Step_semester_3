package assigment_problems;

import java.util.ArrayList;
import java.util.List;

public class Assignment2 {

    // Time Complexity: O(m + n) - two-pointer merge, single pass through both lists
    // Space Complexity: O(m + n) - for the result list
    // (Joining + sorting would be O((m+n) log(m+n)) time, so this is more efficient)
    static List<Integer> mergeTokens(List<Integer> counterA, List<Integer> counterB) {
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < counterA.size() && j < counterB.size()) {
            if (counterA.get(i) <= counterB.get(j)) {
                result.add(counterA.get(i));
                i++;
            } else {
                result.add(counterB.get(j));
                j++;
            }
        }

        while (i < counterA.size()) {
            result.add(counterA.get(i));
            i++;
        }

        while (j < counterB.size()) {
            result.add(counterB.get(j));
            j++;
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> counterA1 = List.of(3, 8, 15, 20);
        List<Integer> counterB1 = List.of(5, 8, 12);
        System.out.println(mergeTokens(counterA1, counterB1)); // [3, 5, 8, 8, 12, 15, 20]

        List<Integer> counterA2 = List.of();
        List<Integer> counterB2 = List.of(4, 9);
        System.out.println(mergeTokens(counterA2, counterB2)); // [4, 9]
    }
}