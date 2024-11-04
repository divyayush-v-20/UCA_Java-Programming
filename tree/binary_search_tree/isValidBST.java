class Solution {
    public void get(TreeNode root, ArrayList<Integer> in){
        if(root == null){
            return;
        }
        get(root.left, in);
        in.add(root.val);
        get(root.right, in);
    }
    public boolean isValidBST(TreeNode root) {
        ArrayList<Integer> in = new ArrayList<>();
        get(root, in);
        for(int i = 1; i < in.size(); ++i){
            if(in.get(i) <= in.get(i - 1)){
                //either duplicate or unsorted
                return false;
            }
        }
        return true;
    }
}