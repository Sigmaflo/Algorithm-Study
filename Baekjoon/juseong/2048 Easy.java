import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, ans;
    static int[][] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // (1 ≤ N ≤ 20)
        A = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        } // end of input
        rec_func(A, 0);
        System.out.println(ans);
    }

    // 보드를 상하좌우(상, 하, 좌, 우) 5번 이동하는 함수
    // cnt: 보드의 이동 횟수
    // B: cnt번 이동했을 때 보드의 상태
    static void rec_func(int[][] B, int cnt) {
        if (cnt == 5) { // 보드가 5번 이동했을 때
            // 가장 큰 블록을 찾는다
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < N; y++) {
                    ans = Math.max(ans, B[x][y]);
                }
            }
            return;
        }
        for (int k = 0; k < 4; k++) { // 상하좌우
            // move(B, k): 해당 방향으로 보드 이동
            rec_func(move(B, k),cnt+1); // 다음 상하좌우 이동 재귀 호출
        }
    }

    // 보드를 상하좌우중 하나로 이동한다
    // B: 이동할 보드, BB: 보드 이동 결과, dir: 이동방향
    static int[][] move(int[][] B, int dir) {
        int[][] BB = new int[N][N];
        if (dir == 0) { // 상 이동
            for (int y = 0; y < N; y++) { // 열
                boolean[] fixed = new boolean[N]; // 합칠 수 없는 칸
                for (int x = 0; x < N; x++) { // 줄
                    if (x == 0) { // 첫번째 줄일때
                        BB[x][y] = B[x][y]; // 숫자 위치 고정
                    } else { // 숫자가 이동할 수 있을 때 (x > 0)
                        BB[x][y] = B[x][y]; // 이동하지 않았을 때
                        if (BB[x][y] > 0 && BB[x-1][y] == BB[x][y]) { // 위의 숫자와 합칠 수 있을 때
                            BB[x-1][y] += BB[x-1][y]; // 위 숫자 2배 증가
                            BB[x][y] = 0; // 이전 칸은 0
                            fixed[x-1] = true; // 해당 칸은 더이상 합칠 수 없다
                        } else { // 이동 할 수 있는 칸을 찾는다
                            for (int xx = 0, prev_xx = -1; prev_xx < x; xx++, prev_xx++) { // 줄
                                if (BB[xx][y] == 0) { // 해당 칸이 비어 있으면
                                    BB[xx][y] = B[x][y]; // 해당 칸으로 숫자 이동
                                    BB[x][y] = 0; // 이전 칸은 0
                                    if (prev_xx >= 0 && BB[prev_xx][y] == BB[xx][y] && !fixed[prev_xx]) { // 위의 숫자와 합칠 수 있을 때
                                        BB[prev_xx][y] += BB[prev_xx][y]; // 위 숫자 2배 증가
                                        BB[xx][y] = 0; // 이전 칸은 0
                                        fixed[prev_xx] = true; // 해당 칸은 더이상 합칠 수 없다
                                    }
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        } else if (dir == 1) { // 하 이동
            for (int y = 0; y < N; y++) { // 열
                boolean[] fixed = new boolean[N]; // 합칠 수 없는 칸
                for (int x = N - 1; x >= 0; x--) { // 줄
                    if (x == N - 1) { // 맨 아래 줄일 때
                        BB[x][y] = B[x][y]; // 숫자 위치 고정
                    } else { // 숫자가 이동할 수 있을 때 (x < N)
                        BB[x][y] = B[x][y]; // 이동하지 않았을 때
                        if (BB[x][y] > 0 && BB[x][y] == BB[x+1][y]) { // 아래 숫자와 합칠 수 있을 때
                            BB[x+1][y] += BB[x+1][y]; // // 아래 숫자 2배 증가
                            BB[x][y] = 0; // 이전 칸은 0
                            fixed[x+1] = true; // 해당 칸은 더이상 합칠 수 없다
                        } else { // 이동 할 수 있는 칸을 찾는다
                            for (int xx = N - 1, prev_xx = N; prev_xx > x; xx--, prev_xx--) { // 줄
                                if (BB[xx][y] == 0) { // 해당 칸이 비어 있으면
                                    BB[xx][y] = B[x][y]; // 해당 칸으로 숫자 이동
                                    BB[x][y] = 0; // 이전 칸은 0
                                    if (prev_xx <= N - 1 && BB[prev_xx][y] == BB[xx][y] && !fixed[prev_xx]) { // 아래 숫자와 합칠 수 있을 때
                                        BB[prev_xx][y] += BB[prev_xx][y]; // // 아래 숫자 2배 증가
                                        BB[xx][y] = 0; // 이전 칸은 0
                                        fixed[prev_xx] = true; // 해당 칸은 더이상 합칠 수 없다
                                    }
                                    break;
                                }
                            }
                        }

                    }
                }
            }
        } else if (dir == 2) { // 좌 이동
            for (int x = 0; x < N; x++) { // 줄
                boolean[] fixed = new boolean[N]; // 합칠 수 없는 칸
                for (int y = 0; y < N; y++) { // 열
                    if (y == 0) { // 가장 왼쪽 열일 때
                        BB[x][y] = B[x][y]; // 숫자가 이동을 안한다
                    } else { // 숫자가 이동할 수 있을 때 (y > 0)
                        BB[x][y] = B[x][y]; // 이동하지 않았을 때
                        if (BB[x][y] > 0 && BB[x][y] == BB[x][y-1]) { // 왼쪽 숫자와 합칠 수 있을 때
                            BB[x][y-1] += BB[x][y-1]; // 왼쪽 수 2배 증가
                            BB[x][y] = 0; // 이전 칸은 0
                            fixed[y-1] = true; // 해당 칸은 더이상 합칠 수 없다
                        } else { // 이동 할 수 있는 칸을 찾는다
                            for (int yy = 0, prev_yy = -1; prev_yy < y; yy++, prev_yy++) {
                                if (BB[x][yy] == 0) { // 해당 칸이 비어 있으면
                                    BB[x][yy] = B[x][y]; // 해당 칸으로 숫자 이동
                                    BB[x][y] = 0; // 이전 칸은 0
                                    if (prev_yy >= 0 && BB[x][prev_yy] == BB[x][yy] && !fixed[prev_yy]) { // 왼쪽 숫자와 합칠 수 있을 때
                                        BB[x][prev_yy] += BB[x][prev_yy]; // 왼쪽 수 2배 증가
                                        BB[x][yy] = 0; // 이전 칸은 0
                                        fixed[prev_yy] = true; // 해당 칸은 더이상 합칠 수 없다
                                    }
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        } else { // dir == 3, // 우 이동
            for (int x = 0; x < N; x++) { // 줄
                boolean[] fixed = new boolean[N]; // 합칠 수 없는 칸
                for (int y = N - 1; y >= 0; y--) { // 열
                    if (y == N - 1) { // 가장 오른쪽 열일 때
                        BB[x][y] = B[x][y]; // 숫자가 이동을 안한다
                    } else { // 숫자가 이동할 수 있을 때 (y > 0)
                        BB[x][y] = B[x][y]; // 이동하지 않았을 때
                        if (BB[x][y] > 0 && BB[x][y] == BB[x][y+1]) { // 오른쪽 칸과 합칠 수 있을 떄
                            BB[x][y+1] += BB[x][y+1]; // 오른쪽 수 2배 증가
                            BB[x][y] = 0; // 이전 칸은 0
                            fixed[y+1] = true; // 해당 칸은 더이상 합칠 수 없다
                        } else { // 이동 할 수 있는 칸을 찾는다
                            for (int yy = N - 1, prev_yy = N; prev_yy > y; yy--, prev_yy--) {
                                if (BB[x][yy] == 0) { // 해당 칸이 비어 있으면
                                    BB[x][yy] = B[x][y]; // 해당 칸으로 숫자 이동
                                    BB[x][y] = 0; // 이전 칸은 0
                                    if (prev_yy <= N - 1 && BB[x][prev_yy] == BB[x][yy] && !fixed[prev_yy]) { // 오른쪽 칸과 합칠 수 있을 떄
                                        BB[x][prev_yy] += BB[x][prev_yy]; // 오른쪽 수 2배 증가
                                        BB[x][yy] = 0; // 이전 칸은 0
                                        fixed[prev_yy] = true; // 해당 칸은 더이상 합칠 수 없다
                                    }
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }

        return BB;
    }
}
