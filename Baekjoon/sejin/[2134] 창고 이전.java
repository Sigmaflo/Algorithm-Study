import java.io.*;
import java.util.*;

// n층짜리 창고가진 회사
// m층짜리 창고 마련하여 이전

// 최대한 많은 물품, 크기 같음, 각 층에 몇 개
// k명의 인부 고용
// a번층으로 이동해서 한 개의 물품 들어올려 b번 층으로 이동 = a+b 의 시간 소요
// 많은 물품을 옮길 때 드는 최소 시간

public class Main {

	static int N,M,K;
	static int[] boxNums, moveNums ;
	static int allBoxes, moveBoxes;

	public static int stoi(String str){
		return Integer.parseInt(str);
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken()); 
		M = stoi(st.nextToken());
		K = stoi(st.nextToken());

		boxNums = new int[N];
		moveNums = new int[M];
		for(int i=0;i<N;i++) boxNums[i] = stoi(br.readLine());
		for(int i=0;i<M;i++) moveNums[i] = stoi(br.readLine());

		long moveCosts = 0 ;
		int count = 0 ;
		int aIdx = 0 ;
		int bIdx = 0 ;
		while(aIdx < N && bIdx < M ){
			// n층짜리 건물 제일 낮은 층 부터 탐색하여 박스 하나씩 빼고
			// m층짜리 건물 젱리 낮은 층 부터 탐색하여 박스 하나씩 쌓기

			if(boxNums[aIdx] == 0){
				aIdx ++ ;
				continue;
			}

			if(moveNums[bIdx] == 0 ){
				bIdx ++;
				continue ;
			}

			boxNums[aIdx] -= 1 ;// 해당 층에서 물건 빼오기
			moveNums[bIdx] -= 1 ;
			count ++ ;
			moveCosts += (aIdx+bIdx+2) ; 
		}

		System.out.println(count +" "+moveCosts);
		//x는 옮길 수 있는 최대 물품의 개수이고, y는 이때 드는 비용의 최솟값 출력
	} 

}
