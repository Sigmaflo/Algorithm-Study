import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 택배 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());
        int answer = 0;

        int[][] parcels = new int[N][N + 1];
        int[] freeSpaces = new int[N];
        Arrays.fill(freeSpaces, C);

        while (M-- > 0){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int boxes = Integer.parseInt(st.nextToken());
            parcels[from][to] = boxes;
        }

        for(int to = 2; to <= N; to++){
            for(int from = 1; from < N; from++){
                int parcel = parcels[from][to];
                if(parcel > freeSpaces[from]) parcel = freeSpaces[from];
                for(int m = from; m < to; m++)
                    freeSpaces[m] -= parcel;
                answer += parcel;
            }
        }

        System.out.println(answer);
        br.close();
    }
}