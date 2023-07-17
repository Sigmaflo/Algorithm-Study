MOD = int(1e9)
MAX = 1<<10
# n = int(input())
m = 10

def solve():
    dp = [[[0]*(MAX) for _ in range(m)] for _ in range(n+1)]

    for i in range(1,m):
        dp[1][i][1<<i] = 1

    for length in range(1, n+1):
        for ed in range(m):
            for bit in range(MAX):
                if ed == 0:
                    dp[length][ed][bit | (1 << ed)] += dp[length-1][ed+1][bit]
                elif ed == 9:
                    dp[length][ed][bit | (1 << ed)] += dp[length-1][ed-1][bit]
                else:
                    dp[length][ed][bit | (1 << ed)] += dp[length-1][ed-1][bit] + dp[length-1][ed+1][bit]

                dp[length][ed][bit | (1 << ed)] %= MOD

    return sum(dp[n][i][MAX-1] for i in range(m))%MOD


def tmp():
    BIT_RANGE = 1 << 10
    NUM_RANGE = 10
    MOD = 1000000000

    # dp[자리 수][마지막 숫자][사용된 숫자들의 비트]
    # ex) 123 -> 0000001110
    dp = [[[0] * BIT_RANGE for _ in range(NUM_RANGE)] for _ in range(n+1)]

    # 0제외
    for i in range(1, NUM_RANGE):
        dp[1][i][1 << i] = 1

    # 자리 수
    for i in range(1, n):
        # 숫자 범위 j
        for j in range(NUM_RANGE):
            # 숫자 비트 표현
            for k in range(BIT_RANGE):
                # 맨 뒤에 있는 숫자가 0보다 크면 해당 숫자보다 1작은 숫자들이 올 수 있음
                if j > 0:
                    next = k | 1 << (j - 1)
                    dp[i+1][j-1][next] += dp[i][j][k]
                    dp[i+1][j-1][next] %= MOD
                # 맨 뒤에 있는 숫자가 9보다 작으면 해당 숫자보다 1큰 숫자들이 올 수 있음
                if j < 9:
                    next = k | 1 << (j + 1)
                    dp[i+1][j+1][next] += dp[i][j][k]
                    dp[i+1][j+1][next] %= MOD

    res = 0
    for i in range(NUM_RANGE):
        res += dp[n][i][BIT_RANGE-1]
        res %= MOD

    return res

n = 1
print(solve(), tmp())
