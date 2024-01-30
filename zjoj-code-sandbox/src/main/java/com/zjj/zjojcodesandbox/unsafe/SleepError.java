package com.zjj.zjojcodesandbox.unsafe;

/**
 * @Classname SleepError
 * @Description Sleep Forever, Block thread to execute
 * @Author zjj
 * @Date 1/29/24 9:54 PM
 */
public class SleepError {
    public static void main(String[] args) throws InterruptedException {
        long ONE_HOUR = 60 * 60 * 1000L;
        Thread.sleep(ONE_HOUR);
        System.out.println("sleep over");
    }
}
