package ht.lesson_2;

public interface MySuperList<T> {
    void add(T t);
    T remove(int index);
    T get(int index);
    int size();

}
