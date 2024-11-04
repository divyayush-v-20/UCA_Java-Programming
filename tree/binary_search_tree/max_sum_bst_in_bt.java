class Solution {
    class MaxNode {
        Integer maxValue;
        MaxNode() {
            maxValue = null;
        }
        public void maxVal(int val) {
            if (maxValue == null) {
                maxValue = val;
            } else {
                maxValue = Math.max(maxValue, val);
            }
        }
    }
    public int maxSumBST(TreeNode root) {
        MaxNode maxNode  = new MaxNode();
        findMaxSumBST(root, maxNode);
        return maxNode.maxValue == null || maxNode.maxValue < 0 ? 0 : maxNode.maxValue;
    }
    public Integer[] findMaxSumBST(TreeNode root, MaxNode maxNode) {
        if (root == null) {
            return null;
        }
        Integer left[] = findMaxSumBST(root.left, maxNode);
        Integer right[] = findMaxSumBST(root.right, maxNode);

        if (left == null && root.left != null) {
            return null;
        }
        if (right == null && root.right != null) {
            return null;
        }
        if (left != null && root.val <= left[1]) {
            return null;
        }
        if (right != null && root.val >= right[0]) {
            return null;
        }
        
        Integer min = left == null ? root.val : left[0];
        Integer max = right == null ? root.val : right[1];
        Integer sum = (left == null ? 0 : left[2]) + (right == null ? 0 : right[2]) + root.val;
        maxNode.maxVal(sum);
        return new Integer[] {min, max, sum};
    }
}