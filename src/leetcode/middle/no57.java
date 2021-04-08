package leetcode.middle;

import java.util.Arrays;

public class no57 {
    // 先去判断是否第i个区间不和new区间重叠
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] res = new int[intervals.length + 1][];
        int idx = 0;
        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            res[idx++] = intervals[i++];
        }
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        res[idx++] = newInterval;

        while (i < intervals.length && intervals[i][0] > newInterval[1]) {
            res[idx++] = intervals[i++];
        }
        return Arrays.copyOf(res, idx);
    }
}
