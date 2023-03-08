import java.io.*;
import java.util.*;

public class Main{

	static int N;
	static String[] phoneNums; 

	public static int stoi(String str){
		return Integer.parseInt(str);
	}

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		int TC = stoi(br.readLine()); // TestCase 개수
		StringBuilder sb = new StringBuilder();
		for(int TestCase=0; TestCase<TC; TestCase++){
			N = stoi(br.readLine()); //N개의 전화번호
			phoneNums = new String[N];
			for(int i=0;i<N;i++) phoneNums[i] = br.readLine() ; // 전화번호 입력받기

			Arrays.sort(phoneNums);
			boolean check = false ;
			for(int i=1;i<N;i++){ // 전화번호 목록
				if(CheckNums(i)){
					check = true ;
					break; 
				}
			}

			if(check) System.out.println("NO"); // 접두어 전화번호가 나온 경우
			else System.out.println("YES");
			
		}
    }

	public static boolean CheckNums(int idx){
		if (phoneNums[idx].startsWith(phoneNums[idx-1])) return true ;
		return false ;
	}
}
