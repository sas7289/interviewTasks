package ht.lesson_2;

public class MyLinkedList<T> implements MySuperList<T> {

    private int size;
    private Node<T> head;
    private Node<T> tail;

    @Override
    public void add(T t) {
        Node<T> temp = tail;
        tail = new Node<>(temp, t, null);
        if (temp == null) {
            head = tail;
        } else {
            temp.setNext(tail);
        }
        size++;
    }

    @Override
    public T remove(int index) {
        int count = 0;
        Node<T> temp = findNodeByIndex(index);
        if (temp == null) return null;

        if (temp.getPrev() != null && temp.getNext() != null) {
            temp.getPrev().setNext(temp.getNext());
            temp.getNext().setPrev(temp.getPrev());
            size--;
            return temp.getValue();
        }

        if(head == tail) {
            head = null;
            tail = null;
            size--;
        }

        if (temp == head) {
            head = temp.getNext();
            head.setPrev(null);
            temp.setNext(null);
            size--;
            return temp.getValue();
        }

        if (temp == tail) {
            tail = tail.getPrev();
            tail.setNext(null);
            temp.setPrev(null);
            size--;
            return temp.getValue();
        }
        return null;
    }

    @Override
    public T get(int index) {
        return findNodeByIndex(index).getValue();
    }

    @Override
    public int size() {
        return size;
    }


    private Node<T> findNodeByIndex(int index) {
        int count = 0;
        if (size == 0) {
            return null;
        }
        Node<T> temp = head;
        while (count != index && count < size) {
            temp = temp.getNext();
            count++;
        }
        if (count >= size) {
            return null;
        } else return temp;
    }


    class Node<T> {
        private Node<T> prev;
        private Node<T> next;

        public Node(Node<T> prev, T value, Node<T> next) {
            this.prev = prev;
            this.next = next;
            this.value = value;
        }

        private T value;

        public Node(T value) {
            this.value = value;
        }

        public Node<T> getPrev() {
            return prev;
        }

        public void setPrev(Node<T> prev) {
            this.prev = prev;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Node<T> temp = head;
        for (int i = 0; i < size; i++) {
            builder.append(temp.getValue()).append(" ");
            temp = temp.getNext();
        }
        return builder.toString();
    }
}
