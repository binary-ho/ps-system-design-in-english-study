import java.util.*;

class Solution {
    /**
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
     Two distinct solutions exist:
     Solution 1:
     .Q..
     ...Q
     Q...
     ..Q.

     Solution 2:
     ..Q.
     Q...
     ...Q
     .Q..

     Returns: 2
     */

    private int count = 0;

    public int totalNQueens(int n) {
        Set<Integer> cols = new HashSet<>();
        Set<Integer> diagonals = new HashSet<>();
        Set<Integer> antiDiagonals = new HashSet<>();

        backtrack(0, n, cols, diagonals, antiDiagonals);
        return count;
    }

    private void backtrack(int row, int n, Set<Integer> cols,
                          Set<Integer> diagonals, Set<Integer> antiDiagonals) {
        // Base case: all queens placed successfully
        if (row == n) {
            count++;
            return;
        }

        for (int col = 0; col < n; col++) {
            int diagonal = row - col;
            int antiDiagonal = row + col;

            // Check if current position is under attack
            if (cols.contains(col) ||
                diagonals.contains(diagonal) ||
                antiDiagonals.contains(antiDiagonal)) {
                continue;
            }

            // Place queen
            cols.add(col);
            diagonals.add(diagonal);
            antiDiagonals.add(antiDiagonal);

            // Recurse to next row
            backtrack(row + 1, n, cols, diagonals, antiDiagonals);

            // Remove queen (backtrack)
            cols.remove(col);
            diagonals.remove(diagonal);
            antiDiagonals.remove(antiDiagonal);
        }
    }
}
