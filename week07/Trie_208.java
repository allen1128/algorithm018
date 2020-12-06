public class Trie_208 {

    Node root = new Node();

    public class Node {
        Node[] level = new Node[26];
        boolean isEndWord = false;
    }

    public Trie_208() {
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        char[] chars = word.toCharArray();
        Node curr = root;
        for (int i = 0; i < chars.length; i++) {
            Node next = curr.level[chars[i] - 'a'];
            if (next == null) {
                next = curr.level[chars[i] - 'a'] = new Node();
            }
            curr = next;
        }
        curr.isEndWord = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Node node = getNode(word);
        return node != null && node.isEndWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        return getNode(prefix) != null;
    }

    private Node getNode(String str) {
        char[] chars = str.toCharArray();
        Node node = root;
        for (int i = 0; i < chars.length; i++) {
            node = node.level[chars[i] - 'a'];
            if (node == null) {
                return null;
            }
        }
        return node;
    }

    public static void main(String[] args) {
        Trie_208 trie = new Trie_208();
        trie.insert("child");
        trie.insert("parent");
        System.out.println(trie.search("parent"));
    }
}