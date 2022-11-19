package threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//2. Реализовать потокобезопасный счетчик с помощью интерфейса Lock.
public class Counter {

    static int counter = 0;

    public static void main(String[] args) throws InterruptedException {

        Lock lock = new ReentrantLock();

        Thread thr1 = new Thread(()->{
            for(int i = 0; i < 1000000; i++){
                lock.lock();
                counter ++;
                lock.unlock();
            }
        });
        Thread thr2 = new Thread(()->{
            for(int i = 0; i < 1000000; i++){
                lock.lock();
                counter ++;
                lock.unlock();
            }
        });

        thr1.start();
        thr2.start();

        thr1.join();
        thr2.join();

        System.out.println(counter);

    }

}
