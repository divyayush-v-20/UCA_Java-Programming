import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem{
    class TreeNode{
        String word;
        int freq;
        TreeNode left;
        TreeNode right;
        TreeNode(String word, int freq){
            this.word = word;
            this.freq = freq;
            this.left = null;
            this.right = null;
        }
    }
    TreeNode root;
    private TreeNode insert(TreeNode root, String word){
        if(root == null){
            return new TreeNode(word, 1);
        }
        if(root.word.compareTo(word) == 0){
            root.freq++;
            return root;
        }
        if(root.word.compareTo(word) > 0){
            root.left = insert(root.left, word);
        }
        if(root.word.compareTo(word) < 0){
            root.right = insert(root.right, word);
        }
        return root;
    }
    public void put(String word){
        root = insert(root, word);
    }
    public TreeNode mostFrequent(){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int maxi = Integer.MIN_VALUE;
        String ans = new String();

        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            if(cur.freq >= maxi){
                maxi = cur.freq;
                ans = cur.word;
            }
            if(cur.left != null){
                q.offer(cur.left);
            }
            if(cur.right != null){
                q.offer(cur.right);
            }
        }    
        return new TreeNode(ans, maxi);
    }
    public static void main(String[] args){
        Problem obj = new Problem();
        try (Scanner scanner = new Scanner(new File("file.txt"))) {
            while (scanner.hasNext()) {
                String word = scanner.next(); 
                if(word.length() >= 10){
                    obj.put(word);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        TreeNode res = obj.mostFrequent();
        System.out.println(res.word + " " + res.freq);
    }
}