import java.io.*;
import java.util.*;

public class Main{

	static int N;
	static ArrayList<Integer> befSolved ;
	static HashMap<Integer, ArrayList<Integer>> history ;

	public static int stoi(String str){
		return Integer.parseInt(str);
	}

//'a' : K인 문제를 풀고 기록

//'s' : 가장 최근에 작성한 문제 목록 삭제

//'t' : K 쿼리  바로 전에 있던 푼 문제 목록으로 되돌아 감

    public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = stoi(br.readLine()); // 쿼리 개수
		history = new HashMap<>();

		for(int i=0;i<N;i++){
			StringTokenizer st  = new StringTokenizer(br.readLine());
			String query = st.nextToken();

			// System.out.println(history);

			if(history.containsKey(i-1)) befSolved = (ArrayList<Integer>)(history.get(i-1)).clone();
			else befSolved = new ArrayList<>();

			if(query.equalsIgnoreCase("s")){
				if(befSolved.size()>0){
					// 제일 마지막 해결 문제 제거
					befSolved.remove(befSolved.size()-1); 
				}
			}else{
				int num = stoi(st.nextToken());
				if(query.equalsIgnoreCase("a")){
					// 현재 문제를 전 arraylist에 추가
					befSolved.add(num);
				}else{ // t 인 경우
					// System.out.println(num-2);
					if(history.containsKey(num-2)) befSolved = history.get((num-2));
					else befSolved = new ArrayList<>();

				}
				
			}
			// System.out.println(befSolved.toString());
			history.put(i, befSolved);
			if(befSolved.size() > 0 ) sb.append(befSolved.get(befSolved.size()-1)+"\n");
			else sb.append(-1+"\n");
		}
		System.out.println(sb.toString());

    }


}
