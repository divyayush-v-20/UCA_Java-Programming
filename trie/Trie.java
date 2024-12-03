public class Trie<Value>{

    private static final int R = 128;
    private Node root;

    private static class Node{
        Object val;
        Node[] next = new Node[R];
    }

    public Value get(String key){
        Node x = get(root, key, 0);
        if(x == null) return null;
        return (Value)x.val;
    }

    private Node get(Node x, String key, int d){
        if(x == null)  return null;
        if(key.length() == d) return x;

        char c = key.charAt(d);
        return get(x.next[c], key, d + 1);
    }

    public void put(String key, Value val){
        root = put(root, key, val, 0);
    }

    private Node put(Node x, String key, Value val, int d){
        if(x == null) x = new Node();
        if(key.length() == d) {
            x.val = val;
            return x;
        }

        char c = key.charAt(d);
        x.next[c] = put(x.next[c], key, val, d + 1);

        return x;
    }

    public static void main(String[] args){
        Trie<Integer> trie = new Trie<Integer>();

        //testcases
        trie.put("hello", 1);
        trie.put("hell", 2);

        assert trie.get("he") == null;
        assert trie.get("hello") == 1;
        assert trie.get("hell") == 3;

        // java -ea Trie -> to run with Assertions
        // ea: Enable Assertions

    }
}