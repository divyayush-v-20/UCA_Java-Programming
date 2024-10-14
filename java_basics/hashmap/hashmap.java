import java.util.HashMap;
import java.util.Map;
public class hashmap{
    public static void main(String[] args){
        HashMap<Integer, Integer> mp = new HashMap<>();
        int[] array = {3, 3, 1, 2, 1, 3, 2, 4, 1, 2, 4};
        int n = array.length;

        for(int i = 0; i < n; i++){
            mp.put(array[i], mp.getOrDefault(array[i], 0) + 1);
        }

        for(Map.Entry<Integer, Integer> it : mp.entrySet()){
            System.out.println(it.getKey() + " : " + it.getValue());
        }
        // or we can use var keyword
        for(var it : mp.entrySet()){
            System.out.println(it.getKey() + " : " + it.getValue());
        }

        // removing a key
        mp.remove(3);

        //incrementing
        mp.put(2, mp.getOrDefault(2, 0) + 1);
        //decrementing
        mp.put(3, mp.getOrDefault(3, 0) - 1);
    }
}