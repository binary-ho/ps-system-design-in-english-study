import java.util.*;

class Solution {
    /**
     [solution]
     Insert a new interval into a list of non-overlapping intervals
     1. Add all intervals that end before the new interval starts
     2. Merge all overlapping intervals with the new interval
     3. Add all intervals that start after the new interval ends

     Time Complexity: O(n) where n is the number of intervals
     Space Complexity: O(n) for the result list

     Example:
     intervals = [[1,3],[6,9]], newInterval = [2,5]
     - [1,3] overlaps with [2,5] -> merge to [1,5]
     - [6,9] doesn't overlap -> add as is
     - Result: [[1,5],[6,9]]
     */

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        // Add all intervals that end before newInterval starts
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // Merge all overlapping intervals with newInterval
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);

        // Add all remaining intervals
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }
}
