package com.example.demo1;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class Demo1Service {

    @Bulkhead(name = "mybulkhead1", type = Bulkhead.Type.THREADPOOL)
    @TimeLimiter(name = "mybulkhead1")
    public CompletableFuture<String> myMethod() throws InterruptedException {
        Thread.sleep(5000);
        return CompletableFuture.completedFuture("success!");
    }

    @Bulkhead(name = "mybulkhead2")
    @TimeLimiter(name = "mybulkhead2")
    public CompletableFuture<String> myMethod2() throws InterruptedException {
        Thread.sleep(5000);
        return CompletableFuture.completedFuture("success!");
    }
}
