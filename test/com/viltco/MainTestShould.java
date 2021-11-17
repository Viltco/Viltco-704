package com.viltco;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MainTestShould {
    File file1, file2;
    RandomStringGenerator randomStringGenerator = new RandomStringGenerator();

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Before
    public void setUp() {
        try {
            file1 = folder.newFile("task.txt");
            file2 = folder.newFile("task2.txt");
        } catch (IOException ioe) {
            System.err.println(
                    "error creating temporary test file in " +
                            this.getClass().getSimpleName());
        }
    }

    @Test
    public void test2TempFiles() {
        try {
            FileWriter fw1 = new FileWriter(file1);
            BufferedWriter bw1 = new BufferedWriter(fw1);
            for (int i = 0; i < 230 - 1; i++) {
                bw1.write(randomStringGenerator.initTask());
            }
            bw1.close();

            FileWriter fw2 = new FileWriter(file2);
            BufferedWriter bw2 = new BufferedWriter(fw2);
            for (int i = 0; i < 230 - 1; i++) {
                bw2.write(randomStringGenerator.initTask());
            }
            bw2.close();
        } catch (IOException ioe) {
            System.err.println(
                    "error creating temporary test file in " +
                            this.getClass().getSimpleName());
        }

        assertTrue(file1.exists());
        assertTrue(file2.isFile());
        assertEquals(file1.length(), file2.length());

        assertTrue(file1.getAbsolutePath().endsWith(
                "task.txt"));

    }
}
