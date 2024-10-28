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
class Pair{
    int first;
    TreeNode second;
    Pair(int a, TreeNode b){
        this.first = a;
        this.second = b;
    }
}

public class vertical_order{
    public static List<List<Integer>> vot(TreeNode root){
        HashMap<Integer, List<Integer>> mp = new HashMap<>();
        Queue<Pair> q = new LinkedList<>();

        q.offer({0, root});

        while(!q.isEmpty()){
            var cur = q.poll();
            int axis = cur.first;
            TreeNode node = cur.second;

            mp.get(axis).put(node);

            if(node.left != null){
                q.offer({axis - 1, node.left});
            }
            if(node.right != null){
                q.offer({axis + 1, node.right});
            }
        }

        List<List<Integer>> res;

        
    }
}