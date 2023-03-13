package Baekjoon.seungah;

import java.io.IOException;
import java.util.LinkedList;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 새로운게임 {
    // [17780] 새로운 게임
    static final int WHITE = 0, RED = 1, BLUE = 2;
    static final int[] change = { 1, 0, 3, 2 };
    // →, ←, ↑, ↓
    static final int[] dr = { 0, 0, -1, 1 };
    static final int[] dc = { 1, -1, 0, 0 };

    static int N, K;
    static int[][] map;
    static LinkedList<Integer>[][] state;
    static Horse[] horses;

    static class Horse {
        int r, c, dir;

        Horse(int r, int c, int dir) {
            this.r = r;
            this.c = c;
            this.dir = dir;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.valueOf(st.nextToken());
        K = Integer.valueOf(st.nextToken());

        
    }
}
