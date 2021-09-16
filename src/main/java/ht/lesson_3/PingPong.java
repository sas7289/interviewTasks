package ht.lesson_3;

public class PingPong {
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
    }
}
