import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 영우는_사기꾼 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
        Building[] buildings = new Building[n + 1];
        int[] numberOfBuilding = new int[n + 1];
        boolean isLier = false;

        for (int i = 0; i <= n; i++)
            buildings[i] = new Building(i);

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
            buildings[x].next.add(y);
            buildings[y].cnt++;
        }

        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            if(isLier) continue;
            int op = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            switch (op){
                case 1 :
                    if(buildings[b].cnt > 0){
                        isLier = true;
                        continue;
                    }
                    numberOfBuilding[b]++;
                    if(numberOfBuilding[b] > 1) continue;
                    for(int nxt : buildings[b].next)
                        if(buildings[nxt].cnt > 0)
                            buildings[nxt].cnt--;
                    break;
                case 2 :
                    if(numberOfBuilding[b] == 0)
                        isLier = true;
                    else {
                        numberOfBuilding[b]--;
                        if(numberOfBuilding[b] == 0){
                            for(int nxt : buildings[b].next)
                                buildings[nxt].cnt++;
                        }
                    }
                    break;
            }
        }
        if(isLier) System.out.println("Lier!");
        else System.out.println("King-God-Emperor");
        br.close();
    }

    static class Building{
        int number, cnt;
        List<Integer> next = new ArrayList<>();

        public Building(int number) {
            this.number = number;
        }
    }
}
