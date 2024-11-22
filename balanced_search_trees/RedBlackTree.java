import java.util.*;
public class RedBlackTree{
    boolean RED = true;
    boolean BLACK = false;
    class TreeNode{
        int key;
        TreeNode left;
        TreeNode right;
        boolean color;
        TreeNode(int key){
            this.key = key;
            this.left = null;
            this.right = null;
            this.color = RED;
        }
    }
    private TreeNode root;
    private boolean isRed(TreeNode root){
        return (root != null && root.color == RED);
    }
    private TreeNode leftRotate(TreeNode root){
        TreeNode cur = root.right;
        root.right = cur.left;
        cur.left = root;
        cur.color = root.color;
        root.color = RED;
        return cur;
    }
    private TreeNode rightRotate(TreeNode root){
        TreeNode cur = root.left;
        root.left = cur.right;
        cur.right = root;
        cur.color = root.color;
        root.color = RED;
        return cur;
    }
    private TreeNode insert(TreeNode root, int key){
        if(root == null){
            return new TreeNode(key);
        }
        if(root.key > key){
            root.left = insert(root.left, key);
        }
        else if(root.key < key){
            root.right = insert(root.right, key);
        }

        if(isRed(root.right) && !isRed(root.left)){
            root = leftRotate(root);
        }
        if(isRed(root.left) && isRed(root.left.left)){
            root = rightRotate(root);
        }
        if(isRed(root.left) && isRed(root.right)){
            root.color = RED;
            root.left.color = BLACK;
            root.right.color = BLACK;
        }
        return root;
    }
    public void put(int key){
        root = insert(root, key);
        root.color = BLACK;
    }
    public void printLevelWise(){
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
                String color;
                if(cur.color == RED) color = "R";
                else color = "B";
                System.out.print(cur.key + "(" + color + ")  ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        // 10 20 30 15 25 5 12 35 40 32 50
        RedBlackTree rbt = new RedBlackTree();
        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < 11; i++){
            int x = sc.nextInt();
            rbt.put(x);
        }

        sc.close();

        rbt.printLevelWise();
    }
}
