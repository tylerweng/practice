package com.tyler.practice;

class ProcessingThread implements Runnable {

    private Object mutex = new Object();

    private int count;

    public void run() {
        for(int i=1; i < 5; i++){
            processSomething(i);
            synchronized (mutex) {
                ++count;
            }
        }
    }

    public int getCount() {
        return this.count;
    }

    private void processSomething(int i) {
        // processing some job
        try {
            Thread.sleep(i*100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
