import java.util.*;
public class Iterable{
    public static void main(String[] args){
        //an interface in Java
        //has a method named Iterator()
        //allows the use of enhanced for-each loops
        List<Integer> li = new LinkedList<Integer>();
        for(int i = 0; i < 10; i++) li.add(i);

        System.out.println("Initially");
        for(int i : li){
            System.out.print(i + " ");
        }
        //list can't be modified using for-each loop
        //for modifying, we need index-access

        for(int i = 0; i < 10; i++){
            li.set(i, -1);
        }
        
        System.out.println("\nAfter Modification");
        for(int i : li){
            System.out.print(i + " ");
        }
    }
}