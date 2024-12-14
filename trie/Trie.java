public class Trie {
    class Node {
        char data;
        Node[] children;
        boolean isEnd;
        
        Node(char c) {
            this.data = c;
            this.children = new Node[26];
            this.isEnd = false;
        }
    }
    
    Node root;
    
    Trie() {
        this.root = new Node('\0');
    }
    
    void insertHelper(Node root, String word) {
        if (word.length() == 0) {
            root.isEnd = true;
            return;
        }
        
        int idx = word.charAt(0) - 'a';
        Node child;
        
        if (root.children[idx] != null) {
            child = root.children[idx];
        } else {
            child = new Node(word.charAt(0));
            root.children[idx] = child;
        }
        
        insertHelper(child, word.substring(1));
    }
    
    boolean searchHelper(Node root, String word) {
        if (word.length() == 0) {
            return root.isEnd;
        }
        
        int idx = word.charAt(0) - 'a';
        Node child;
        
        if (root.children[idx] != null) {
            child = root.children[idx];
        } else {
            return false;
        }
        
        return searchHelper(child, word.substring(1));
    }
    
    boolean allChildrenNull(Node root) {
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                return false;
            }
        }
        return true;
    }
    
    boolean removeHelper(Node root, String word) {
        if (word.length() == 0) {
            if (root.isEnd) {
                root.isEnd = false;
            }
            return !root.isEnd && allChildrenNull(root);
        }
        
        int idx = word.charAt(0) - 'a';
        Node child = root.children[idx];
        
        if (child == null) {
            return false;
        }
        
        boolean removeChild = removeHelper(child, word.substring(1));
        
        if (removeChild) {
            root.children[idx] = null;
            return !root.isEnd && allChildrenNull(root);
        }
        
        return false;
    }
    
    void insertWord(String word) {
        insertHelper(root, word);
    }
    
    boolean searchWord(String word) {
        return searchHelper(root, word);
    }
    
    void removeWord(String word) {
        removeHelper(root, word);
    }
    
    public static void main(String[] args) {
        Trie t = new Trie();
        t.insertWord("time");
        t.insertWord("timer");
        assert t.searchWord("time") == true;
        assert t.searchWord("timer") == true;
        assert t.searchWord("tim") == false;
        t.removeWord("time");
        assert t.searchWord("time") == false;
    }
}