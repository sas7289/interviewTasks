package lesson_2;

public class AppList {
    public static void main(String[] args) {
        MySuperList<Integer> myList = new MyLinkedList<>();
        System.out.println("size " + myList.size());
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        myList.add(5);
        System.out.println("size " + myList.size());
        System.out.println(myList);
        myList.remove(4);
        System.out.println(myList);
        myList.remove(3);
        System.out.println(myList);
        myList.remove(2);
        System.out.println(myList);
        myList.remove(1);
        System.out.println(myList);
        myList.remove(0);
        System.out.println(myList);

    }
}
