import java.util.*;
import java.io.*;
 
 
class Robot{
    int x,y,dist;
 
    public Robot(int x,int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}
 
 
public class Main {
 
    static int A,B,N,M;
    static Robot[] robots;
    static int[][] map;
    static StringBuilder sb ;
    static boolean finished = false ;

    public static int stoi(String str){
        return Integer.parseInt(str);
    }
 
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = stoi(st.nextToken()); // 가로
        B = stoi(st.nextToken()); // 세로
        map = new int[B][A];
        
        st = new StringTokenizer(br.readLine());
        N = stoi(st.nextToken()); // 로봇 개수
        robots = new Robot[N+1];
        M = stoi(st.nextToken()); // 명령 개수

        for(int i=1;i<N+1;i++){
            st = new StringTokenizer(br.readLine());
            int x = stoi(st.nextToken())-1;
            int y = B-stoi(st.nextToken());
            int dist = setDist(st.nextToken());
            robots[i] = new Robot(y, x, dist);
            map[y][x] = i ;
        }
        
        sb = new StringBuilder();
        for(int i=0;i<M;i++){
            if(finished) break;
            st = new StringTokenizer(br.readLine());
            int robotNum = stoi(st.nextToken()); // 로봇 번호
            String moveDist = st.nextToken(); // L : 왼쪽 90, R : 오른쪽 90 , F : 앞으로 한 칸
            int count = stoi(st.nextToken()); // 반복 횟수
            moveRobot(robotNum, moveDist, count);
        }
        if(sb.length() > 0) System.out.print(sb);
        else System.out.println("OK");
    }

    public static void moveRobot(int robotNum, String moveDist, int count){
        Robot nowR = robots[robotNum];
        for(int i=0;i<count;i++){ // count번 반복
            if(finished) break;
            switch(moveDist){
                case "F":
                    int xx = robots[robotNum].x + dx[robots[robotNum].dist];
                    int yy = robots[robotNum].y + dy[robots[robotNum].dist];
                    if(outOfRange(xx,yy)){ // 범위 벗어나서 떨어짐
                        crashWall(robotNum);
                        return;
                    }
                    if(map[xx][yy] != 0){ // 다른 로봇 있음
                        crashXY(robotNum, map[xx][yy]);
                        return;
                    }
                    map[robots[robotNum].x][robots[robotNum].y] = 0 ; // 이전 값 초기화
                    robots[robotNum].x = xx ; // 로봇 좌표값 갱신
                    robots[robotNum].y = yy ;
                    map[xx][yy] = robotNum ; // 현재 위치 갱신
                    break;
                
                case "L":
                    robots[robotNum].dist = left[robots[robotNum].dist];
                    break;
                case "R":
                    robots[robotNum].dist = right[robots[robotNum].dist];
                    break;
            }

        }
    }

    public static void crashWall(int idx){
        finished = true ;
        sb.append("Robot "+ idx+" crashes into the wall");
    }

    public static void crashXY(int x,int y){
        finished = true ;
        sb.append("Robot "+ x+" crashes into robot "+ y);
    }

    public static boolean outOfRange(int x, int y){
        if(x<0 || x>=B || y<0 || y>=A) return true ;
        else return false ;
    }

    // 들어온 STR 값으로 로봇 방향 설정
    static int[] dy={0,-1,1,0},dx={-1,0,0,1}; // N,W,E,S 에 맞춰 설정
    static int[] left={1,3,0,2},right={2,0,3,1}; 

    public static int setDist(String nowStr){
        switch(nowStr){
            case "N" : 
                return 0;
            case "W" :
                return 1 ;
            case "E" :
                return 2 ;
            case "S" :
                return 3 ;
        }
        return 0 ;
    }
}
