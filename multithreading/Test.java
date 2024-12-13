class Thread1 extends Thread{
    @Override
    public void run(){
        for(int i = 0; i < 5; i++){
            System.out.println("inside Thread1 " + i);
        }
    }
}

class Thread2 implements Runnable{
    @Override
    public void run(){
        for(int i = 0; i < 5; i++){
            System.out.println(Thread.currentThread() + ", " + i);
        }
    }
}

public class Test{
    public static void main(String[] args){

        System.out.println("main() is starting execution");

        Thread t1 = new Thread1();
        // t1.start();

        //daemon thread - finishes execution when user thread finishes
        // t1.setDaemon(true);
        // t1.start();

        Thread t2 = new Thread(() -> {
            for(int i = 0; i < 5; i++){
                System.out.println(Thread.currentThread() + ", " + i);
            }
        }, "thread2");
        // t2.setDaemon(true);
        t2.start();

        // new Thread().run(); 

        System.out.println("main() is finishing execution");
    }
}