import java.util.function.*;
public class classTasks{
    public static void main(String[] args){
        Function<Integer, Integer> square = (i) -> {
            return i*i;
        };
        Function<String, String> sq = (str) -> {
            return str.toUpperCase();
        };
        Function<String, String> trim = (str) -> {
            String res = "";
            int i = 0; 
            while(str.charAt(i) == ' '){
                i++;
            }
            while(str.charAt(i) != ' '){
                res += str.charAt(i++);
            }
            return res;
        };

        Function<Supplier<String>, Consumer<String>> getAndLog = (supplier) -> {
            String randomID = supplier.get();
            Consumer<String> consumer = (randomIDT) -> {
                for(int i = 0; i < 10; i++){
                    Thread.sleep(2000);
                    System.out.println(i + " " + randomIDT);
                }
                return consumer;
            };
        };

        System.out.println(trim.apply("    str   "));

        System.out.println(getAndLog.apply(() -> {
            return String.valueOf("randomID -- " + (Math.random() * 100) + "-- ");
        }));
    }
}