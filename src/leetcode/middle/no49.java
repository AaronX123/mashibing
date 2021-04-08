package leetcode.middle;

import java.util.*;

public class no49 {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String key = generateKey(str);
            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            }
        }
        res.addAll(map.values());
        return res;
    }

    public String generateKey(String str) {
        int[] count = new int[26];
        for (char c : str.toCharArray()) {
            int u = c - 'a';
            count[u]++;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i : count) {
            stringBuilder.append("#");
            stringBuilder.append(i);
            stringBuilder.append(i + 'a');
        }
        return stringBuilder.toString();
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        // 首先归类，相同字母的放一起
        Set<String> strings = new HashSet<>();
        for (String str : strs) {
            if (strings.isEmpty() || !contains(strings, str)) {
                strings.add(str);
            }
        }
        // 对每个归好类的字母串，用回溯法生成单词
        for (String string : strings) {
            boolean[] used = new boolean[string.length()];
            List<String> rs = new ArrayList<>();
            generate(string.toCharArray(), 0, used, new ArrayDeque<Character>(), rs);
            res.add(rs);
        }
        return res;
    }

    private void generate(char[] arr, int depth, boolean[] used, Deque<Character> deque, List<String> list) {
        if (depth == arr.length) {
            StringBuilder stringBuilder = new StringBuilder();
            Deque<Character> newDeque = new ArrayDeque<>(deque);
            while (!newDeque.isEmpty()) {
                stringBuilder.append(newDeque.removeLast());
            }
            list.add(stringBuilder.toString());
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            deque.addLast(arr[i]);
            generate(arr, depth + 1, used, deque, list);
            used[i] = false;
            deque.removeLast();
        }
    }

    private boolean contains(Set<String> strings, String str) {
        for (String string : strings) {
            if (equals(string, str)) return true;
        }
        return false;
    }

    private boolean equals(String pattern, String match) {
        char[] patternArr = pattern.toCharArray();
        int[] count = new int[26];
        for (char c : patternArr) {
            int u = c - 'a';
            count[u]++;
        }
        char[] matchArr = match.toCharArray();
        for (char c : matchArr) {
            int u = c - 'a';
            count[u]--;
        }
        for (int i : count) {
            if (i != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        //new no49().groupAnagrams(new String[]{"ddddddddddg","dgggggggggg"});
        System.out.println(new no49().generateKey("abcd"));
        System.out.println(new no49().generateKey("cbdae"));
    }
}
