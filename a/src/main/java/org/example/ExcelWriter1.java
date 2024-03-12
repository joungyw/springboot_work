package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ExcelWriter1 {
    public static void main(String[] args) {
        // 주어진 숫자 배열
        int[] numbers = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        // 엑셀 파일 경로
        String filePath = "output.txt";

        // 엑셀에 쓸 내용
        StringBuilder content = new StringBuilder();
        for (int number : numbers) {
            for (int i = 0; i < 15; i++) {
                content.append(number).append("\n");
            }
        }

        // 파일에 데이터 쓰기
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content.toString());
            System.out.println("파일이 생성되었습니다.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}