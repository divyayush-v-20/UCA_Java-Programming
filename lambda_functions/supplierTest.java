import java.util.function.*;
import java.util.*;
public class supplierTest{
    public static void main(String[] args){
        Supplier<Integer> randomGenerator = () -> {
            return (int)(Math.random() * 100d);
        };

        Function<String, Integer> getStringLength = (str) -> {
            return str.length();
        };

        System.out.println(randomGenerator.get());
        System.out.println(getStringLength.apply("Divyayush"));
    }
}