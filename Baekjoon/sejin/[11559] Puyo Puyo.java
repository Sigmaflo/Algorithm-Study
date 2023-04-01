import java.util.*;
import java.io.*;
import java.awt.Point;
 
public class Main {

    static int[][] arr ;
    static boolean[][] visited ;

    public static int stoi(String str){
        return Integer.parseInt(str);
    }
 
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        arr = new int[12][6];
        visited = new boolean[12][6];
        
        for(int i=0;i<12;i++){
            String[] str = br.readLine().split("");
            for(int j=0;j<6;j++){
                arr[i][j] = chgStr(str[j]);
            }
        }
        
        //<-- 값 입력받기
        int count = 0 ;
        while(true){
            // 초기화
            q = new LinkedList<>(); // 상하좌우를 탐색하며 색이 같을 경우 저장할 큐
            chgQ = new LinkedList<>(); // 4번이상 나온 경우, 저장해둘 큐
            visited = new boolean[12][6];
            //<--
            FindPuyo(); // 전체 맵 탐색
            if(chgQ.size() == 0 ) break;
            else chgSameColor(); // 4개 이상 뿌요 터트림
            count ++ ;
        }

        System.out.println(count);

    }

    static void FindPuyo(){
        for(int i=0;i<12;i++){
            for(int j=0;j<6;j++){
                if(!visited[i][j] && arr[i][j] != 0 ){
                    visited[i][j] = true ;
                    // System.out.println("DFS START : " + i + " , " + j);
                    DfsCount = 0 ;
                    DFS(i,j, arr[i][j]); // 상하좌우 탐색
                    if(q.size()>=4) chgQ.addAll(q);
                    q = new LinkedList<>(); // DFS 지났으므로 초기화
                }
            }
        }
    }

    static int[] dx={-1,0,1,0},dy={0,-1,0,1};
    static Queue<Point> q ;
    static Queue<Point> chgQ ;
    static int DfsCount = 0 ;

    private static void DFS(int x, int y, int nowColor){
        q.add(new Point(x,y));

        for(int i=0;i<4;i++){
            int xx = x+dx[i];
            int yy = y+dy[i];
            if(xx<0 || xx>=12 || yy<0 || yy>=6|| visited[xx][yy]) continue ;
            if(arr[xx][yy] == nowColor){ 
                // System.out.println(xx+" , " + yy + " ,color : " + nowColor);
                visited[xx][yy] = true ; 
                DFS(xx,yy,nowColor);
            }
        }
    }

    private static void chgSameColor(){
        // 터질 수 있는 뿌요가 여러 그룹이 있다면 동시에 터져야 하고 여러 그룹이 터지더라도 한번의 연쇄가 추가된다
        while(!chgQ.isEmpty()){
            Point nowP = chgQ.poll();
            arr[nowP.x][nowP.y] = 0 ; // 뿌요 터짐
        }
        // 중력, 밑으로 내려주기
        for(int j=5;j>=0;j--){
            int count = 0 ;
            for(int i=11;i>0;i--){
                if(arr[i][j] == 0 && arr[i-1][j] != 0 ){
                    arr[i+count][j] = arr[i-1][j] ; 
                    arr[i-1][j] = 0 ;
                }else if(arr[i][j] == 0) count ++ ; // 계속 0 나오다가 숫자 나오는 경우, 한 번에 내려줘야 하므로 count 변수 사용
            }
        }
    }

    static int chgStr(String str){
        switch(str){
            case ".":
                return 0 ;
            case "R":
                return 1 ;
            case "G":
                return 2 ;
            case "B":
                return 3 ;
            case "P":
                return 4 ;
            case "Y":
                return 5 ;
        }
        return 0 ;
    }

    static void printq(Queue<Point> q){
        for(Point now : q){
            System.out.println(now.x + " , " + now.y);
        }
    }
}
