import java.io.*;
import java.util.*;

public class Main{

	static int N;
	static ArrayList<Integer> arr ;

	// 모든 
	public static int stoi(String str){
		return Integer.parseInt(str);
	}

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = stoi(br.readLine());
		arr = new ArrayList<>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++){
			int now = stoi(st.nextToken());
			arr.add(now); // 집 추가
		}

		Collections.sort(arr);
		if(arr.size()%2 == 0) System.out.println(arr.get(arr.size()/2-1));
		else System.out.println(arr.get(arr.size()/2));

    }
}
