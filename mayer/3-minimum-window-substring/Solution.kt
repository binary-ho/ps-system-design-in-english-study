class Solution {
    /**
     * [solution]
     * Minimum Window Substring
     *
     * Approach: Sliding Window with Two Pointers
     * 1. Use a hash map to count characters in target string t
     * 2. Use two pointers (left and right) to form a window
     * 3. Expand right to include characters until all chars in t are covered
     * 4. Contract left to minimize window while maintaining coverage
     * 5. Track the minimum window found
     *
     * Time Complexity: O(m + n) where m, n are lengths of s and t
     * Space Complexity: O(k) where k is number of unique chars in t
     *
     * Example:
     * s = "ADOBECODEBANC", t = "ABC"
     * Minimum window is "BANC" (length 4)
     */

    fun minWindow(s: String, t: String): String {
        if (s.isEmpty() || t.isEmpty()) return ""

        val targetMap = mutableMapOf<Char, Int>()
        for (char in t) {
            targetMap[char] = targetMap.getOrDefault(char, 0) + 1
        }

        var required = targetMap.size
        var formed = 0

        val windowCounts = mutableMapOf<Char, Int>()
        var left = 0
        var right = 0

        var minLen = Int.MAX_VALUE
        var minLeft = 0
        var minRight = 0

        while (right < s.length) {
            val char = s[right]
            windowCounts[char] = windowCounts.getOrDefault(char, 0) + 1

            if (targetMap.containsKey(char) &&
                windowCounts[char] == targetMap[char]) {
                formed++
            }

            while (left <= right && formed == required) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1
                    minLeft = left
                    minRight = right
                }

                val leftChar = s[left]
                windowCounts[leftChar] = windowCounts[leftChar]!! - 1

                if (targetMap.containsKey(leftChar) &&
                    windowCounts[leftChar]!! < targetMap[leftChar]!!) {
                    formed--
                }

                left++
            }

            right++
        }

        return if (minLen == Int.MAX_VALUE) ""
               else s.substring(minLeft, minRight + 1)
    }
}
