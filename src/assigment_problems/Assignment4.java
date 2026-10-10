package assigment_problems;

public class Assignment4 {

    // Naive approach (recalculate sum of every block from scratch):
    // Time Complexity: O(n * k)

    // Optimal sliding-window approach:
    // Time Complexity: O(n) - each element added/removed from window once
    // Space Complexity: O(1) additional space
    static int countAlerts(int[] readings, int k, int threshold) {
        int n = readings.length;
        int alertCount = 0;
        int windowSum = 0;
        int thresholdSum = k * threshold; // avoid decimal division

        // build the first window
        for (int i = 0; i < k; i++) {
            windowSum += readings[i];
        }
        if (windowSum >= thresholdSum) {
            alertCount++;
        }

        // slide the window
        for (int i = k; i < n; i++) {
            windowSum += readings[i];
            windowSum -= readings[i - k];
            if (windowSum >= thresholdSum) {
                alertCount++;
            }
        }

        return alertCount;
    }

    public static void main(String[] args) {
        int[] readings = {2, 2, 2, 2, 5, 5, 5, 8};
        System.out.println(countAlerts(readings, 3, 4)); // 3
    }
}