package leetcode.middle;

import java.util.Arrays;
import java.util.Comparator;

public class no1288 {
    public int removeCoveredIntervals(int[][] intervals) {
        // 先按起始区间排序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int cnt = intervals.length;
        // 记录前一个区间
        int left = intervals[0][0];
        int right = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] >= left && intervals[i][1] <= right) {
                // 前一个区间覆盖了后一个
                cnt--;
            } else if (left == intervals[i][0] && right <= intervals[i][1]) {
                // 后一个区间覆盖了前一个
                cnt--;
                right = intervals[i][1];
            } else {
                // 谁也没有覆盖谁，继续往下走
                left = intervals[i][0];
                right = intervals[i][1];
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        new no1288().removeCoveredIntervals(new int[][]{{66672,75156},{59890,65654},{92950,95965},{9103,31953},{54869,69855},{33272,92693},{52631,65356},{43332,89722},{4218,57729},{20993,92876}});
    }
}
