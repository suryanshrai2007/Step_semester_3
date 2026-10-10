package class_problems;

public class Problem2 {

    // Time Complexity: O(m * n) - must visit every cell in the grid once
    // Space Complexity: O(1) additional space (only tracking running totals/coordinates)
    static Object[] warehouseSummary(int[][] grid) {
        int totalItems = 0;
        int maxValue = -1;
        int maxRow = -1;
        int maxCol = -1;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                int value = grid[row][col];
                totalItems += value;

                if (value > maxValue) {
                    maxValue = value;
                    maxRow = row;
                    maxCol = col;
                }
            }
        }

        return new Object[]{totalItems, new int[]{maxRow, maxCol}};
    }

    public static void main(String[] args) {
        int[][] grid = {
                {4, 9, 2},
                {7, 1, 6},
                {3, 12, 5}
        };

        Object[] result = warehouseSummary(grid);
        int total = (int) result[0];
        int[] coordinate = (int[]) result[1];

        System.out.println("(" + total + ", (" + coordinate[0] + ", " + coordinate[1] + "))");
        // Expected: (49, (2, 1))
    }
}