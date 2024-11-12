import java.util.*;
import java.io.*;

class A implements Comparable<A> {
    int x;

    A(int x) {
        this.x = x;
    }

    public int compareTo(A y) {
        return Integer.compare(this.x, y.x);
    }
}

public class GenericBST<Key extends Comparable<Key>, Value> {
    class TreeNode {
        Key key;
        Value val;
        TreeNode left;
        TreeNode right;

        TreeNode(Key key, Value val) {
            this.key = key;
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    private TreeNode root;
    int nodes;

    private TreeNode insert(TreeNode root, Key key, Value val) {
        if (root == null) {
            return new TreeNode(key, val);
        }
        if (key.compareTo(root.key) == 0) {
            root.val = val;
        } else if (key.compareTo(root.key) < 0) {
            root.left = insert(root.left, key, val);
        } else {
            root.right = insert(root.right, key, val);
        }
        return root;
    }

    private Value extract(TreeNode root, Key key) {
        TreeNode cur = root;
        while (cur != null) {
            if (key.compareTo(cur.key) == 0) {
                return cur.val;
            } else if (key.compareTo(cur.key) < 0) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return null;
    }

    private TreeNode leftMax(TreeNode root) {
        TreeNode cur = root;
        while (cur.right != null) {
            cur = cur.right;
        }
        return cur;
    }

    private TreeNode delete(TreeNode root, Key key) {
        if (root == null) {
            return null;
        }
        if (key.compareTo(root.key) == 0) {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode replace = leftMax(root.left);
                root.key = replace.key;
                root.val = replace.val;
                root.left = delete(root.left, replace.key);
                return root;
            }
        } else if (key.compareTo(root.key) < 0) {
            root.left = delete(root.left, key);
        } else {
            root.right = delete(root.right, key);
        }
        return root;
    }

    private void getInorder(TreeNode root, ArrayList<Key> arr){
        if(root == null) return;
        getInorder(root.left, arr);
        arr.add(root.key);
        getInorder(root.right, arr);
    }

    public Value get(Key key) {
        return extract(root, key);
    }

    public void put(Key key, Value val) {
        root = insert(root, key, val);
    }

    public void erase(Key key) {
        root = delete(root, key);
    }

    public Key getFloor(Key key){
        TreeNode cur = root;
        Key res = null;
        while(cur != null){
            if(key.compareTo(cur.key) == 0){
                return key;
            }
            else if(cur.key.compareTo(key) < 0){
                res = cur.key;
                cur = cur.right;
            }
            else{
                cur = cur.left;
            }
        }
        return res;
    }

    public int size(){
        ArrayList<Key> arr = new ArrayList<>();
        getInorder(root, arr);
        return arr.size();
    }

    public int rank(Key key){
        ArrayList<Key> arr = new ArrayList<>();
        getInorder(root, arr);
        for(int i = 0; i < arr.size(); i++){
            if(arr.get(i) == key){
                return i + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        GenericBST<Integer, String> bst = new GenericBST<>();

        bst.put(10, "Value1");
        bst.put(5, "Value2");
        bst.put(15, "Value3");
        bst.put(3, "Value4");
        bst.put(7, "Value5");
        bst.put(13, "Value6");
        bst.put(17, "Value7");
        bst.put(1, "Value8");
        bst.put(4, "Value9");
        bst.put(6, "Value10");
        bst.put(8, "Value11");
        bst.put(12, "Value12");
        bst.put(14, "Value13");
        bst.put(16, "Value14");
        bst.put(18, "Value15");


        System.out.println(bst.getFloor(11));
        System.out.println(bst.getFloor(2));
        System.out.println(bst.getFloor(9));
        System.out.println(bst.getFloor(15));

        System.out.println("Ranks");

        System.out.println(bst.rank(4));
        System.out.println(bst.rank(13));
        System.out.println(bst.rank(10));

        System.out.println("Size = " + bst.size());
    }
}