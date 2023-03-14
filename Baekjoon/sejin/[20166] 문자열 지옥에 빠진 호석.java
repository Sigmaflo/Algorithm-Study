import java.io.*;
import java.util.*;

public class Main{

	static int N,M,K, maxLength;
	static String[][] arr ;
	static String[] godStr;
	static HashMap<String, Integer> hm = new HashMap<>();
	static boolean[] startStr;

	// 모든 
	public static int stoi(String str){
		return Integer.parseInt(str);
	}

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		K = stoi(st.nextToken());

		arr = new String[N][M];
		godStr = new String[K];
		startStr = new boolean[26];
		
		for(int i=0;i<N;i++){
			String[] nowInput = br.readLine().split("");
			for(int j=0;j<M;j++){
				arr[i][j] = nowInput[j];
			}
		}

		for(int i=0;i<K;i++){
			String godLikeStr = br.readLine();
			godStr[i] = godLikeStr;
			char[] nowStr = godStr[i].toCharArray();
			maxLength = Math.max(godLikeStr.length(), maxLength);

			// hm에 넣어 비교
			hm.put(godLikeStr, 0);
			// 0번째 글자일 때 탐색 시작
			startStr[nowStr[0]-'a'] = true ;
		}
		//<-- 값 입력받기
		DFS();

		StringBuilder sb = new StringBuilder();
		for(String nowStr : godStr){
			sb.append(hm.get(nowStr)+"\n");
		}
		System.out.println(sb.toString());
    }


	public static void DFS(){
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				if(startStr[arr[i][j].charAt(0)-'a']){
					// 신이 좋아하는 문자 중 하나로 시작하므로, 탐색 시작
					LetsMake(i,j,1,arr[i][j]);
				}
				
			}
		}
	}

	static int[] dx={-1,0,1,0,-1,-1,1,1},dy={0,-1,0,1,1,-1,-1,1};

	static int count = 0 ;

	public static void LetsMake(int x, int y, int depth, String ansStr){
		if(hm.containsKey(ansStr)){
			hm.put(ansStr, hm.get(ansStr)+1);
		}
		if(depth >= maxLength) return ;

		for(int i=0;i<8;i++){
			int xx = (x + dx[i]) % N;
			int yy = (y + dy[i]) % M;

			// <-- out of range
			if(xx < 0) xx += N;
			if(yy < 0) yy += M;
			//<--
			LetsMake(xx, yy, depth+1, ansStr + arr[xx][yy] );
			// System.out.println(x+" , " +  y + " " + "end");

		}

	}
}
