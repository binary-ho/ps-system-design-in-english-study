class Solution:
    """
    [solution]
    Word Pattern - Check if pattern matches string

    Approach: Two Hash Maps
    - Use one map for pattern -> word mapping
    - Use one map for word -> pattern mapping
    - Ensure bijection (one-to-one mapping)

    Time Complexity: O(n) where n is the number of words
    Space Complexity: O(n) for the hash maps

    Example:
    pattern = "abba", s = "dog cat cat dog"
    a -> dog, b -> cat
    dog -> a, cat -> b
    Valid pattern
    """

    def wordPattern(self, pattern: str, s: str) -> bool:
        words = s.split()

        if len(pattern) != len(words):
            return False

        pattern_to_word = {}
        word_to_pattern = {}

        for p, w in zip(pattern, words):
            if p in pattern_to_word:
                if pattern_to_word[p] != w:
                    return False
            else:
                pattern_to_word[p] = w

            if w in word_to_pattern:
                if word_to_pattern[w] != p:
                    return False
            else:
                word_to_pattern[w] = p

        return True
