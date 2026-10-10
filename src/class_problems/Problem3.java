package class_problems;

import java.util.HashSet;
import java.util.Set;

public class Problem3 {

    // Approach 1: Brute Force
    // Time Complexity: O(n^2) - checks every possible pair
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

    // Approach 2: Optimal using HashSet
    // Time Complexity: O(n) - single pass, each lookup/insert is O(1) average
    // Space Complexity: O(n) - HashSet can store up to n elements
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
        System.out.println(hasPairWithSum(nums1, 9)); // true (2 + 7 = 9)

        int[] nums2 = {3, 4, 6};
        System.out.println(hasPairWithSum(nums2, 20)); // false
    }
}