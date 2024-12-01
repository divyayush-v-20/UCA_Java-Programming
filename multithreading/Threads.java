public class Threads{
    static int count = 0;
    public static void main(String[] args){
        // Thread t = new Thread(() -> System.out.println("Thread executed using lambda"));
        // Thread t = new Thread(new MyRunnable());

        Thread t = new Thread(() -> {
            for(int i = 0; i < 1000; ++i){
                ++count;
            }
        });
        t.start();
        System.out.println("before joining, count = " + count);

        try{
            t.join();
        }
        catch(InterruptedException err){
            err.printStackTrace();
        }

        System.out.println("after joining, count = " + count);
    }
}

class MyRunnable implements Runnable{
    public void run(){
        System.out.println("Thread executed using Runnable");
    }
}