package threads;


//1. Реализовать программу, в которой два потока поочередно пишут ping и pong.
public class MainClass {
    private final Object mon = new Object();
    Boolean check = true;
    String play = "Pong";

    public void printA() {
        synchronized (mon) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (check) {
                        mon.wait();
                    }
                    System.out.print(play + " ");
                    play = "Pong";
                    check = true;
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printB() {
        synchronized (mon) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (!check) {
                        mon.wait();
                    }
                    System.out.print(play + " ");
                    play = "Ping";
                    check = false;
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MainClass obj = new MainClass();
        new Thread(() -> {
            obj.printA();
        }).start();
        new Thread(() -> {
            obj.printB();
        }).start();
    }
}