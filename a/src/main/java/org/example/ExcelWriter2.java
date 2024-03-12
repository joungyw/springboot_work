package org.example;

import java.io.FileWriter;
import java.io.IOException;

public class ExcelWriter2 {
    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("numbers.txt");
            printNumbersRepeatedly(writer, 1, 15, 50);
            writer.close();
            System.out.println("Numbers have been written to numbers.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printNumbersRepeatedly(FileWriter writer, int start, int end, int repetitions) throws IOException {
        for (int j = 0; j < repetitions; j++) {
            for (int i = start; i <= end; i++) {
                writer.write(String.valueOf(i));
                writer.write("\n");
            }
        }
    }
}