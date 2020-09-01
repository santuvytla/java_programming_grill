package com.company;

public class prefsuf{
    public static void main(String[] args) {
        String words[]={"apples","apple","apple"};
        prefsufs s=new prefsufs(words);
        int k=s.f("a","e");
        System.out.print(k);
    }
}


class prefsufs {
    /*
    Given many words, words[i] has weight i.

Design a class WordFilter that supports one function, WordFilter.f(String prefix, String suffix).
It will return the word with given prefix and suffix with maximum weight. If no word exists, return -1.

Examples:

Input:
WordFilter(["apple"])
WordFilter.f("a", "e") // returns 0
WordFilter.f("b", "") // returns -1
     */
    Trie root;
    public prefsufs(String[] words) {
        root = new Trie();
        for (int i = 0; i < words.length; i++) {
            create(words[i], i);
        }
    }

    private int getIdx(char c) {
        return c - 'a';
    }

    private void create(String word, int w) {
        Trie cur = root;
        int i;
        for (char c : word.toCharArray()) {
            i = getIdx(c);
            if (cur.children[i] == null) {
                cur.children[i] = new Trie();
            }
            cur = cur.children[i];
        }
        cur.isWord = true;
        cur.weight = w;
        cur.word = word;
    }
    public int f(String prefix,String suffix)
    {
        Trie cur = root;
        for (char c : prefix.toCharArray()) {
            if (cur.children[getIdx(c)] == null) return -1;
            cur = cur.children[getIdx(c)];
        }
        return helper(cur,suffix,-1);
    }

    private int helper(Trie curnode, String suffix, int weight) {
        int ans=weight;
        if (curnode.isWord && curnode.word.endsWith(suffix)) {
            ans = Math.max(ans, curnode.weight);
        }
        for (Trie child : curnode.children) {
            if (child != null) {
                ans = Math.max(helper(child, suffix, ans), ans);
            }
        }
        return ans;

    }


}
class Trie{
    Trie[] children;
    boolean isWord;
    int weight;
    String word;

    Trie() {
        children = new Trie[26];
        isWord = false;
        weight = -1;
        word = "";
    }
}

