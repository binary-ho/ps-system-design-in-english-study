class Solution {
    /**
     * [solution]
     * Edit Distance (Levenshtein Distance)
     *
     * Approach: Dynamic Programming
     * 1. Create a 2D dp table where dp[i][j] represents
     *    the minimum edit distance between word1[0..i-1] and word2[0..j-1]
     * 2. Base cases:
     *    - dp[0][j] = j (insert j characters)
     *    - dp[i][0] = i (delete i characters)
     * 3. Transition:
     *    - If word1[i-1] == word2[j-1]: dp[i][j] = dp[i-1][j-1]
     *    - Else: dp[i][j] = 1 + min(insert, delete, replace)
     *
     * Time Complexity: O(m * n) where m, n are lengths of words
     * Space Complexity: O(m * n) for dp table
     *
     * Example:
     * word1 = "horse", word2 = "ros"
     * horse -> rorse (replace 'h' with 'r')
     * rorse -> rose (remove 'r')
     * rose -> ros (remove 'e')
     * Result: 3 operations
     */

    fun minDistance(word1: String, word2: String): Int {
        val m = word1.length
        val n = word2.length

        val dp = Array(m + 1) { IntArray(n + 1) }

        // Initialize base cases
        for (i in 0..m) {
            dp[i][0] = i
        }
        for (j in 0..n) {
            dp[0][j] = j
        }

        // Fill dp table
        for (i in 1..m) {
            for (j in 1..n) {
                if (word1[i - 1] == word2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1]
                } else {
                    dp[i][j] = 1 + minOf(
                        dp[i - 1][j],     // delete
                        dp[i][j - 1],     // insert
                        dp[i - 1][j - 1]  // replace
                    )
                }
            }
        }

        return dp[m][n]
    }
}
