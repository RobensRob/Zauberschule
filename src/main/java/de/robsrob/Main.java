package de.robsrob;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) throws Exception{
        File file = new File("D:/Coding/Programs/Zauberschule/src/main/java/de/robsrob/aufgaben/zauberschule0.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        char[][][] lab;

        String[] yx = br.readLine().split(" ");
        int y = Integer.parseInt(yx[0]);
        int x = Integer.parseInt(yx[1]);

        lab = new char[2][y][x];

        fill3dMatrix(br, lab, y, x);
        print3dMatrix(lab, 0);
        System.out.println();
        print3dMatrix(lab, 1);
    }

    static void fill3dMatrix(BufferedReader br, char[][][] matrix, int y, int x) throws Exception {
        for(int i = 0; i <= 1; i++) {
            for(int j = 0; j < y; j++) {
                String line = br.readLine();
                if(!line.equals("")) {
                    char[] currentLine = line.toCharArray();
                    for(int k = 0; k < x; k++) {
                        matrix[i][j][k] = currentLine[k];
                    }
                }
            }
        }
    }

    static void print3dMatrix(char matrix[][][], int floor) {
        for(int i = 0; i < matrix[0].length; i++) {
            for(int j = 0; j < matrix[0][i].length; j++) {
                System.out.print(matrix[0][i][j] + "\t");
            }
            System.out.println();
        }
    }
}