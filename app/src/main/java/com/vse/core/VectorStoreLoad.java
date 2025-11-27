package com.vse.core;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class VectorStoreLoad {
        public static void main(String[] args) {
            String path = "questions.txt";
            StringBuilder s = new StringBuilder();
            try {
                Files.lines(Paths.get(path)).forEach(line -> s.append(line).append("\n"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(s.toString());
        }
}
