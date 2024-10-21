interface Shape{
    void getArea(int... inp);
    void noOfSides();
    void getName();
}
abstract class Quadrilateral implements Shape{
    public void noOfSides(){
        System.out.println(4);
    }
}
class Square extends Quadrilateral{
    public void getArea(int... inp){
        int a = inp[0];
        System.out.println(a * a);
    }
    public void getName(){
        System.out.println("Square");
    }
}
class Rectangle extends Quadrilateral{
    public void getArea(int... inp){
        int l = inp[0];
        int b = inp[1];
        System.out.println(l * b);
    }
    public void getName(){
        System.out.println("Rectangle");
    }
}
abstract class Triangle implements Shape{
    public void getArea(int... inp){
        int a = inp[0];
        int b = inp[1];
        int c = inp[2];
        double s = (a + b + c) / 2;
        double ar = Math.sqrt(s * (s - a) * (s - b) * (s - c));
        System.out.println(ar);
    }
    public void noOfSides(){
        System.out.println(3);
    }
}  
class Scalene extends Triangle{
    public void getName(){
        System.out.println("Scanele Triangle");
    }
}
class Equilateral extends Triangle{
    public void getArea(int... inp){
        int a = inp[0];
        double ar = (a * a) / 4;
        System.out.println("sqrt(3) * " + ar);
    }
    public void getName(){
        System.out.println("Equilateral Triangle");
    }
}
class Isosceles extends Triangle{
    public void getName(){
        System.out.println("Isosceles Triangle");
    }
}
class Circle implements Shape{
    public void getArea(int... inp){
        int r = inp[0];
        double pi = 22 / 7;
        System.out.println(pi * r * r);
    }
    public void noOfSides(){
        System.out.println("A circle doesn't have sides :/");
    }
    public void getName(){
        System.out.println("Circle");
    }
}
public class task1{
    public static void main(String[] args){
        Shape sq = new Square();
        sq.getArea(4);
        
        Shape rect = new Rectangle();
        rect.getArea(5, 3);

        Shape c = new Circle();
        c.getArea(7);

        Shape eq = new Equilateral();
        eq.getArea(4, 4, 4);
    }
}