package de.robsrob;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws Exception{
        File file = new File("D:/Coding/Programs/Zauberschule/src/main/java/de/robsrob/aufgaben/zauberschule0.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        char[][] labyrinth1;
        char[][] labyrinth2;

        String[] yx = br.readLine().split(" ");
        int y = Integer.parseInt(yx[0]);
        int x = Integer.parseInt(yx[1]);

        labyrinth1 = new char[y][x];
        labyrinth2 = new char[y][x];

        fillMatrix(br, labyrinth1, y, x);
        br.readLine();
        fillMatrix(br, labyrinth2, y, x);



    }

    static void fillMatrix(BufferedReader br, char[][] matrix, int y, int x) throws Exception{
        for(int i = 0; i < y; i++) {
            char[] currentLine = br.readLine().toCharArray();
            for(int j = 0; j < x; j++) {
                matrix[i][j] = currentLine[j];
            }
        }
    }

    static void printMatrix(char matrix[][]) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
}