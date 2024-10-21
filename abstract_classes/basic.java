abstract class A{
    public void greet(){
        System.out.print("Welcome to abstract class A");
    }
}
public class basic extends A{
    // public void greet(){
    //     System.out.print("Override : Welcome to basic class");
    //     //abstract methods can be overriden
    // }
    public static void main(String[] args){
        basic obj = new basic();
        System.out.print("Welcome to class basic extends A\n");
        obj.greet();
    }
}