class Solution:
    """
    [solution]
    Word Pattern - Check if pattern matches string

    Approach: Two Hash Maps for Bijection
    - Use one map for pattern -> word mapping
    - Use one map for word -> pattern mapping
    - Ensure one-to-one correspondence (bijection)

    Time Complexity: O(n) where n is the number of words
    Space Complexity: O(n) for the hash maps

    Example:
    pattern = "abba", s = "dog cat cat dog"
    a -> dog, b -> cat
    dog -> a, cat -> b
    Valid pattern (returns True)

    pattern = "abba", s = "dog cat cat fish"
    a -> dog, b -> cat
    But 'a' should map to 'fish' in second occurrence
    Invalid pattern (returns False)
    """

    def wordPattern(self, pattern: str, s: str) -> bool:
        words = s.split()

        # Length must match
        if len(pattern) != len(words):
            return False

        pattern_to_word = {}
        word_to_pattern = {}

        for p, w in zip(pattern, words):
            # Check pattern -> word mapping
            if p in pattern_to_word:
                if pattern_to_word[p] != w:
                    return False
            else:
                pattern_to_word[p] = w

            # Check word -> pattern mapping
            if w in word_to_pattern:
                if word_to_pattern[w] != p:
                    return False
            else:
                word_to_pattern[w] = p

        return True
