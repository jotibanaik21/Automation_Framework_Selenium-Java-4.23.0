package com.healthcare.automation.listeners;

import java.util.ArrayList;
import java.util.List;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import com.healthcare.automation.main.MainRunner;

public class MethodInterceptor implements IMethodInterceptor {
    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
        List<String> testNames = MainRunner.getMethodsToExecute();
        List<IMethodInstance> result = new ArrayList<>();
        for (IMethodInstance method : methods) {
            if (testNames.contains(method.getMethod().getMethodName())) {
                result.add(method);
            }
        }
        return result;
    }
}