package com.example.demo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("api/v1/")
public class Demo1Controller {

    @Autowired
    private Demo1Service demo1Service;

    @Autowired
    private BulkheadTestRunner bulkheadTestRunner;

    @GetMapping("get")
    public String myMethod() throws InterruptedException, ExecutionException {
        return demo1Service.myMethod().get();
    }

    @GetMapping("get2")
    public String myMethod2() throws InterruptedException, ExecutionException {
        return demo1Service.myMethod2().get();
    }

    @GetMapping("test")
    public String runTest() throws InterruptedException {
        return bulkheadTestRunner.runTest();
    }
}
