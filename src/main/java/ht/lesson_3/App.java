package ht.lesson_3;

public class App {
    public static void main(String[] args) {
        SayWord sayWord = new SayWord();
        Thread threadPing = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                sayWord.sayPing();
            }
        });
        Thread threadPong = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                sayWord.sayPong();
            }
        });
        threadPing.start();
        threadPong.start();



        Counter counter = new Counter();
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.incrementCounter();
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.incrementCounter();
            }
        });
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(counter.getCounter());
    }
}
