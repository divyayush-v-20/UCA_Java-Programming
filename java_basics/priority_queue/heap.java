import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Collections;
public class heap{
    public static void main(String[] args){
        // PriorityQueue<Integer> pq = new PriorityQueue<>(); //minheap
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); //maxheap
        Scanner sc = new Scanner(System.in);
        for(int i = 1; i <= 5; ++i){
            int x = sc.nextInt();
            pq.add(x);
        }
        while(!pq.isEmpty()){
            System.out.print(pq.peek() + " ");
            pq.poll();
        }
    }
}