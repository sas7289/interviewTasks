package ht.lesson_3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private int counter;
    private final ReentrantLock lock = new ReentrantLock();


    public void incrementCounter() {
        lock.lock();
        counter++;
        lock.unlock();
    }

    public int getCounter() {
        return counter;
    }
}
