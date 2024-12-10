import java.util.Random;
public class AVL{
    class TreeNode{
        int val;
        int height;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            this.val = x;
            this.height = 1;
            this.left = null;
            this.right = null;
        }
    }

    private TreeNode root;

    private Integer height(TreeNode x){
        if(x == null) return 0;
        return 1 + Math.max(height(x.left), height(x.right));
    }

    private Integer getHeight(TreeNode x){
        if(x == null) return 0;
        return x.height;
    }

    private TreeNode leftRotate(TreeNode x){
        TreeNode root = x.right;
        TreeNode temp = x.left;

        root.left = x;
        x.right = temp;

        x.height = 1 + Math.max(getHeight(x.left), getHeight(x.right));
        root.height = 1 + Math.max(getHeight(root.left), getHeight(root.right));

        return root;
    }

    private TreeNode rightRotate(TreeNode x){
        TreeNode root = x.left;
        TreeNode temp = x.right;

        root.right = x;
        x.left = temp;

        x.height = 1 + Math.max(getHeight(x.left), getHeight(x.right));
        root.height = 1 + Math.max(getHeight(root.left), getHeight(root.right));

        return root;
    }

    private TreeNode insertNode(TreeNode x, int v){
        // insertion
        if(x == null) return new TreeNode(v);
        if(x.val > v){
            x.left = insertNode(x.left, v);
        }
        else if(x.val < v){
            x.right = insertNode(x.right, v);
        }
        // balancing
        int rotationDirection = getHeight(x.left) - getHeight(x.right);
        if(rotationDirection > 1){
            if(getHeight(x.left.left) - getHeight(x.left.right) == -1){
                x.left = leftRotate(x.left);
            }
            x = rightRotate(x);
        }
        else if(rotationDirection < -1){
            if(getHeight(x.right.left) - getHeight(x.right.right) == -1){
                x.right = leftRotate(x.right);
            }
            x = leftRotate(x);
        }
        x.height = 1 + Math.max(getHeight(x.left), getHeight(x.right));
        return x;
    }

    public void insert(int x){
        root = insertNode(root, x);
    }

    public Integer height(){
        if(root == null) return 0;
        return root.height;
    }

    public static void main(String[] args){
        AVL avl = new AVL();
        Random r = new Random();
        for(int i = 0; i < 10; i++){
            int v = r.nextInt(10) + 1;
            System.out.println("Inserting " + v + " in AVL Tree");
            avl.insert(v);
        }
        System.out.println(avl.height());
    }
}