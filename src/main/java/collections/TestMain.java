package collections;

public class TestMain {
    public static void main(String[] args) {
        testLinkedList();
    }

    private static void testLinkedList() {
        MyList<Integer> myList = new MyListImpl<>();


        myList.insertFirst(1);
        myList.insertFirst(2);
        myList.insertFirst(3);
        myList.insertFirst(4);
        myList.insertFirst(5);
        myList.insertFirst(6);
        myList.insertFirst(7);
        myList.insertFirst(8);

        myList.display();

        System.out.println("Find 2: " + myList.contains(2));
        System.out.println("Find 1: " + myList.contains(1));
        System.out.println("Find 4: " + myList.contains(4));
        System.out.println("Find 4444: " + myList.contains(4444));
        myList.removeFirst();
        myList.remove(4);


        myList.display();

        System.out.println("Работа итератора");

        System.out.println("");

        for (Object value : myList) {
            System.out.println("value: " + value);
        }
    }
}
