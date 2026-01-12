from typing import List

class Solution:
    """
    [solution]
    Insert Interval - Insert and merge intervals

    Approach: Three-step process
    1. Add all intervals that end before new interval starts
    2. Merge all overlapping intervals with new interval
    3. Add all intervals that start after new interval ends

    Time Complexity: O(n) where n is the number of intervals
    Space Complexity: O(n) for the result list

    Example:
    intervals = [[1,3],[6,9]], newInterval = [2,5]
    - [1,3] overlaps with [2,5] -> merge to [1,5]
    - [6,9] doesn't overlap -> add as is
    - Result: [[1,5],[6,9]]
    """

    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        result = []
        i = 0
        n = len(intervals)

        # Add all intervals that end before newInterval starts
        while i < n and intervals[i][1] < newInterval[0]:
            result.append(intervals[i])
            i += 1

        # Merge all overlapping intervals with newInterval
        while i < n and intervals[i][0] <= newInterval[1]:
            newInterval[0] = min(newInterval[0], intervals[i][0])
            newInterval[1] = max(newInterval[1], intervals[i][1])
            i += 1
        result.append(newInterval)

        # Add all remaining intervals
        while i < n:
            result.append(intervals[i])
            i += 1

        return result
