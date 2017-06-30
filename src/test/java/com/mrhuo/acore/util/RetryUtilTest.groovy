package com.mrhuo.acore.util

import java.util.concurrent.Callable
import java.util.concurrent.ThreadPoolExecutor

class RetryUtilTest extends GroovyTestCase {

    void testExecuteWithRetry() {
        Integer value = RetryUtil.executeWithRetry(new Callable<Integer>() {
            @Override
            Integer call() throws Exception {
                int r = new Random().nextInt(5) + 1
                if (r != 1) {
                    println "r is ${r}"
                    throw new Exception()
                }
                return r
            }
        }, 10, 1000, true)
        assertEquals(value, 1)
    }

    void testExecuteWithRetry1() {

    }

    void testAsyncExecuteWithRetry() {
        ThreadPoolExecutor poolExecutor = RetryUtil.createThreadPoolExecutor()
        Integer value = RetryUtil.asyncExecuteWithRetry(new Callable<Integer>() {
            @Override
            Integer call() throws Exception {
                int r = new Random().nextInt(5) + 1
                println "r is ${r}"
                if (r != 1) {
                    throw new Exception()
                }
                return r
            }
        }, 10, 1000, false, 1, poolExecutor)
        assertEquals(value, 1)
    }
}
