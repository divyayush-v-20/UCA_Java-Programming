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

public class basic{
    public TreeNode buildTree(int[] array){
        TreeNode root = new TreeNode(array[0]);

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        for(int i = 1; i < array.length; i += 2){
            TreeNode cur = q.poll();
            if(array[i] != -1){
                cur.left = new TreeNode(array[i]);
                q.offer(cur.left);
            }
            if(i + 1 < array.length && array[i + 1] != -1){
                cur.right = new TreeNode(array[i + 1]);
                q.offer(cur.right);
            }
        }

        return root;
    }

    public void levelOrder(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int n = q.size();
            for(int i = 1; i <= n; ++i){
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

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();

        int[] array = new int[size];
        for(int i = 0; i < size; ++i){
            array[i] = sc.nextInt();
        }
        sc.close();

        basic b = new basic();

        TreeNode root = b.buildTree(array);

        b.levelOrder(root);
    }
}