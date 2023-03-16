import java.io.*;
import java.util.*;

class Tree implements Comparable<Tree>{
	int x,y,age;
	Tree(int x,int y,int age){
		this.x = x ;
		this.y = y ;
		this.age = age;
	}

	@Override
	public int compareTo(Tree o){
		return this.age - o.age;
	}

}

public class Main{

	static int N , M , K ;
	static int[][] addArr ;
	static LinkedList<Tree> treeArr ;
	static Queue<Tree> goneTreeArr ;

	static int[][] landArr;
	static int count ; 
	// 모든 
	public static int stoi(String str){
		return Integer.parseInt(str);
	}

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken()); // 나무 정보
		K = stoi(st.nextToken()); 

		addArr = new int[N][N];
		treeArr = new LinkedList<>();
		landArr = new int[N][N];

		// 겨울에 공급할 양분 입력
		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++){
				addArr[i][j] = stoi(st.nextToken());
				landArr[i][j] =  5;
			}
		}
		
		// 나무 정보 받음
		for(int i=0;i<M;i++){
			st = new StringTokenizer(br.readLine());
			int x = stoi(st.nextToken())-1;
			int y = stoi(st.nextToken())-1;
			int z = stoi(st.nextToken());
			treeArr.add(new Tree(x, y, z));
		}

		// <-- 값 입력받기

		while(K>0){
			K--; // 1년 지남
            if(treeArr.size() == 0 ) break;
			goneTreeArr = new LinkedList<>();

			// 봄
			eatFood();

			// 여름
			goneTreeCheck();

			// 가을
			breeding();

			// 겨울
			addFood();

			// System.out.println(Arrays.deepToString(landArr));

			// for(Tree tree : treeArr){
			// 	System.out.println(tree.x + " , " + tree.y + " , " + tree.age);
			// }

		}

		System.out.println(treeArr.size());

	}

	public static void eatFood(){
		Iterator<Tree> iterator = treeArr.iterator();
		while (iterator.hasNext()) {
			Tree nowTree = iterator.next();
			if(landArr[nowTree.x][nowTree.y] < nowTree.age){
				// 먹지못하고 즉시 죽음
				goneTreeArr.offer(nowTree);
				iterator.remove(); /* LinkedList에서 iterator를 통한 remove : O(1) */
				continue ;
			} else {
				landArr[nowTree.x][nowTree.y] -= nowTree.age;
				nowTree.age += 1;
			}
		}
	}

	// 여름 죽은 나무 확인	
	public static void goneTreeCheck(){
		for(Tree nowTree : goneTreeArr){
			landArr[nowTree.x][nowTree.y] += (int)nowTree.age/2 ;
		}
	}

	// 가을 나무 번식
	static int[] dx={1,0,-1,0,-1,-1,1,1},dy={0,1,0,-1,1,-1,-1,1};
	public static void breeding(){

		LinkedList<Tree> newTree = new LinkedList<>();
		for(Tree nowTree : treeArr){
			if(nowTree.age%5 != 0 ) continue ;
			for(int i=0;i<8;i++){
				int xx = nowTree.x + dx[i];
				int yy = nowTree.y + dy[i];
				if(xx<0 || xx>=N || yy<0 || yy>=N ) continue ;
				newTree.add(new Tree(xx, yy, 1));
			}
		}
		treeArr.addAll(0,newTree);
	}

	// 겨울 양분추가
	public static void addFood(){
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				landArr[i][j] += addArr[i][j] ;
			}
		}
	}

}
