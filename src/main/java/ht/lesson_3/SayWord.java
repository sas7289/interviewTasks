package ht.lesson_3;

public class SayWord {
    private final Object lock = new Object();
    private final String PING = " Ping ";
    private final String PONG = " Pong ";
    private volatile String currentWord = PING;


    public void sayPing() {
        synchronized (lock) {
            try {
                while (currentWord != PING) {
                    lock.wait();
                }
                System.out.println(PING);
                currentWord = PONG;
                lock.notify();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void sayPong() {
        synchronized (lock) {
            try {
                while (currentWord != PONG) {
                    lock.wait();
                }
                System.out.println(PONG);
                currentWord = PING;
                lock.notify();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
