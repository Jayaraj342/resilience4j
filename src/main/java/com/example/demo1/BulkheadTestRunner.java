package com.example.demo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class BulkheadTestRunner {

    @Autowired
    private Demo1Service demo1Service;

    public String runTest() {
        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {
            executor.submit(() -> {
                try {
                    System.out.println(demo1Service.myMethod());
                } catch (Exception e) {
                    System.err.println("Bulkhead rejection or error: " + e);
                }
            });
        }

        executor.shutdown();

        return "Success!";
    }
}
