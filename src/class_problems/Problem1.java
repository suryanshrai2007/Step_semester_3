package class_problems;

import java.util.List;

public class Problem1 {

    // Time Complexity: O(log n) - binary search halves the search space each iteration
    // Space Complexity: O(1) additional space (iterative approach, no extra data structures)
    static String findBook(List<String[]> catalog, String targetIsbn) {
        int low = 0;
        int high = catalog.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            String midIsbn = catalog.get(mid)[0];

            int comparison = midIsbn.compareTo(targetIsbn);

            if (comparison == 0) {
                return catalog.get(mid)[1]; // found - return title
            } else if (comparison < 0) {
                low = mid + 1; // target is in the right half
            } else {
                high = mid - 1; // target is in the left half
            }
        }

        return "Not Found";
    }

    public static void main(String[] args) {
        List<String[]> catalog = List.of(
                new String[]{"0001112223", "Introduction to Algebra"},
                new String[]{"0002223334", "Beginning Python"},
                new String[]{"0003334445", "Classic Mythology"},
                new String[]{"0004445556", "Data and Society"},
                new String[]{"0005556667", "European History"}
        );

        System.out.println(findBook(catalog, "0003334445")); // Classic Mythology
        System.out.println(findBook(catalog, "0009998887")); // Not Found
    }
}