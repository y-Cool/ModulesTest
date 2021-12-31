package com.example.modulestest;

public class CallTest {
    private static CallTest callTest;
    public static CallTest getInstance(){
        if (callTest == null) {
            callTest = new CallTest();
        }
        return callTest;
    }
}
