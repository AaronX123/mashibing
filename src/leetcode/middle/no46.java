package leetcode.middle;

import java.util.*;

public class no46 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        Deque<Integer> deque = new ArrayDeque<>();
        permute0(nums, 0, used, deque);
        return res;
    }

    private void permute0(int[] nums, int depth, boolean[] used, Deque<Integer> path) {
        if (depth == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[nums[i]]) {
                continue;
            }
            used[i] = true;
            path.addLast(nums[i]);
            permute0(nums, depth + 1, used, path);
            used[i] = false;
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        new no46().permute(new int[]{1,2,3});
    }
}
