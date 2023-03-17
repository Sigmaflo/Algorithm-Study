import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb;

    static boolean input() throws IOException {
        sb = new StringBuilder();
        deque = new LinkedList<>();
        nums = new LinkedList<>();
        cmds = new LinkedList<>();
        String line = br.readLine();
        if(line.equals("QUIT")) return false;
        while(!line.equals("END")) {
            StringTokenizer st = new StringTokenizer(line);
            String cmd = st.nextToken();
            cmds.add(cmd);
            if(cmd.equals("NUM")) nums.add(Integer.parseInt(st.nextToken()));
            line = br.readLine();
        }
        N = Integer.parseInt(br.readLine());
        V = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            V.add(Integer.parseInt(br.readLine()));
        }
        br.readLine();
        return true;
    }

    static Deque<Integer> deque;
    static List<Integer> V;
    static Queue<Integer> nums;
    static List<String> cmds;
    static int N;

    static void pro() {
        for (int v : V) {
            boolean isError = false;
            deque.add(v);
            Queue<Integer> queue1 = new LinkedList<>(nums);
            for (String cmd : cmds) {
                if (cmd.equals("NUM")) {
                    deque.addLast(queue1.poll());
                } else if (cmd.equals("POP")) {
                    if (deque.isEmpty()) {
                        isError = true;
                    } else {
                        deque.pollLast();
                    }
                } else if (cmd.equals("INV")) {
                    if (deque.isEmpty()) {
                        isError = true;
                    } else {
                        int n = deque.pollLast();
                        n *= -1;
                        deque.addLast(n);
                    }
                } else if (cmd.equals("DUP")) {
                    if (deque.isEmpty()) {
                        isError = true;
                    } else {
                        int n = deque.peekLast();
                        deque.addLast(n);
                    }
                } else if (cmd.equals("SWP")) {
                    if (deque.size() < 2) {
                        isError = true;
                    } else {
                        int n1 = deque.pollLast();
                        int n2 = deque.pollLast();
                        deque.addLast(n1);
                        deque.addLast(n2);
                    }
                } else if (cmd.equals("ADD")) {
                    if (deque.size() < 2) {
                        isError = true;
                    } else {
                        int n1 = deque.pollLast();
                        int n2 = deque.pollLast();
                        if (n1 + n2 > 1000000000) {
                            isError = true;
                        } else{
                            deque.addLast(n1 + n2);
                        }
                    }
                } else if (cmd.equals("SUB")) {
                    if (deque.size() < 2) {
                        isError = true;
                    } else {
                        int n1 = deque.pollLast();
                        int n2 = deque.pollLast();
                        if (n2 - n1 < -1000000000) {
                            isError = true;
                        } else {
                            deque.addLast(n2 - n1);
                        }
                    }
                } else if (cmd.equals("MUL")) {
                    if (deque.size() < 2) {
                        isError = true;
                    } else {
                        int n1 = deque.pollLast();
                        int n2 = deque.pollLast();
                        long n3 = (long) n1 * (long) n2;
                        if (n3 > 1000000000) {
                            isError = true;
                        } else{
                            deque.addLast(n1 * n2);
                        }
                    }
                } else if (cmd.equals("DIV")) {
                    if (deque.size() < 2) {
                        isError = true;
                    } else {
                        int n1 = deque.pollLast();
                        int n2 = deque.pollLast();
                        if (n1 == 0) {
                            isError = true;
                        } else if ((n1 < 0 && n2 > 0) || (n1 > 0 && n2 < 0)) {
                            n1 = Math.abs(n1);
                            n2 = Math.abs(n2);
                            int n3 = -1 * (n2 / n1);
                            deque.addLast(n3);
                        } else {
                            n1 = Math.abs(n1);
                            n2 = Math.abs(n2);
                            deque.addLast(n2 / n1);
                        }
                    }
                } else if (cmd.equals("MOD")) {
                    if (deque.size() < 2) {
                        isError = true;
                    } else {
                        int n1 = deque.pollLast();
                        int n2 = deque.pollLast();
                        if (n1 == 0) {
                            isError = true;
                        } else if (n2 < 0) {
                            n1 = Math.abs(n1);
                            n2 = Math.abs(n2);
                            int n3 = -1 * (n2 % n1);
                            deque.addLast(n3);
                        } else {
                            n1 = Math.abs(n1);
                            n2 = Math.abs(n2);
                            deque.addLast(n2 % n1);
                        }
                    }
                }
            }
            if (deque.size() != 1 || isError) {
                sb.append("ERROR\n");
            } else {
                sb.append(deque.poll()).append('\n');
            }
            deque.clear();
        }
    }

    public static void main(String[] args) throws IOException {
        boolean con = input();
        while(con) {
            pro();
            System.out.println(sb.toString());
            con = input();
        }
    }
}
