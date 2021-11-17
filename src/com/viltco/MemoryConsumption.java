package com.viltco;

public class MemoryConsumption {

    public MemoryConsumption() {
        consumeMemory();
    }

    public void consumeMemory() {
        Runtime runtime = Runtime.getRuntime();
        long memoryUsed = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("memoryUsed: " + memoryUsed);
        if (memoryUsed > 10.0)
            System.gc();
    }
}
