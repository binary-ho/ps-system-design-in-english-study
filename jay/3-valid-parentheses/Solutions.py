class Solution:
    """
    [solution]
    Valid Parentheses - Check if brackets are balanced

    Approach: Stack
    - Use a stack to track opening brackets
    - For each closing bracket, check if it matches the top of stack
    - Stack should be empty at the end

    Time Complexity: O(n) where n is the length of string
    Space Complexity: O(n) for the stack

    Example:
    s = "()[]{}"
    - '(' -> push
    - ')' -> pop and match
    - '[' -> push
    - ']' -> pop and match
    - '{' -> push
    - '}' -> pop and match
    - Stack empty -> Valid
    """

    def isValid(self, s: str) -> bool:
        stack = []
        mapping = {')': '(', '}': '{', ']': '['}

        for char in s:
            if char in mapping:
                top_element = stack.pop() if stack else '#'
                if mapping[char] != top_element:
                    return False
            else:
                stack.append(char)

        return not stack
