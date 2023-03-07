import java.io.*;
import java.util.*;

public class 스타일리시 {
    static int N, M;
    static String[] good, other;
    static BufferedReader br;
    static BufferedWriter bw;

    static int[][] good_br_cnt, other_br_cnt; //괄호 수
    static int[] good_dot_cnt, other_dot_cnt; //들여쓰기 수
    static int[] tempIndent;

    static boolean first;

    public static void main(String[] args) throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str;
        while(true){
            str = new StringTokenizer(br.readLine());
            N = Integer.valueOf(str.nextToken());
            M = Integer.valueOf(str.nextToken());

            if(N == 0 && M == 0) break;

            inputData();
            initialize();

            getBrCount(good, good_br_cnt);
            getDotCount(good, good_dot_cnt);
            getBrCount(other, other_br_cnt);
            getDotCount(other, other_dot_cnt);
            getIndent(0);

            for (int i = 0; i < M; i++) {
                bw.write(other_dot_cnt[i] + " ");
            }
            bw.newLine();

        }
        bw.flush();
        bw.close();
    }

    private static void getDotCount(String[] stringArray, int[] good_dot_cnt) {
        for(int j = 0; j < stringArray.length; j++){
            for(int i = 0; i < stringArray[j].length(); i++){
                if(stringArray[j].charAt(i) == '.') good_dot_cnt[j]++;
                else break;
            }
        }
    }

    private static void getBrCount(String[] stringArray, int[][] br_cnt){
        for (int i = 0; i < stringArray.length; i++) {
            if(i > 0) {
                for (int j = 0; j < 6; j++) {
                    br_cnt[i][j] += br_cnt[i - 1][j];
                }
            }

            br_cnt[i][0] += count(stringArray[i], '(');
            br_cnt[i][1] += count(stringArray[i], ')');
            br_cnt[i][2] += count(stringArray[i], '{');
            br_cnt[i][3] += count(stringArray[i], '}');
            br_cnt[i][4] += count(stringArray[i], '[');
            br_cnt[i][5] += count(stringArray[i], ']');
        }
    }

    public static int count(String line, char c) {
        int ans = 0;
        for (int i = 0; i < line.length(); i++) {
            if(line.charAt(i)==c) ans++;
        }
        return ans;
    }

    private static void initialize() {
        first = false;

        good_br_cnt = new int[N][6];
        other_br_cnt = new int[M][6];

        good_dot_cnt = new int[N];
        other_dot_cnt = new int[M];

        tempIndent = new int[3];
    }

    //R C S 구하기
    public static void getIndent(int depth){
        if(depth == 3) {
            boolean right = true;
            for (int i = 0; i < N - 1; i++) {
                int num = tempIndent[0] * (good_br_cnt[i][0] - good_br_cnt[i][1]) +
                        tempIndent[1] * (good_br_cnt[i][2] - good_br_cnt[i][3]) +
                        tempIndent[2] * (good_br_cnt[i][4] - good_br_cnt[i][5]);

                if (num != good_dot_cnt[i + 1])
                    right = false;
            }

            if(right) checkOther();

            return;
        }

        for (int i = 1; i <= 20; i++) {
            tempIndent[depth] = i;
            getIndent(depth + 1);
        }
    }

    private static void checkOther() {
        for(int i = 0; i < M - 1; i++){
            int temp = 0;
            for(int j = 0; j < 3; j++){
                temp += tempIndent[j] * (other_br_cnt[i][j * 2 - 0] - other_br_cnt[i][j * 2 + 1]);
            }

            if(!first) {
                other_dot_cnt[i + 1] = temp;
                continue;
            }

            //유일하게 결정할 수 없을 때 -1의 값을 넣어줌
            if(other_dot_cnt[i + 1] != temp) other_dot_cnt[i + 1] = -1;
        }
        first = true;
    }

    public static void inputData() throws IOException {
        //입력 받는 부분
        good = new String[N];
        other = new String[M];

        for(int i = 0; i < N; i++){
            good[i] = br.readLine();
        }

        for(int i = 0; i < M; i++){
            other[i] = br.readLine();
        }
    }
}
