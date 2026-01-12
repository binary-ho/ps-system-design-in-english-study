import java.util.*;

class Solution {
    /**
     [solution]
     Use a stack to track opening brackets
     1. Iterate through each character in the string
     2. If it's an opening bracket ('(', '{', '['), push to stack
     3. If it's a closing bracket:
        - Check if stack is empty (invalid)
        - Pop from stack and verify it matches the closing bracket
     4. After iteration, stack should be empty for valid parentheses

     Time Complexity: O(n) where n is the length of the string
     Space Complexity: O(n) for the stack in worst case
     */

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();
                if (c == ')' && top != '(') {
                    return false;
                }
                if (c == '}' && top != '{') {
                    return false;
                }
                if (c == ']' && top != '[') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
