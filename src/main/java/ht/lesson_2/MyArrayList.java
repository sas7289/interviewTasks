package ht.lesson_2;

public class MyArrayList<T> implements MySuperList<T>{
    private T[] list;
    private int size;
    private int capacity;
    private final int DEFAULT_CAPACITY = 10;

    public MyArrayList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity <=0 " + capacity);
        }
        this.capacity = capacity;
        list = (T[]) new Comparable[capacity];
    }

    public MyArrayList() {
        this.capacity = DEFAULT_CAPACITY;
        list = (T[]) new Comparable[capacity];
    }

    @Override
    public void add(T item) {
        checkAndUpLoadFactory();
        list[size] = item;
        size++;
    }

    public void add(int index, T item) {
        checkAndUpLoadFactory();
        if(!checkRange(index)){
            throw new IllegalArgumentException();
        }

        for (int i = size; i > index; i--) {
            list[i] = list[i - 1];
        }
        list[index] = item;
        size++;
    }

    @Override
    public T remove(int index) {
        if(!checkRange(index)){
            throw new IllegalArgumentException();
        }

        T temp = list[index];
        for (int i = index; i < size; i++) {
            list[i] = list[i + 1];
        }
        size--;
        list[size] = null;
        return temp;
    }


    @Override
    public T get(int index) {
        if(!checkRange(index)){
            throw new IllegalArgumentException();
        }

        return list[index];
    }


    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(list[i]).append(" ");
        }
        return sb.toString();
    }


    public void checkAndUpLoadFactory() {
        if(size + 1 < capacity) {
            return;
        }
        capacity *= 1.5;
        T[] temp = (T[]) new Comparable[(int) (capacity)];
        System.arraycopy(list, 0, temp, 0, size);
        list = temp;
    }


    public boolean checkRange(int index) {
        if(index >= capacity || index < 0){
            return false;
        }
        return true;
    }
}
