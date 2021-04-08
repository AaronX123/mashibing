package leetcode.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class no39 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();
        comb0(candidates, 0, target, list);
        return res;
    }

    private void comb0(int[] candidates, int start, int target, List<Integer> list) {
        int previousVal = calc(list);
        for (int i = start; i < candidates.length; i++) {
            // 把当前的元素加上，如果此时已经超过了target，由于是有序的就直接break
            if (previousVal + candidates[i] > target) break;
            if (previousVal + candidates[i] == target) {
                list.add(candidates[i]);
                res.add(new ArrayList<>(list));
                // 要回退到进来的参数
                list.remove(list.size() - 1);
                break;
            }
            else {
                list.add(candidates[i]);
                comb0(candidates, i, target, list);
                list.remove(list.size() - 1);
            }
        }
    }

    private int calc(List<Integer> list) {
        int count = 0;
        for (Integer integer : list) {
            count += integer;
        }
        return count;
    }

    public static void main(String[] args) {
        new no39().combinationSum(new int[]{2,3,6,7}, 7);
    }
}
