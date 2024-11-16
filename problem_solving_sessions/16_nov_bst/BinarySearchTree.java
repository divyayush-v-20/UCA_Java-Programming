// implement the following methods in a BST
// getMin(), getMax(), deleteNode(key), deleteMin(), deleteMax()

import java.util.*;
public class BinarySearchTree{
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            this.val = x;
            this.left = null;
            this.right = null;
        }
    }
    private TreeNode root;
    private Integer getMin(TreeNode root){
        if(root == null) return null;
        TreeNode tmp = root;
        while(tmp.left != null){
            tmp = tmp.left;
        }
        return tmp.val;
    }
    private Integer getMax(TreeNode root){
        if(root == null) return null;
        TreeNode tmp = root;
        while(tmp.right != null){
            tmp = tmp.right;
        }
        return tmp.val;
    }
    private TreeNode insert(TreeNode root, int key){
        if(root == null){
            return new TreeNode(key);
        }
        if(root.val > key){
            root.left = insert(root.left, key);
        }
        else if(root.val < key){
            root.right = insert(root.right, key);
        }
        return root;
    }
    private void printLevelWise(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int s = q.size();
            while(s-- != 0){
                TreeNode cur = q.poll();
                if(cur.left != null){
                    q.offer(cur.left);
                }
                if(cur.right != null){
                    q.offer(cur.right);
                }
                System.out.print(cur.val + " ");
            }
            System.out.println();
        }
    }
    private TreeNode deleteNode(TreeNode root, int key){
        if(root == null){
            return root;
        }
        if(root.val == key){
            //leaf
            if(root.left == null && root.right == null){
                return null;
            }
            //only left child
            else if(root.left != null && root.right == null){
                return root.left;
            }
            //only right child
            else if(root.left == null && root.right != null){
                return root.right;
            }
            //both child
            else if(root.left != null && root.right != null){
                int val = getMin(root.right);
                root.val = val;
                root.right = deleteNode(root.right, val);
                return root;
            }
        }
        else if(root.val > key){
            root.left = deleteNode(root.left, key);
        }
        else{
            root.right = deleteNode(root.right, key);
        }
        return root;
    }
    public void put(int key){
        root = insert(root, key);
    }
    public Integer getMin(){
        Integer res = getMin(root);
        return res == null ? -1 : res;
    }
    public Integer getMax(){
        Integer res = getMax(root);
        return res == null ? -1 : res;
    }
    public void printLevelWise(){
        printLevelWise(root);
    }
    public void deleteMin(){
        deleteNode(root, getMin(root));
    }
    public void deleteMax(){
        deleteNode(root, getMax(root));
    }
    public static void main(String[] args){
        BinarySearchTree bst = new BinarySearchTree();

        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 7; i++){
            int x = sc.nextInt();
            bst.put(x);
        }
        System.out.println("max: " + bst.getMax());
        System.out.println("min: " + bst.getMin());

        // 4 7 2 1 6 5 3

        bst.printLevelWise();

        bst.deleteMax();
        bst.deleteMin();

        System.out.println("Tree after deleting current min and max:");
        bst.printLevelWise();
    }
}