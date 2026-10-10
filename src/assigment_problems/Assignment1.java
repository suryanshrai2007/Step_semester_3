package assigment_problems;

public class Assignment1 {

    // Time Complexity: O(m * n) - visits every mark once (m students, n subjects)
    // Space Complexity: O(1) additional space
    static Object[] findTopper(int[][] marks) {
        int bestRow = 0;
        int bestTotal = -1;

        for (int row = 0; row < marks.length; row++) {
            int total = 0;
            for (int col = 0; col < marks[row].length; col++) {
                total += marks[row][col];
            }
            if (total > bestTotal) {
                bestTotal = total;
                bestRow = row;
            }
        }

        return new Object[]{bestRow, bestTotal};
    }

    public static void main(String[] args) {
        int[][] marks = {
                {78, 85, 90},
                {88, 92, 79},
                {65, 70, 95}
        };

        Object[] result = findTopper(marks);
        System.out.println("(" + result[0] + ", " + result[1] + ")"); // (1, 259)
    }
}