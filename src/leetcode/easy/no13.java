package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class no13 {
    static Map<Character,Integer> romanTable = new HashMap<>();
    static {
        romanTable.put('I', 1);
        romanTable.put('V', 5);
        romanTable.put('X', 10);
        romanTable.put('L', 50);
        romanTable.put('C', 100);
        romanTable.put('D', 500);
        romanTable.put('M', 1000);
    }
    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int res = 0;
        for (int i = 0; i < chars.length; i++) {
            if (i == chars.length - 1 || ((i + 1) < chars.length && romanTable.get(chars[i]) >= romanTable.get(chars[i + 1]))) {
                res += romanTable.get(chars[i]);
            }
            else {
                res += (romanTable.get(chars[i + 1]) - romanTable.get(chars[i]));
                i++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new no13().romanToInt("MCMXCIV"));
    }
}
