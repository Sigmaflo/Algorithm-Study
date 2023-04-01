import java.io.*;
import java.util.*;

class Main {

    static int K,N;
    static int[] arr ;
    public static int stoi(String str){
        return Integer.parseInt(str);
    }
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = stoi(st.nextToken()); // 수열 길이
        K = stoi(st.nextToken()); // 연속 날짜

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++)arr[i] = stoi(st.nextToken());
        //<-- 값 입력받기

        // 첫번째 합 구하기
        int maxSum = 0 ;
        for(int i=0;i<K;i++) maxSum += arr[i];

        int mIdx, addIdx, sum=maxSum ;
        for(int i=0;i<N-K;i++){ 
            mIdx = (i)%N;
            addIdx = (i+K)%N ;
            sum -= arr[mIdx] ; // 이전값 빼기
            sum += arr[addIdx];
            maxSum = Math.max(sum, maxSum);
            // System.out.println(mIdx+" , " + addIdx + " : " + sum);
        }
        System.out.print(maxSum);



    }

}
