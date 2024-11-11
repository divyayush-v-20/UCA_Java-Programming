import java.util.function.Predicate;

interface isOdd {
    public boolean test(Integer a);
}

public class predicateTest implements isOdd {
    public boolean test(Integer a) {
        return (a % 2) == 1;
    }

    public static void main(String[] args) {
        Predicate<Integer> idOddPr = (p1) -> p1 % 2 == 1;

        predicateTest obj = new predicateTest();

        System.out.println(idOddPr.test(10));  
        System.out.println(idOddPr.test(19)); 
        System.out.println(idOddPr.test(20));  

        System.out.println(obj.test(23));  
    }
}
