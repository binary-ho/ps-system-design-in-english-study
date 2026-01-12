class Solution:
    """
    [solution]
    N-Queens II - Count the number of distinct solutions

    Approach: Backtracking with pruning
    1. Use backtracking to try placing queens row by row
    2. For each row, try placing a queen in each column
    3. Check if the placement is valid (no conflicts)
    4. Use sets to track attacked columns, diagonals, and anti-diagonals
    5. Count valid complete solutions

    Time Complexity: O(n!) - trying all possible placements
    Space Complexity: O(n) for recursion stack and sets

    Optimization:
    - Use sets to track columns and diagonals in O(1) time
    - Diagonal: row - col is constant
    - Anti-diagonal: row + col is constant

    Example:
    n = 4
    Two distinct solutions exist
    Returns: 2
    """

    def totalNQueens(self, n: int) -> int:
        def backtrack(row, cols, diagonals, anti_diagonals):
            # Base case: all queens placed
            if row == n:
                return 1

            count = 0
            for col in range(n):
                diagonal = row - col
                anti_diagonal = row + col

                # Check if current position is under attack
                if (col in cols or
                    diagonal in diagonals or
                    anti_diagonal in anti_diagonals):
                    continue

                # Place queen
                cols.add(col)
                diagonals.add(diagonal)
                anti_diagonals.add(anti_diagonal)

                # Recurse to next row
                count += backtrack(row + 1, cols, diagonals, anti_diagonals)

                # Remove queen (backtrack)
                cols.remove(col)
                diagonals.remove(diagonal)
                anti_diagonals.remove(anti_diagonal)

            return count

        return backtrack(0, set(), set(), set())
