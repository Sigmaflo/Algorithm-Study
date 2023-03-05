import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

class City {
    int name;
    Set<City> cities = new HashSet<>();

    public City(int name) {
        this.name = name;
    }

    public boolean isLinked(int finding) {
        for(City city : cities) {
            if(city.name == finding) return true;
            if(city.isLinked(finding, name)) return true;
        }
        return false;
    }

    private boolean isLinked(int finding, final int from) {
        if(from == name) return false;
        for(City city : cities) {
            if(city.name == finding) return true;
            if(city.isLinked(finding, from)) return true;
        }
        return false;
    }
}

public class 여행_가자 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        City[] links = new City[N + 1];
        String answer = "YES";

        for(int i = 1; i <= N; i++) {
            links[i] = new City(i);
        }

        for(int from = 1; from <= N; from++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int to = 1; to <= N; to++) {
                if(st.nextToken().equals("0")) continue;
                links[from].cities.add(links[to]);
            }
        }

        int[] route = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for(int i = 0; i < M - 1; i++) {
            if(!links[route[i + 1]].isLinked(route[i])) {
                answer = "NO";
                break;
            }
        }

        System.out.println(answer);
        br.close();
    }
}
