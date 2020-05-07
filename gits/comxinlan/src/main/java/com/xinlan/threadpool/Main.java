package com.xinlan.threadpool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args){
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(3, 3,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());


        for(int i = 0 ; i < 10;i++){
            threadPool.execute(()->{
                System.out.println("thread begin ...");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread end..");
            });
        }

        threadPool.execute(()->{
            System.out.println("thread begin ...");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread end..");
        });

        threadPool.shutdown();
    }
}
