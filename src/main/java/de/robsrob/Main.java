package de.robsrob;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    private static int findShortestPath(char[][][] labyrinth) {
        return 0;
    }
    public static void main(String[] args) throws Exception{
        File file = new File("/home/robin/Schreibtisch/Schule/Informatik/BWINF/Zauberschule/Aufgaben/zauberschule0.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        char[][][] lab;

        String[] yx = br.readLine().split(" ");
        int y = Integer.parseInt(yx[0]);
        int x = Integer.parseInt(yx[1]);

        lab = new char[2][y][x];

        fill3dMatrix(br, lab, y, x);
        print3dMatrix(lab, 1);
        System.out.println(lab[0][0][0]);
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
                } else {
                    j--;
                }
            }
        }
    }

    static void print3dMatrix(char matrix[][][], int floor) {
        for(int i = 0; i < matrix[floor].length; i++) {
            for(int j = 0; j < matrix[floor][i].length; j++) {
                System.out.print(matrix[floor][i][j] + "\t");
            }
            System.out.println();
        }
    }
}