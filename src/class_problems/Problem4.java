package class_problems;

import java.util.HashSet;
import java.util.Set;

public class Problem4 {

    // Approach 1: Brute Force (nested loops)
    // Time Complexity: O(n^2)
    // Space Complexity: O(1) additional space
    static boolean hasPairWithSumBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    // Approach 2: Optimal using HashSet to check complements
    // Time Complexity: O(n) average case
    // Space Complexity: O(n) for the HashSet
    static boolean hasPairWithSum(int[] nums, int target) {
        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            int complement = target - num;
            if (seen.contains(complement)) {
                return true;
            }
            seen.add(num);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 7, 11, 15};
        System.out.println("Brute force: " + hasPairWithSumBruteForce(nums1, 9)); // true
        System.out.println("Optimal: " + hasPairWithSum(nums1, 9));               // true

        int[] nums2 = {3, 4, 6};
        System.out.println("Brute force: " + hasPairWithSumBruteForce(nums2, 20)); // false
        System.out.println("Optimal: " + hasPairWithSum(nums2, 20));               // false
    }
}