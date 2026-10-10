package class_problems;

public class Problem5 {

    // Brute Force approach (for reference, not used in main):
    // Time Complexity: O(n^2) - checks every pair of walls
    // Space Complexity: O(1) additional space
    static int maxContainerAreaBruteForce(int[] heights) {
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            for (int j = i + 1; j < heights.length; j++) {
                int area = Math.min(heights[i], heights[j]) * (j - i);
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }

    // Optimal approach: Two Pointers
    // Time Complexity: O(n) - single pass, each pointer moves at most n times total
    // Space Complexity: O(1) additional space
    // Preferable for large inputs since it avoids the quadratic blowup of brute force.
    static int maxContainerArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int maxArea = 0;

        while (left < right) {
            int height = Math.min(heights[left], heights[right]);
            int width = right - left;
            int area = height * width;
            maxArea = Math.max(maxArea, area);

            // Move the pointer with the shorter wall inward,
            // since the shorter wall is always the limiting factor
            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxContainerArea(heights)); // 49
    }
}