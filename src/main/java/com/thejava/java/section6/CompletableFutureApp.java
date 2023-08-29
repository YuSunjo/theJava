package com.thejava.java.section6;

import java.util.concurrent.*;

public class CompletableFutureApp {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

//        CompletableFuture<String> stringCompletableFuture = new CompletableFuture<>();
//        stringCompletableFuture.complete("theJava");

        CompletableFuture<String> stringCompletableFuture = CompletableFuture.completedFuture("theJava");
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> {
            System.out.println("Thread " + Thread.currentThread().getName());
        });

        CompletableFuture<String> returnCompletableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("Thread " + Thread.currentThread().getName());
            return "Hello";
        }).thenApply((s) -> {
            System.out.println("Thread " + Thread.currentThread().getName());
            return s.toUpperCase();
        });

        returnCompletableFuture.get();

        CompletableFuture<Void> voidCompletableFuture1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Thread " + Thread.currentThread().getName());
            return "Hello";
        }).thenApply((s) -> {
            System.out.println("Thread " + Thread.currentThread().getName());
            return s.toUpperCase();
        }).thenAccept((s) -> {
            System.out.println("Thread " + Thread.currentThread().getName());
            System.out.println(s);
        });

        voidCompletableFuture1.get();

        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
            return "hello";
        });


        CompletableFuture<String> future = hello.thenCompose(CompletableFutureApp::getWorld);
        future.get();

        CompletableFuture<String> future1 = hello.thenCombine(getWorld("world"), (h, w) -> h + " " + w);
        future1.get();

        // 예외처리
        CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
            return "hello";
        }).handle((result, ex) -> {
            if (ex != null) {
                System.out.println(ex);
                return "ERROR!";
            }
            return result;
        }).thenAccept(System.out::println);

        CompletableFuture.supplyAsync(() -> {
            return "hello";
        }).exceptionally(ex -> {
            System.out.println(ex);
            return "ERROR!";
        }).thenAccept(System.out::println);
    }

    private static CompletableFuture<String> getWorld(String message) {
        CompletableFuture<String> world = CompletableFuture.supplyAsync(() -> {
            System.out.println(message + Thread.currentThread().getName());
            return "world";
        });
        return world;
    }

}
