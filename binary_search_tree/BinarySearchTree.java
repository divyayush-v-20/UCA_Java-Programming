// CEIL, FLOOR, SIZE, RANK

public class BinarySearchTree{

    class TreeNode{
        int key;
        int val;
        int size;
        TreeNode left;
        TreeNode right;
        TreeNode(int key, int val){
            this.key = key;
            this.val = val;
            this.size = 1;
            this.left = null;
            this.right = null;
        }
    }

    private TreeNode root;

    private Integer getSize(TreeNode root){
        if(root == null){
            return 0;
        }
        return root.size;
    }

    private Integer search(TreeNode root, int key){
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

    private TreeNode insert(TreeNode root, int key, int val){
        if(root == null){
            return new TreeNode(key, val);
        }
        if(root.key == key){
            root.val = val;
        }
        else if(root.key > key){
            root.left = insert(root.left, key, val);
        }
        else{
            root.right = insert(root.right, key, val);
        }
        root.size = 1 + getSize(root.left) + getSize(root.right);
        return root;
    }

    public Integer getCeil(int key){
        Integer res = null;
        TreeNode cur = root;
        while(cur != null){
            if(cur.key == key) {
                return key;
            }
            else if(cur.key > key){
                res = cur.key;
                cur = cur.left;
            }
            else{
                cur = cur.right;
            }
        }
        return res;
    }

    public Integer getFloor(int key){
        Integer res = null;
        TreeNode cur = root;
        while(cur != null){
            if(cur.key == key) {
                return key;
            }
            else if(cur.key > key){
                cur = cur.left;
            }
            else{
                res = cur.key;
                cur = cur.right;
            }
        }
        return res;
    }

    public Integer getSize(){
        return getSize(root);
    }

    public void put(int key, int val){
        root = insert(root, key, val);
    }

    public Integer get(int key){
        return search(root, key);
    }

    public static void main(String[] args){
        BinarySearchTree bst = new BinarySearchTree();
        
        bst.put(7, 1);
        bst.put(4, 2);
        bst.put(10, 3);
        bst.put(2, 4);
        bst.put(3, 5);
        bst.put(9, 6);
        bst.put(13, 7);
        bst.put(8, 8);

        System.out.println("No. of nodes = " + bst.getSize());
        System.out.println("Ceil of 5: " + bst.getCeil(5) + ", Floor of 5: " + bst.getFloor(5));

    }
}