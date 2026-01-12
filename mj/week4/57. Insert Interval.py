from typing import List

class Solution:
    """
    [solution]
    Insert Interval - Insert and merge intervals

    Approach: Three-step linear scan
    1. Add all intervals that end before newInterval starts
    2. Merge all overlapping intervals with newInterval
    3. Add all intervals that start after newInterval ends

    Time Complexity: O(n) where n is the number of intervals
    Space Complexity: O(n) for the result list

    Key insight:
    - Intervals are already sorted by start time
    - We can process them in one pass
    - Merge by updating newInterval's bounds

    Example:
    intervals = [[1,3],[6,9]], newInterval = [2,5]
    Step 1: No intervals end before 2
    Step 2: [1,3] overlaps with [2,5] -> merge to [1,5]
    Step 3: [6,9] doesn't overlap -> add as is
    Result: [[1,5],[6,9]]

    Example 2:
    intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
    Step 1: [1,2] ends before 4 -> add [1,2]
    Step 2: [3,5],[6,7],[8,10] overlap with [4,8] -> merge to [3,10]
    Step 3: [12,16] doesn't overlap -> add [12,16]
    Result: [[1,2],[3,10],[12,16]]
    """

    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        result = []
        i = 0
        n = len(intervals)

        # Step 1: Add all intervals that end before newInterval starts
        while i < n and intervals[i][1] < newInterval[0]:
            result.append(intervals[i])
            i += 1

        # Step 2: Merge all overlapping intervals with newInterval
        while i < n and intervals[i][0] <= newInterval[1]:
            newInterval[0] = min(newInterval[0], intervals[i][0])
            newInterval[1] = max(newInterval[1], intervals[i][1])
            i += 1
        result.append(newInterval)

        # Step 3: Add all remaining intervals
        while i < n:
            result.append(intervals[i])
            i += 1

        return result
