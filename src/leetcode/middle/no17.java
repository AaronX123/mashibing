package leetcode.middle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class no17 {
    private static Map<Character, String> map = new HashMap<>();
    static {
        map.put('2', "abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
    }
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return new ArrayList<>();
        char[] chars = digits.toCharArray();
        List<String> res = new ArrayList<>();
        List<String> ret = new ArrayList<>();
        res.addAll(generate("", map.get(chars[0]).toCharArray()));

        for (int i = 1; i < chars.length; i++) {
            for (String re : res) {
                ret.addAll(generate(re, map.get(chars[i]).toCharArray()));
            }
            res.clear();
            res.addAll(ret);
            ret.clear();
        }

        return res;
    }

    private List<String> generate(String str, char[] arr) {
        StringBuilder stringBuilder = new StringBuilder(str);
        List<String> res = new ArrayList<>();
        for (char c : arr) {
            res.add(stringBuilder.append(c).toString());
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        return res;
    }
}
