package assigment_problems;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Assignment3 {

    // Naive approach (scanning whole list again for each item):
    // Time Complexity: O(n^2)
    // Space Complexity: O(1) additional (not counting output)

    // Optimal approach using hash map:
    // Time Complexity: O(n) - one pass to count, one pass to find first max
    // Space Complexity: O(k) where k is the number of distinct items
    static Object[] mostPopular(List<String> orders) {
        Map<String, Integer> counts = new LinkedHashMap<>();

        for (String item : orders) {
            counts.put(item, counts.getOrDefault(item, 0) + 1);
        }

        String bestItem = null;
        int bestCount = -1;

        // Scan orders in original order to correctly break ties
        for (String item : orders) {
            int count = counts.get(item);
            if (count > bestCount) {
                bestCount = count;
                bestItem = item;
            }
        }

        return new Object[]{bestItem, bestCount};
    }

    public static void main(String[] args) {
        List<String> orders1 = List.of("dosa", "idli", "vada", "dosa", "idli", "dosa", "tea");
        Object[] result1 = mostPopular(orders1);
        System.out.println("(" + result1[0] + ", " + result1[1] + ")"); // (dosa, 3)

        List<String> orders2 = List.of("tea", "coffee", "coffee", "tea");
        Object[] result2 = mostPopular(orders2);
        System.out.println("(" + result2[0] + ", " + result2[1] + ")"); // (tea, 2)
    }
}