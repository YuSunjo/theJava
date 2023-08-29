package com.thejava.section6;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class FutureApp {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Callable<String> hello = () -> {
            Thread.sleep(2000L);
            return "Hello";
        };

        Future<String> submit = executorService.submit(hello);

        System.out.println("submit.isDone() = " + submit.isDone());
        submit.get(); // 블로킹 콜

        submit.cancel(false); // true: interrupt, false: interrupt 하지 않음
        System.out.println("submit.isDone() = " + submit.isDone());
        System.out.println("end");

        Callable<String> hello1 = () -> {
            Thread.sleep(3000L);
            return "Hello1";
        };

        Callable<String> hello2 = () -> {
            Thread.sleep(2000L);
            return "Hello2";
        };

        Callable<String> hello3 = () -> {
            Thread.sleep(1000L);
            return "Hello3";
        };

        List<Future<String>> futures = executorService.invokeAll(Arrays.asList(hello1, hello2, hello3));
        for (Future<String> f : futures) {
            System.out.println("f.get() = " + f.get());
        }

        String s = executorService.invokeAny(Arrays.asList(hello1, hello2, hello3));
        System.out.println("s = " + s);


        executorService.shutdown();
    }
}
