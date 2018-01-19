package com.tyler.practice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThreadSafety {

    private static Logger logger = LoggerFactory.getLogger(ThreadSafety.class);

    public static void main(String[] args) throws InterruptedException {

        ProcessingThread pt = new ProcessingThread();
        Thread t1 = new Thread(pt, "t1");
        t1.start();
        Thread t2 = new Thread(pt, "t2");
        t2.start();
        //wait for threads to finish processing
        t1.join();
        t2.join();
        logger.info("Processing count: {}", pt.getCount());
    }

}

