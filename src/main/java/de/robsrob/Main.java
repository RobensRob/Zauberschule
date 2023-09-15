package de.robsrob;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    private static int findShortestPath(char[][][] labyrinth, int n, int m) {
        int[][][] visited = new int[2][n][m];
        Queue<Point> queue = new LinkedList<>();

        for (int i = 0; i < 2; i++) {
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < m; k++) {
                    visited[i][j][k] = -1;
                }
            }
        }
        int startX = -1;
        int startY = -1;
        int startZ = -1;
        int endX = -1;
        int endY = -1;
        int endZ = -1;

        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < m; k++) {
                    if(labyrinth[i][j][k] == 'A') {
                        startX = k;
                        startY = j;
                        startZ = i;
                    } else if(labyrinth[i][j][k] == 'B') {
                        endX = k;
                        endY = j;
                        endZ = i;
                    }
                }
            }
        }

        queue.add(new Point(startX, startY, startZ, 0));
        visited[startZ][startY][startX] = 0;

        int[] dx = {-1, 1, 0, 0, 0, 0};
        int[] dy = {0, 0, -1, 1, 0, 0};
        int[] dz = {0, 0, 0, 0, -1, 1};

        while(!queue.isEmpty()) {
            Point current = queue.poll();
            if(current.x == endX && current.y == endY && current.z == endZ) {
                return current.distance;
            }
            for(int i = 0; i < 6; i++) {
                int newX = current.x + dx[i];
                int newY = current.y + dy[i];
                int newZ = current.z + dz[i];

                if(newX >= 0 && newX < m && newY >= 0 && newY < n && newZ >= 0 && newZ < 2 && visited[newZ][newY][newX] != -1 && labyrinth[newZ][newY][newX] != '#') {
                    queue.add(new Point(newX, newY, newZ, current.distance + 1));
                    visited[newZ][newY][newX] = current.distance + 1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) throws Exception{
        File file = new File("D:/Coding/Programs/Zauberschule/src/main/java/de/robsrob/aufgaben/zauberschule0.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));


        String[] yx = br.readLine().split(" ");
        int y = Integer.parseInt(yx[0]); //n
        int x = Integer.parseInt(yx[1]); //m
        char[][][] lab = new char[2][y][x];

        fill3dMatrix(br, lab, y, x);
        print3dMatrix(lab, 0);

        int shortestPath = findShortestPath(lab, y, x);
        if(shortestPath == -1) {
            System.out.println("Kein Weg gefunden!");
        } else {
            System.out.println("Der schnellste Weg von A nach B dauert " + shortestPath + " Sekunden.");
        }
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