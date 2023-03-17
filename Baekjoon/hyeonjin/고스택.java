import java.io.*;
import java.util.*;

public class 고스택 {
    static final long MAX = 1_000_000_000;
    static boolean error;
    static boolean end;
    static boolean quit;
    static List<String> command;
    static Stack<Long> stack;
    static BufferedReader br;
    static StringTokenizer str;
    public static void main(String[] args) throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            command = new ArrayList<>();
            quit = false;
            end = false;

            addCommand();
            if(quit) return;
            int N = Integer.valueOf(br.readLine());

            for(int i = 0; i < N; i++) {
                error = false;
                stack = new Stack<>();
                stack.add(Long.valueOf(br.readLine()));
                calc();

                if(error || stack.size() != 1) System.out.println("ERROR");
                else System.out.println(stack.peek());
            }

            System.out.println("");
            br.readLine();
        }
    }

    private static void calc() {
        for(int i = 0; i < command.size(); i++) {
            if(error) return;

            switch(command.get(i)) {
                case "NUM":
                    i++;
                    pushNum(Long.valueOf(command.get(i)));
                    break;

                case "POP":
                    popNum();
                    break;

                case "INV" :
                    invNum();
                    break;

                case "DUP" :
                    dupNum();
                    break;

                case "SWP" :
                    swapNum();
                    break;

                case "ADD" :
                    addNum();
                    break;

                case "SUB" :
                    subNum();
                    break;

                case "MUL" :
                    mulNum();
                    break;

                case "DIV" :
                    divNum();
                    break;

                case "MOD" :
                    modeNum();
                    break;

                default:
                    end = true;
                    break;
            }
        }
    }

    private static void addCommand() throws IOException {
        str = new StringTokenizer(br.readLine());

        int size = 0;

        while(!quit) {
            command.add(str.nextToken());
            if(command.get(size).equals("NUM")) {
                command.add(str.nextToken());
                size++;
            }
            else if(command.get(size).equals("QUIT")) {
                quit = true;
                return;
            }
            else if(command.get(size).equals("END")) {
                return;
            }

            str = new StringTokenizer(br.readLine());
            size++;
        }
    }

    private static void modeNum() {
        if(stack.peek() == 0 || stack.size() < 2) error = true;
        if(error) return;

        Long num1 = stack.pop();
        Long num2 = stack.pop();


        Long result = Math.abs(num2) % Math.abs(num1);
        if(num2 < 0) result *= -1;

        stack.add(result);

    }

    private static void divNum() {
        if(stack.peek() == 0 || stack.size() < 2) error = true;
        if(error) return;

        Long num1 = stack.pop();
        Long num2 = stack.pop();

        int minus = 0;
        if(num1 < 0) minus++;
        if(num2 < 0) minus++;

        num1 = Math.abs(num1);
        num2 = Math.abs(num2);

        Long result = num2 / num1;
        if(minus == 1) result *= -1;

        stack.add(result);
    }

    private static void mulNum() {
        if(stack.size() < 2) error = true;
        if(error) return;

        Long num1 = stack.pop();
        Long num2 = stack.pop();

        long result = (long)num1 * (long)num2;
        if(Math.abs(result) > MAX) error = true;
        if(error) return;

        stack.push(num2 * num1);
    }

    private static void subNum() {
        if(stack.size() < 2) error = true;
        if(error) return;

        Long num1 = stack.pop();
        Long num2 = stack.pop();

        long result = (long)num2 - (long)num1;
        if(Math.abs(result) > MAX) error = true;
        if(error) return;

        stack.push(num2 - num1);
    }

    private static void addNum() {
        if(stack.size() < 2) error = true;
        if(error) return;

        Long num1 = stack.pop();
        Long num2 = stack.pop();

        long result = (long)num1 + (long)num2;
        if(Math.abs(result) > MAX) error = true;
        if(error) return;

        stack.push(num1 + num2);
    }

    private static void swapNum() {
        if(stack.size() < 2) error = true;
        if(error) return;

        Long num1 = stack.pop();
        Long num2 = stack.pop();

        stack.add(num1);
        stack.add(num2);

    }

    private static void dupNum() {
        if(stack.isEmpty()) error = true;
        if(error) return;

        stack.add(stack.peek());
    }

    private static void invNum() {
        if(stack.isEmpty()) error = true;
        if(error) return;

        Long num = stack.pop();
        num *= -1;
        stack.add(num);
    }

    private static void popNum() {
        if(stack.isEmpty()) error = true;
        if(error) return;

        stack.pop();
    }

    private static void pushNum(Long num) {
        stack.add(num);
    }
}
