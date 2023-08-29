package com.thejava.section6;

public class ThreadApp {
    public static void main(String[] args) {
        String name = Thread.currentThread().getName();

        MyThread myThread = new MyThread();
        myThread.start();

        System.out.println("Hello: " + name);

        Thread thread = new Thread(() -> {
            System.out.println("Thread: " + Thread.currentThread().getName());
        });

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();

    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Thread: " + Thread.currentThread().getName());
        }
    }
}
