package Baekjoon.seungah;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;

public class 안테나 {
    static int N;
    static int[] house;

    public static void main(String args[]) throws IOException {
        // [18310] 안테나
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.valueOf(br.readLine());
        house = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++) {
            house[i] = Integer.valueOf(st.nextToken());
        }
        Arrays.sort(house);

        if (N%2 == 0) {
            System.out.println(house[N/2-1]);
        }
        else {
            System.out.println(house[N/2]);
        }
    }
}