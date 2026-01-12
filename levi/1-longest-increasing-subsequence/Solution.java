import java.util.*;

class Solution {
    /**
     [solution]
     Longest Increasing Subsequence (LIS)

     Approach: Dynamic Programming
     1. dp[i] represents the length of LIS ending at index i
     2. For each element, check all previous elements
     3. If nums[j] < nums[i], dp[i] = max(dp[i], dp[j] + 1)
     4. Return the maximum value in dp array

     Time Complexity: O(n^2) where n is the length of array
     Space Complexity: O(n) for dp array

     Example:
     nums = [10,9,2,5,3,7,101,18]
     dp = [1,1,1,2,2,3,4,4]
     LIS = 4 (e.g., [2,3,7,101])
     */

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int maxLength = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }

        return maxLength;
    }
}
