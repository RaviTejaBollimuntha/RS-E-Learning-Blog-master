package com.rsel;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;
import java.util.concurrent.Future;

/**
 * Test asynchronous calls
 * Created by Administrator on 03/06/2013.
 */
@ RunWith (SpringRunner.class)
@ SpringBootTest
@ EnableAsync
public class AsyncTest {

    @ Autowired
    private Task task;

    @Test
    public void Test () throws Exception {

        long start = System.currentTimeMillis();
        Future < String> task1 = task.doTaskOne();
        Future < String> task2 = task.doTaskTwo();
        Future < String> task3 = task.doTaskThree();
        while(true) {

            if(task1.isDone () && task2.isDone () && task3.isDone()) {
                // Three tasks are called complete, exit the loop waiting
                break;
            }
            Thread.sleep(1000);
        }
        long end = System.currentTimeMillis();
        System.out.println ("task completed, total time-consuming:" + (end-start) + " MS");
    }



}

@ Component
class Task{

    private static Random random =new Random();

    @ Async
     Future < String> doTaskOne () throws Exception {
        System.out.println ("start a task");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println ("complete task one, time consuming:" + (end - start) + " MS");
        return new AsyncResult<>("Task A OK");
    }

    @ Async
    Future < String> doTaskTwo () throws Exception {
        System.out.println ("get started on mission two");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println ("finish task two, time consuming:" + (end-start) + " MS");
        return new AsyncResult<>("Task 2 OK");
    }

    @ Async
    Future < String> doTaskThree () throws Exception {
        System.out.println ("start task three");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println ("finish task three, time consuming:" + (end-start) + " MS");
        return new AsyncResult<>("task 3 OK");
    }
}