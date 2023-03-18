import java.util.*;
import java.io.*;

/*
왼쪽 변수형 + 오른쪽 변수형 거꾸로

각각의 변수의 오른편에 있는 변수형을 모두 왼쪽으로 옮기고
한줄에 하나씩 선언
 */
public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        // 기본 변수형
        String type = st.nextToken();

        while(st.hasMoreTokens()) {
            String s = st.nextToken();

            // 뒤에서부터 체크
            int idx = s.length()-2;
            sb.append(type);

            // 알파벳이 나올 때 까지 sb에 추가
            while(!Character.isAlphabetic(s.charAt(idx))) {
                if(s.charAt(idx)==']') {
                    sb.append("[]");
                    idx-=2;
                }
                else sb.append(s.charAt(idx--));
            }

            // 변수명 추가
            sb.append(" "+s.substring(0,idx+1)+";\n");
        }

        System.out.println(sb);
    }
}

