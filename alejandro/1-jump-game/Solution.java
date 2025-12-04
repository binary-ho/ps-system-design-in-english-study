import java.util.*;

class Solution {
    /**
     [solution]
     1. try all from first index
     - N element + all (N - index)
     - with memoization DFS in Big O Notiation: N - 1, N - 2 ... 1 -> in Gauss summation formula : (N-1)*(N-2)/2 = O(N^2)
     -
     2. start from last index
     - same

     [solution 1 code]
     ## dfs function
     1. check the current number: currentNumber
     2. calculate maximum jump length by the minnimum of currentNumber and (array size - current index - 1)
     3. declare jump length that from 1 to maximum jump length
     4. call next dfs function with jump
     5. if reach last index -> exit funtion and return true.

     0 1 2 3 4
     - size: 5
     - current: 1
     - can move: 3
     - so, size - current index - 1
     */

    private final Set<Integer> visited = new HashSet<>();

    public boolean canJump(int[] nums) {
        return canJump(0, nums);
    }

    private boolean canJump(int currentIndex, int[] nums) {
        int lastIndex = nums.length - 1;
        if (currentIndex == lastIndex) {
            return true;
        }

        int currentNumber = nums[currentIndex];
        int maximumJumpLength = Math.min(currentNumber, lastIndex - currentIndex);
        for (int jumpLength = 1; jumpLength <= maximumJumpLength; jumpLength++) {
            int nextIndex = currentIndex + jumpLength;
            if (canJump(nextIndex, nums)) {
                return true;
            }
        }
        return false;
    }
}