package com.viltco;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        RandomStringGenerator randomStringGenerator = new RandomStringGenerator();
        System.out.println("Please Enter value Between 1-230");
        Scanner value = new Scanner(System.in);  // Create a Scanner object
        int inputValue = value.nextInt();
        String randomString;
        long start = System.currentTimeMillis();
        File file = new File("/Users/mac/task.txt");
        file.createNewFile();
        FileWriter writer = new FileWriter(file);
        if (inputValue == 0) {
            System.out.println("Please Enter value greater then 0 !");
        } else if (inputValue > 230 - 1) {
            System.out.println("Please enter value less then 230!");
        } else {
            for (int i = 0; i < inputValue; i++) {
                randomString = randomStringGenerator.initTask();
                writer.write(randomString);
                writer.write("\n");
            }
            writer.flush();
            writer.close();
            long end = System.currentTimeMillis();
            System.out.println((end - start) / 1000f + " seconds");
            new MemoryConsumption();
        }
    }
}
