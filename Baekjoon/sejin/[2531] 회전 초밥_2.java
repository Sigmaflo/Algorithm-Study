import java.io.*;
import java.util.*;



public class Main {

    static int N,D,K,C;
    static int[] arr ;
	static int[] dishes ;

    public static int stoi(String str){
        return Integer.parseInt(str);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken()); // 접시의 수
        D = stoi(st.nextToken()); // 초밥의 가짓수
        K = stoi(st.nextToken()); // 연속해서 먹는 접시의 수
        C = stoi(st.nextToken()); // 쿠폰 번호

        arr = new int[N];
		dishes = new int[D+1];
        for(int i=0;i<N;i++) arr[i] = stoi(br.readLine());

		Sliding();

    }

	public static void Sliding(){
		int count = 0 ;

		//FirstEat
		for(int i=0;i<K;i++){
			if(dishes[arr[i]] == 0) count ++ ;
				
			dishes[arr[i]] ++ ; 
		}
		int MaxEat = dishes[C]==0?count+1:count;

		for(int i=0;i<N;i++){
			int removeIdx = (i)%N;
			int addIdx = (i+K)%N;
			
			// 해당 접시 제거
			if(dishes[arr[removeIdx]] == 1 ) count -- ; // 1개라면 카운트 1 감소, 해시맵 제거
			dishes[arr[removeIdx]] -- ;
			
			// 추가
			if(dishes[arr[addIdx]] == 0 ) count ++ ; // 현재 먹는 접시 추가
			dishes[arr[addIdx]] ++ ;

			// 쿠폰 먹었는 지 확인
			MaxEat = Math.max(MaxEat, dishes[C]==0?count+1:count);
		}

		System.out.println(MaxEat);
	}


}
