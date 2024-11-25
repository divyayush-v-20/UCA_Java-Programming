import java.util.*;
import java.util.stream.*;
public class streamTask{
    public static void main(String[] args){
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Travis", "Mitchell");

        List<String> filtered = names.stream().filter((name) -> 
            name.charAt(0) == 'A'
        ).collect(Collectors.toList());

        // System.out.println(filtered);

        // List<String> uppercase = names.stream().map(
        //     // (name) ->  name.toUpperCase()
        //     String::toUpperCase
        // ).collect(Collectors.toList());

        // List<String> uppercase = names.stream().filter((name) ->
        //     name != null).map(
        //         String::toUpperCase
        // ).collect(Collectors.toList());

        // System.out.println(uppercase);

        //reduce
        String combinedNames = names.stream()
            .filter((name) -> name != null)
            .reduce("", (a, b) -> a + b);

        System.out.println(combinedNames);

        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

        // Integer sum = nums.stream().reduce(0, (a, b) -> a + b);
        Integer sum = nums.stream().reduce(0, Integer::sum);

        System.out.println(sum);
    }
}