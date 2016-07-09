/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threading;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PraS an
 */
public class ThreadMethodsDemo {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(runnable);
            thread.setName("MY THREAD" + i);
            thread.setPriority(i + 1);
            thread.setDaemon(true);
            threads[i] = thread;
        }
        for (Thread t : threads) {
            t.start();
            t.join();
        }
        final Operand operand=new Operand();
        //join

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(0);
                    operand.setA(10);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ThreadMethodsDemo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(0);
                    operand.setB(20);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ThreadMethodsDemo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        System.out.printf("Name=%s,Status=%s\n",t1.getName(),t1.getState().name());
        t1.start();
        System.out.printf("Name=%s,Status=%s\n",t1.getName(),t1.getState().name());
        System.out.println("T2 is Alive?"+t2.isAlive());
        
        //thread Static method
        System.out.println(Thread.currentThread().getName());
        Thread.dumpStack();
        Thread.yield();
        System.out.println(Thread.holdsLock(t2));
        
        
        t2.start();
        t1.join();
        System.out.printf("Name=%s,Status=%s\n",t1.getName(),t1.getState().name());
        t2.join();
        System.out.println("sum=  "+(operand.getA()+operand.getB()));

    }

}

class Operand {

    int a;
    int b;

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }
    
    
}
