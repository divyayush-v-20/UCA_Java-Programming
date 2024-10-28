import java.util.*;

class Student{
    int rollNo;
    int marks;
    String name;

    Student(int r, String n){
        this.rollNo = r;
        this.name = n;
    }
}

public class treemap{
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        TreeMap<Integer, String> mp = new TreeMap<>(Collections.reverseOrder());
        // implemented using BST

        int n = sc.nextInt();

        for(int i = 0; i < n; i++){
            int rollNo = sc.nextInt();
            String name = sc.next();

            Student cur = new Student(rollNo, name);
            mp.put(cur.rollNo, cur.name);

            System.out.println(mp);
        }
    }
}