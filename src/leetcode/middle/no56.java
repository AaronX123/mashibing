package leetcode.middle;

import java.util.Arrays;
import java.util.Comparator;

public class no56 {
    public int[][] merge(int[][] intervals) {
        // 首先按起始坐标排序，然后遍历，如果intervals[i][0] > intervals[i-1][1]说明第i个区间和第i-1区间是有间隔的
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        int[][] res = new int[intervals.length][];
        int idx = -1;
        for (int i = 0; i < intervals.length; i++) {
            // 如果是第一次进来或者结果数组中的end ＜ start 说明不重叠
            if (idx == -1 || res[idx][1] < intervals[i][0]) {
                res[++idx] = intervals[i];
            } else {
                // 更新结果数组的end
                res[idx][1] = Math.max(res[idx][1], intervals[i][1]);
            }
        }
        return Arrays.copyOf(res, idx + 1);
    }

    public static void main(String[] args) {
        //new no56().merge(new int[][]{{1,3},{2,6},{8,10},{15,18}});
        new no56().merge(new int[][]{{1,4},{5,6}});
    }
}
