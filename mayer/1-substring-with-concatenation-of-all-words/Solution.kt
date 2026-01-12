class Solution {
    /**
     * [solution]
     * Substring with Concatenation of All Words
     *
     * Approach: Sliding Window with Hash Map
     * 1. Create a map of word frequencies from words array
     * 2. For each starting position, use sliding window
     * 3. Check if substring matches concatenation of all words
     * 4. Use hash map to track word occurrences
     *
     * Time Complexity: O(n * m * len) where n is string length,
     *                  m is number of words, len is word length
     * Space Complexity: O(m) for hash maps
     *
     * Example:
     * s = "barfoothefoobarman", words = ["foo","bar"]
     * Valid substrings start at indices 0 and 9
     * "barfoo" and "foobar" are concatenations of all words
     */

    fun findSubstring(s: String, words: Array<String>): List<Int> {
        val result = mutableListOf<Int>()
        if (s.isEmpty() || words.isEmpty()) return result

        val wordLen = words[0].length
        val wordCount = words.size
        val totalLen = wordLen * wordCount

        if (s.length < totalLen) return result

        val wordMap = mutableMapOf<String, Int>()
        for (word in words) {
            wordMap[word] = wordMap.getOrDefault(word, 0) + 1
        }

        for (i in 0..s.length - totalLen) {
            val seen = mutableMapOf<String, Int>()
            var j = 0

            while (j < wordCount) {
                val wordStart = i + j * wordLen
                val word = s.substring(wordStart, wordStart + wordLen)

                if (!wordMap.containsKey(word)) break

                seen[word] = seen.getOrDefault(word, 0) + 1

                if (seen[word]!! > wordMap[word]!!) break

                j++
            }

            if (j == wordCount) {
                result.add(i)
            }
        }

        return result
    }
}
