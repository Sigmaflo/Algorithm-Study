import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

enum Type {
    WHITE, RED, BLUE
}

enum Direction {
    RIGHT, LEFT, UP, DOWN
}

class Token {
    int number;
    Direction direction;
    Cell cell;
    boolean isBottom = false;

    public Token(int number, Direction direction) {
        this.number = number;
        this.direction = direction;
    }

    public void reverseDirection() {
        switch (direction) {
            case RIGHT:
                direction = Direction.LEFT;
                break;
            case LEFT:
                direction = Direction.RIGHT;
                break;
            case UP:
                direction = Direction.DOWN;
                break;
            case DOWN:
                direction = Direction.UP;
                break;
        }
    }
}

class Cell {
    int r;
    int c;
    Type type;
    List<Token> tokens = new ArrayList<>();

    public Cell(int r, int c, Type type) {
        this.r = r;
        this.c = c;
        this.type = type;
    }

    public void moveToNextCell(Cell nextCell) {
        tokens.get(0).isBottom = false;
        nextCell.addTokens(tokens);
        tokens.clear();
    }

    public void addToken(Token token) {
        tokens.add(token);
        tokens.get(0).isBottom = true;
        token.cell = this;
    }

    public void addTokens(List<Token> tokens) {
        for (Token token : tokens) {
            token.cell = this;
        }
        this.tokens.addAll(tokens);
        this.tokens.get(0).isBottom = true;
    }

    public void reverseTokens() {
        tokens.get(0).isBottom = false;
        Collections.reverse(tokens);
        tokens.get(0).isBottom = true;
    }

    public boolean isGameOver() {
        return tokens.size() >= 4;
    }
}

public class 새로운_게임 {
    private static final int[] ud = {0, 0, -1, 1};
    private static final int[] lr = {1, -1, 0, 0};

    private static Cell[][] board;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        board = new Cell[N][N];
        Token[] tokens = new Token[K];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = new Cell(i, j, Type.values()[Integer.parseInt(st.nextToken())]);
            }
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            Direction direction = Direction.values()[Integer.parseInt(st.nextToken()) - 1];
            Token token = new Token(i, direction);
            tokens[i] = token;
            board[r][c].addToken(token);
        }

        int answer = 0;

        LOOP:
        while (answer < 1000) {
            answer++;
            for (Token token : tokens) {
                if (!token.isBottom) continue;
                Cell nextCell = getNextCell(token);

                if (nextCell.type.equals(Type.BLUE)) {
                    token.reverseDirection();
                    nextCell = getNextCell(token);
                }

                switch (nextCell.type) {
                    case RED:
                        token.cell.reverseTokens();
                    case WHITE:
                        token.cell.moveToNextCell(nextCell);
                        break;
                }
                if (nextCell.isGameOver()) break LOOP;
            }
        }

        if (answer >= 1000) answer = -1;
        System.out.println(answer);
        br.close();
    }

    private static Cell getNextCell(Token token) {
        int nr = token.cell.r + ud[token.direction.ordinal()];
        int nc = token.cell.c + lr[token.direction.ordinal()];
        if (nr < 0 || N <= nr || nc < 0 || N <= nc) {
            token.reverseDirection();
            nr = token.cell.r + ud[token.direction.ordinal()];
            nc = token.cell.c + lr[token.direction.ordinal()];
        }
        return board[nr][nc];
    }
}
