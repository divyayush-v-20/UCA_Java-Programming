import java.util.*;
class TreeNode{
    TreeNode left;
    TreeNode right;
    int val;

    TreeNode(int x){
        this.val = x;
        this.left = null;
        this.right = null;
    }
}
interface BinarySearchTree{
    TreeNode insert(TreeNode root, int val);
    int minVal(TreeNode root);
    int maxVal(TreeNode root);
    TreeNode delete(TreeNode root, int val);
    // TreeNode search(TreeNode root, int val);
    void inorder(TreeNode root);
    void preorder(TreeNode root);
    void postorder(TreeNode root);
    void levelorder(TreeNode root);
}
class Tree implements BinarySearchTree{
    public TreeNode insert(TreeNode root, int val){
        if(root == null){
            return new TreeNode(val);
        }
        if(val >= root.val){
            root.right = insert(root.right, val);
        }
        else{
            root.left = insert(root.left, val);
        }
        return root;
    }
    public int minVal(TreeNode root){
        while(root.left != null){
            root = root.left;
        }
        return root.val;
    }
    public int maxVal(TreeNode root){
        while(root.right != null){
            root = root.right;
        }
        return root.val;
    }
    public TreeNode delete(TreeNode root, int val){
        if(root.val > val){
            root.left = delete(root.left, val);
        }
        else if(root.val < val){
            root.right = delete(root.right, val);
        }
        else{
            //leaf node
            if(root.left == null && root.right == null){
                return null;
            }
            //single child - left/right
            //left
            if(root.left != null && root.right == null){
                return root.left;
            }
            //right
            if(root.left == null && root.right != null){
                return root.right;
            }
            //both children
            if(root.left != null && root.right != null){
                //either return max value from left subtree or min value from right subtree
                int newval = maxVal(root.left);
                root.val = newval;
                root.left = delete(root.left, newval);
                return root;
            }
        }
        return root;
    }
    public void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }    
    public void preorder(TreeNode root){
        if(root == null) return;
        System.out.print(root.val + " ");
        inorder(root.left);
        inorder(root.right);
    }    
    public void postorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        inorder(root.right);
        System.out.print(root.val + " ");
    }
    public void levelorder(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int s = q.size();
            for(int i = 1; i <= s; i++){
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
}  
public class bst{
    public static void main(String[] args){
        TreeNode root = null;
        Tree first = new Tree();
        
        int[] array = {5, 3, 2, 4, 7, 6, 8};
        for(int i = 0; i < 7; i++){
            root = first.insert(root, array[i]);
        }

        first.inorder(root);
        System.out.println();

        first.levelorder(root);
    }
}