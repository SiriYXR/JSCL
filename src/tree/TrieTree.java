package tree;

import java.util.HashMap;

public class TrieTree {
    public static void main(String[] args) {

        Trie trie=new Trie();
        trie.insert("hello");
        trie.insert("hello");
        System.out.println(trie.search("hello"));
        trie.delete("hello");
        System.out.println(trie.search("hello"));
        System.out.println(trie.search("world"));
        trie.insert("world");
        System.out.println(trie.search("world"));


    }

    public static class TrieNode {
        public int pass;
        public int end;

        public HashMap<Integer, TrieNode> nexts;

        public TrieNode() {
            pass = 0;
            end = 0;
            nexts = new HashMap<Integer, TrieNode>();
        }
    }

    public static class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            if (word == null)
                return;
            char[] chs = word.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if (!node.nexts.containsKey(index)) {
                    node.nexts.put(index, new TrieNode());//添加结点
                }
                node = node.nexts.get(index);
                node.pass++;
            }
            node.end++;
        }

        public void delete(String word) {
            if (search(word) != 0) {
                char[] chs = word.toCharArray();
                TrieNode node = root;
                int index = 0;
                for (int i = 0; i < chs.length; i++) {
                    index = chs[i] - 'a';
                    if (--node.nexts.get(index).pass == 0) {
                        node.nexts.remove(index);//删除结点
                        return;
                    }
                    node = node.nexts.get(index);
                }
                node.end--;
            }
        }

        public int search(String word) {
            if (word == null)
                return 0;
            char[] chs = word.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if (!node.nexts.containsKey(index)) {
                    return 0;
                }
                node = node.nexts.get(index);
            }
            return node.end;
        }

        public int preixNumber(String pre) {
            if (pre == null) {
                return 0;
            }
            char[] chs = pre.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if (!node.nexts.containsKey(index)) {
                    return 0;
                }
                node = node.nexts.get(index);
            }
            return node.pass;
        }
    }
}
