import java.util.*;
import java.io.*;

class Solution {
    static boolean[][] gi,bo ;
    static int count ;
    
    public int[][] solution(int n, int[][] build_frame) {
        int[][] answer = {};
        gi = new boolean[n+1][n+1];
        bo = new boolean[n+1][n+1];
        
        int now[],x,y;
        for(int i=0;i<build_frame.length;i++){
            now = build_frame[i]; // 0 : x, 1: y, 2: 기둥,보, 3:설치,삭제
            x = now[0]; // 가로
            y = now[1]; // 세로

            if(now[2] == 0){ // 기둥
                if(now[3] == 0 ){// 기둥 삭제
                    gi[x][y] = false;
                    if(remove(n,x,y)){
                        count -- ;
                    }else{
                        gi[x][y] = true ;
                    }
                }else{
                    build_G(n,x,y);
                }
                
            }else{ // 보
                if(now[3] == 0 ){// 기둥 삭제
                    bo[x][y] = false;
                    if(remove(n,x,y)){
                        count -- ;
                    }else{
                        bo[x][y] = true ;
                    }
                }else{
                    build_Bo(n,x,y);
                }
                
            }
            
        }

        // 출력
        answer = new int[count][3];
        int idx = 0 ;
        for(int i=0;i<n+1;i++){
            for(int j=0;j<n+1;j++){
                if(gi[i][j]){
                    answer[idx][0] = i ;
                    answer[idx][1] = j ;
                    answer[idx++][2] = 0 ;
                }

                if(bo[i][j]){
                    answer[idx][0] = i ;
                    answer[idx][1] = j;
                    answer[idx++][2] = 1 ;
                }
            }
        }
        return answer;
    }
    
    static boolean check ;
    public static void build_G(int n, int x, int y){
        if(checkGArea(n,x,y)){
           gi[x][y] = true ; // 기둥 세움
           count ++ ;
        }
        
    }
    
    public static void build_Bo(int n, int x, int y){
        if(checkBoArea(n,x,y)){
            bo[x][y] = true ; // 보 세움
            count ++ ;
        }
        
    }
    
    public static boolean checkGArea(int n, int x, int y){
        if(y == 0 ) return true; // 바닥
        else if(y>0 && gi[x][y-1])return true ; // 다른 기둥 위
        else if(x>0 && bo[x-1][y] || bo[x][y]) return true ; // 보의 한쪽끝부분 위
            
        return false;
        
    }
    
    public static boolean checkBoArea(int n, int x, int y){
        // System.out.println(" Bo !!! , " + x+ " , " +  y);
        if(y>0 && gi[x][y-1] || gi[x+1][y-1]) return true ; //한쪽 끝이 기둥 위
        else if(x>0 && bo[x-1][y] && bo[x+1][y]) return true ;// 양쪽 끝이 보와 동시 연결
            
        return false;
    }
    
    
    public static boolean remove(int n, int x, int y){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(gi[i][j]){ // 기둥 == true
                    if(!checkGArea(n,i,j)) return false ; // result에 담긴 기둥이 조건을 만족하지 못함
                }

                if(bo[i][j]){ // 보 == true
                    if(!checkBoArea(n,i,j)) return false ; // result에 담긴 보가 조건을 만족하지 못함
                }
            }
        }
        return true ;
        
    }  
}

