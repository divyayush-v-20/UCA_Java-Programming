public class SymbolTable{
    class TreeNode{
        int val;
        int key;
        TreeNode left;
        TreeNode right;

        TreeNode(int k, int v){
            this.key = k;
            this.val = v;
            this.left = null;
            this.right = null;
        }
    }
    private TreeNode root;
    private TreeNode insert(TreeNode root, int key, int val){
        if(root == null){
            return new TreeNode(key, val);
        }
        if(root.key == key){
            root.val = val;
            return root;
        }
        if(root.key > key){
            root.left = insert(root.left, key, val);
        }
        if(root.key < key){
            root.right = insert(root.right, key, val);
        }
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
    private TreeNode leftMax(TreeNode root){
        TreeNode cur = root;
        while(cur.right != null){
            cur = cur.right;
        }
        return cur;
    }
    private TreeNode delete(TreeNode root, int key){
        if(root == null){
            return null;
        }
        if(root.key == key){
            //leaf node
            if(root.left == null && root.right == null){
                return null;
            }
            else if(root.left == null && root.right != null){
                return root.right;
            }
            else if(root.left != null && root.right == null){
                return root.left;
            }
            else if(root.left != null && root.right != null){
                TreeNode replace = leftMax(root.left);
                root.key = replace.key;
                root.val = replace.val;
                root.left = delete(root.left, replace.key);
                return root;
            }
        }
        else if(root.key > key){
            root.left = delete(root.left, key);
        }
        else{
            root.right = delete(root.right, key);
        }
        return root;
    }
    public Integer get(int key){
        Integer res = extract(root, key);
        if(res != null) return res;
        return -1;
    }
    public void put(int key, int val){
        root = insert(root, key, val);
    }
    public void erase(int key){
        root = delete(root, key);
    }
    public static void main(String[] args){
        SymbolTable obj = new SymbolTable();
        obj.put(0, 3);
        obj.put(1, 2);
        obj.put(2, 7);
        obj.put(3, 6);
        obj.put(1, 11);
        for(int i = 0; i <= 3; ++i){
            System.out.println(i + " " + obj.get(i));
        }

        obj.erase(2);
        obj.erase(0);

        for(int i = 0; i <= 3; ++i){
            System.out.println(i + " " + obj.get(i));
        }

    }
}