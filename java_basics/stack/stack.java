import java.util.*;

public class stack{
    public static void main(String[] args){
        Stack<Integer> s = new Stack<>();

        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 5; ++i){
            int x = sc.nextInt();
            s.push(x);
        }

        while(!s.empty()){
            System.out.print(s.pop() + " ");
        }
    }
}