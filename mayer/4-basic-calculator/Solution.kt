import java.util.*

class Solution {
    /**
     * [solution]
     * Basic Calculator (with +, -, and parentheses)
     *
     * Approach: Stack-based Evaluation
     * 1. Use a stack to handle parentheses
     * 2. Track current result and sign
     * 3. When encountering '(', push current result and sign to stack
     * 4. When encountering ')', pop from stack and compute result
     * 5. Process numbers digit by digit
     *
     * Time Complexity: O(n) where n is the length of string
     * Space Complexity: O(n) for the stack
     *
     * Example:
     * s = "(1+(4+5+2)-3)+(6+8)"
     * Step by step evaluation using stack
     * Result: 23
     */

    fun calculate(s: String): Int {
        val stack = Stack<Int>()
        var result = 0
        var number = 0
        var sign = 1

        for (i in s.indices) {
            val char = s[i]

            when {
                char.isDigit() -> {
                    number = number * 10 + (char - '0')
                }
                char == '+' -> {
                    result += sign * number
                    number = 0
                    sign = 1
                }
                char == '-' -> {
                    result += sign * number
                    number = 0
                    sign = -1
                }
                char == '(' -> {
                    stack.push(result)
                    stack.push(sign)
                    result = 0
                    sign = 1
                }
                char == ')' -> {
                    result += sign * number
                    number = 0
                    result *= stack.pop()  // pop sign
                    result += stack.pop()  // pop previous result
                }
            }
        }

        result += sign * number
        return result
    }
}
