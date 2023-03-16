import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main{

	static int N , M , robotsSize ;
	static int[] arr ;
	static boolean[] robots ;
	static int count ; 
	// 모든 
	public static int stoi(String str){
		return Integer.parseInt(str);
	}

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken())*2;
		robotsSize = (N/2)-1 ;
		M = stoi(st.nextToken());
		arr = new int[N];
		robots = new boolean[N/2];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) arr[i] = stoi(st.nextToken());

		while(!checkZero()){

			rotateArr();
			rotateRobot();
			count ++ ;
		}
		System.out.println(count);

	}

	public static void rotateArr(){
		// 배열 회전
		int temp = arr[N-1];
		for(int i=N-1;i>0;i--) arr[i] = arr[i-1];
		arr[0] = temp ;
	}

	public static void rotateRobot(){
		//로봇 한 칸씩 이동, 내리는 위치는 제외(-1)
		for (int i = robotsSize ; i > 0; i--) {
            robots[i] = robots[i-1]; 
        }

		robots[0] = false ;
		// 로봇 내리기
		robots[robotsSize] = false ;

		// 로봇 이동가능일 시 한 번 더 이동
        for (int i = robotsSize ; i > 0; i--) {
            if (robots[i - 1] && !robots[i] && arr[i] >= 1) {
                robots[i] = true;
                robots[i - 1] = false;
                arr[i]--;
            }
        }

		// 로봇 올리기
		if(arr[0] > 0 ){
			robots[0] = true ;
			arr[0] -- ;
		} 
		// System.out.println("second Rotate : " + Arrays.toString(robots));

	}

	public static boolean checkZero(){
		int zeroCount = 0 ;
		for(int i=0;i<N;i++){
			if(arr[i] == 0 ){
				zeroCount ++ ;
				if(zeroCount==M)break;
			}
		}
		return zeroCount==M?true:false;
	}
}
