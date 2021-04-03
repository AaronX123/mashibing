package leetcode.middle;

public class no208 {
    static final int N = 100010;
    int[][] son = new int[N][26];
    int[] count = new int[N];
    int idx = 0;
    /** Initialize your data structure here. */
    public no208() {

    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        int p = 0;
        char[] arr = word.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            int u = arr[i] - 'a';
            if (son[p][u] == 0) son[p][u] = ++idx;
            p = son[p][u];
        }
        count[p]++;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        int p = 0;
        char[] arr = word.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            int u = arr[i] - 'a';
            if (son[p][u] == 0) return false;
            p = son[p][u];
        }
        return count[p] > 0;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        int p = 0;
        char[] arr = prefix.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            int u = arr[i] - 'a';
            if (son[p][u] == 0) return false;
            p = son[p][u];
        }
        return true;
    }

    public static void main(String[] args) {
        no208 no = new no208();
        no.insert("apple");
        System.out.println(no.search("apple"));
        System.out.println(no.startsWith("app"));
    }
}
