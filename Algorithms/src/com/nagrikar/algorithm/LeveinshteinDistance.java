package com.nagrikar.algorithm;

public class LeveinshteinDistance {
    public int[][] getDistance(char[] word1, char[] word2) {
        int i, j, n = word1.length, m = word2.length;
        int[][] distance = new int[n + 1][m + 1];

        for (i = 0; i <= n; i++) {
            distance[i][0] = i;
        }

        for (j = 0; j <= m; j++) {
            distance[0][j] = j;
        }

        for (i = 1; i <= n; i++) {
            for (j = 1; j <= m; j++) {
                if (word1[i - 1] == word2[j - 1]) {
                    distance[i][j] = distance[i - 1][j - 1];
                } else {
                    distance[i][j] = min(distance[i - 1][j], distance[i][j - 1], distance[i - 1][j - 1]) + 1;
                }
            }
        }
        return distance;
    }

    public int min(int a, int b, int c) {
        return a < b ? (a < c ? a : c) : (b < c ? b : c);

    }

    public void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args) {
        System.out.println("LeveinshteinDistance");
        LeveinshteinDistance distanceCalculater = new LeveinshteinDistance();
        distanceCalculater.printArray(distanceCalculater.getDistance("car".toCharArray(), "race".toCharArray()));
        System.out.print("\n");
        distanceCalculater.printArray(distanceCalculater.getDistance("wear".toCharArray(), "earn".toCharArray()));
        System.out.print("\n");
        distanceCalculater.printArray(distanceCalculater.getDistance("wear".toCharArray(), "tear".toCharArray()));
    }
}
