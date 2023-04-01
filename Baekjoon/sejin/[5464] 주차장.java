import java.io.*;
import java.util.*;

class park{
    boolean used;
    int cost;
    park(boolean used , int cost){
        this.used = used ;
        this.cost = cost ;
    }
}

class car{
    int weight,useIdx;
    car(int weight, int useIdx){
        this.weight = weight;
        this.useIdx = useIdx;
    }
}
 
class Main {

    static int N,M;
    static park[] parks; // 사용여부, 요금
    static HashMap<Integer,car> hm ; // 번호,차정보
    static Queue<Integer> q ;

    public static int stoi(String str){
        return Integer.parseInt(str);
    }
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken()); // 주차공간의 수
        M = stoi(st.nextToken()); // 차량의 수

        parks = new park[N+1];
        for(int i=1;i<=N;i++){
            parks[i] = new park(false, stoi(br.readLine()));
        }

        hm = new HashMap<>();
        for(int i=1;i<=M;i++){
            hm.put(i,new car(stoi(br.readLine()),-1)); // 차 번호, 차 무게
        }
        //<-- 값 입력받기

        String now ;
        boolean isOut = false ;
        int nowNum, parkIdx=0, inNum=0 ;
        int allCost = 0 ;
        q = new LinkedList<>();

        while(true){
            now = br.readLine();
            if(now == null) break; // 입력 끝
            nowNum = stoi(now);
            if(nowNum > 0 ){ // 입차
                if(inNum < N){ // 입차된 차들 개수 <= 주차가능자리
                    if(q.size()>0){ // 대기 차가 있을 때
                        allCost += inCar(q.poll()); // 맨 앞 차를 입차
                        q.add(nowNum);
                    }else{ //대기 차 없을 때
                        allCost += inCar(nowNum); //현재 차 입차
                    }
                    inNum ++ ; 
                }else{ // 자리 없을 때
                    q.add(nowNum); // 현재 들어온 차를 큐에 넣고
                }
            }else { // 출차
                isOut = true ;
                inNum -- ;
                outCar(Math.abs(nowNum));

                // 출차 후, 대기 차가 있는 상황
                if(q.size()>0){
                    while(inNum<N){
                        allCost += inCar(q.poll()); // 맨 앞 차를 입차
                        inNum++;
                    }
                }

            }

        }
        System.out.print(allCost);
    }

    public static int inCar(int num){
        int nowZari = findZari();
        parks[nowZari].used = true ;
        hm.get(num).useIdx = nowZari;
        return parks[nowZari].cost * hm.get(num).weight; // 주차장 자리값*차무게

    }

    public static void outCar(int num){
        int parkZari = hm.get(num).useIdx ; // 나갈 차가 주차한 자리
        parks[parkZari].used = false ;
    }

    public static int findZari(){
        for(int i=1;i<N+1;i++){
            if(!parks[i].used) return i ;
        }
        return -1 ;
    }
}
