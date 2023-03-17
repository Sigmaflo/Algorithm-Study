import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 고스택 {
    private static final String ERROR = "ERROR";
    private static final int MAX = 1000000000;

    private static List<String> commands;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        LOOP:
        while (true) {
            commands = new ArrayList<>();
            String input;
            while (!(input = br.readLine()).equals("END")) {
                if (input.equals("QUIT")) break LOOP;
                commands.add(input);
            }

            int N = Integer.parseInt(br.readLine());
            while (N-- > 0) {
                try {
                    bw.write(executeCommand(Integer.parseInt(br.readLine())) + "\n");
                } catch (Exception e) {
                    bw.write(ERROR + "\n");
                }
            }
            br.readLine();
            bw.write("\n");
        }

        br.close();
        bw.close();
    }

    private static String executeCommand(int input) throws Exception {
        Stack<Integer> stack = new Stack<>();
        stack.push(input);

        for (String command : commands) {
            if (command.startsWith("NUM")) {
                int x = Integer.parseInt(command.split(" ")[1]);
                stack.push(x);
                continue;
            }

            if (stack.size() < 1) {
                throw new Exception();
            }

            int num1 = stack.pop();
            if (command.equals("POP")) {
                continue;
            }

            if (command.equals("INV")) {
                stack.push(-num1);
                continue;
            }

            if (command.equals("DUP")) {
                stack.push(num1);
                stack.push(num1);
                continue;
            }

            if (stack.size() < 1) {
                throw new Exception();
            }

            int num2 = stack.pop();

            if (command.equals("SWP")) {
                stack.push(num1);
                stack.push(num2);
                continue;
            }

            long result = MAX + 1;

            switch (command) {
                case "ADD":
                    result = num2 + num1;
                    break;
                case "SUB":
                    result = num2 - num1;
                    break;
                case "MUL":
                    result = (long) num2 * num1;
                    break;
                default:
                    if (num1 == 0) throw new Exception();

                    if (command.equals("DIV")) {
                        result = num2 / num1;
                    } else if (command.equals("MOD")) {
                        result = num2 % num1;
                    }
                    break;
            }
            if (Math.abs(result) > MAX) throw new Exception();
            stack.push(Long.valueOf(result).intValue());
        }
        if (stack.size() != 1) {
            throw new Exception();
        }
        return stack.pop().toString();
    }
}
