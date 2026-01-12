from typing import List

class Solution:
    """
    [solution]
    Minimum Path Sum

    Approach: Dynamic Programming
    1. Create a dp table where dp[i][j] represents the minimum path sum
       to reach cell (i, j) from (0, 0)
    2. Base case: dp[0][0] = grid[0][0]
    3. First row: can only come from left
    4. First column: can only come from top
    5. Other cells: min(from top, from left) + current cell value

    Time Complexity: O(m * n) where m, n are dimensions of grid
    Space Complexity: O(m * n) for dp table
                      (Can be optimized to O(n) by modifying grid in-place)

    Key insight:
    - We can only move right or down
    - Each cell's minimum path sum depends on minimum of:
      - Path sum from cell above
      - Path sum from cell to the left

    Example:
    grid = [
      [1,3,1],
      [1,5,1],
      [4,2,1]
    ]

    dp table construction:
    [1, 4, 5]
    [2, 7, 6]
    [6, 8, 7]

    Minimum path: 1 ’ 1 ’ 1 (down) ’ 2 ’ 1 (right) = 7
    But actually: 1 ’ 3 ’ 1 ’ 1 ’ 1 = 7 (right, right, down, down)
    Or: 1 ’ 1 ’ 4 ’ 2 ’ 1 = 9 (down, down, right, right)
    Wait, let me recalculate:
    1 ’ 3 ’ 1 (top row going right)
    Then 1 ’ 1 (going down from [0,2])
    Total: 1 + 3 + 1 + 1 + 1 = 7
    """

    def minPathSum(self, grid: List[List[int]]) -> int:
        if not grid or not grid[0]:
            return 0

        m, n = len(grid), len(grid[0])
        dp = [[0] * n for _ in range(m)]

        # Base case
        dp[0][0] = grid[0][0]

        # Fill first row (can only come from left)
        for j in range(1, n):
            dp[0][j] = dp[0][j - 1] + grid[0][j]

        # Fill first column (can only come from top)
        for i in range(1, m):
            dp[i][0] = dp[i - 1][0] + grid[i][0]

        # Fill remaining cells
        for i in range(1, m):
            for j in range(1, n):
                dp[i][j] = min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j]

        return dp[m - 1][n - 1]


    # Space-optimized version (modifies input)
    def minPathSumOptimized(self, grid: List[List[int]]) -> int:
        if not grid or not grid[0]:
            return 0

        m, n = len(grid), len(grid[0])

        # Fill first row
        for j in range(1, n):
            grid[0][j] += grid[0][j - 1]

        # Fill first column
        for i in range(1, m):
            grid[i][0] += grid[i - 1][0]

        # Fill remaining cells
        for i in range(1, m):
            for j in range(1, n):
                grid[i][j] += min(grid[i - 1][j], grid[i][j - 1])

        return grid[m - 1][n - 1]
