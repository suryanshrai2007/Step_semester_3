package programming_fundamentals.assigment_problems;

public class TrafficStreakAnalyzer {

    static void findLongestStreak(String signalLog) {
        int longestStreakLength = 1;
        char longestStreakColor = signalLog.charAt(0);

        int currentStreakLength = 1;
        char currentStreakColor = signalLog.charAt(0);

        for (int i = 1; i < signalLog.length(); i++) {
            if (signalLog.charAt(i) == currentStreakColor) {
                currentStreakLength++;
            } else {
                currentStreakColor = signalLog.charAt(i);
                currentStreakLength = 1;
            }

            if (currentStreakLength > longestStreakLength) {
                longestStreakLength = currentStreakLength;
                longestStreakColor = currentStreakColor;
            }
        }

        System.out.println("Longest Streak: '" + longestStreakColor + "' repeated "
                + longestStreakLength + " times");
    }

    public static void main(String[] args) {
        findLongestStreak("RRGGGYRR");
        findLongestStreak("RRRRYYGG");
    }
}