import java.util.*;

class Solution {
    /**
     [solution]
     Word Pattern - Check if pattern matches string

     Approach: Two Hash Maps for Bijection
     1. Split the string into words
     2. Check if lengths match
     3. Use one map for pattern -> word mapping
     4. Use one map for word -> pattern mapping
     5. Ensure one-to-one correspondence

     Time Complexity: O(n) where n is the number of words
     Space Complexity: O(n) for the hash maps

     Example:
     pattern = "abba", s = "dog cat cat dog"
     a -> dog, b -> cat
     dog -> a, cat -> b
     Valid pattern
     */

    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");

        if (pattern.length() != words.length) {
            return false;
        }

        Map<Character, String> patternToWord = new HashMap<>();
        Map<String, Character> wordToPattern = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char p = pattern.charAt(i);
            String w = words[i];

            if (patternToWord.containsKey(p)) {
                if (!patternToWord.get(p).equals(w)) {
                    return false;
                }
            } else {
                patternToWord.put(p, w);
            }

            if (wordToPattern.containsKey(w)) {
                if (wordToPattern.get(w) != p) {
                    return false;
                }
            } else {
                wordToPattern.put(w, p);
            }
        }

        return true;
    }
}
