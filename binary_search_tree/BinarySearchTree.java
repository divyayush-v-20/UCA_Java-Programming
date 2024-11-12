//implement floor, ceil, size, rank
import java.util.*;

public class BinarySearchTree{
    class TreeNode{
        int key;
        int val;
        TreeNode left;
        TreeNode right;
        int size;
        TreeNode(int key, int val){
            this.key = key;
            this.val = val;
            this.left = null;
            this.right = null;
            this.size = 1;
        }
    }
    class Pair{
        TreeNode ceil;
        TreeNode floor;
        Pair(TreeNode c, TreeNode f){
            this.ceil = c;
            this.floor = f;
        }
    }
    private TreeNode root;

    private int getSize(TreeNode node){
        if(node == null) return 0;
        return node.size;
    }
    private TreeNode insert(TreeNode root, int key, int val){
        if(root == null){
            return new TreeNode(key, val);
        }
        if(root.key > key){
            root.left = insert(root.left, key, val);
        }
        if(root.key < key){
            root.right = insert(root.right, key, val);
        }
        root.size = getSize(root.left) + getSize(root.right) + 1;
        return root;
    }
    private Integer extract(TreeNode root, int key){
        TreeNode cur = root;
        while(cur != null){
            if(cur.key == key){
                return cur.val;
            }
            else if(cur.key > key){
                cur = cur.left;
            }
            else{
                cur = cur.right;
            }
        }
        return null;
    }
    public Integer get(int key){
        Integer res = extract(root, key);
        if(res != null) return res;
        return -1;
    }
    public void put(int key, int val){
        root = insert(root, key, val);
    }
    public int getSize(){
        return getSize(root);
    }
    public Pair getCeilandFloor(int key){
        TreeNode cur = root;
        TreeNode floor = null;
        TreeNode ceil = null;
        while(cur != null){
            if(cur.key == key){
                return new Pair(cur, cur);
            }
            else if(cur.key > key){
                ceil = cur;
                cur = cur.left;
            }
            else{
                floor = cur;
                cur = cur.right;
            }
        }
        return new Pair(ceil, floor);
    }

    public static void main(String[] args){
        BinarySearchTree bst = new BinarySearchTree();
        bst.put(3, 1);
        bst.put(7, 6);
        bst.put(2, 3);
        bst.put(1, 7);

        System.out.println(bst.getSize());

        Pair res = bst.getCeilandFloor(5);
        System.out.println(res.ceil.key + " " + res.floor.key);
    }
}