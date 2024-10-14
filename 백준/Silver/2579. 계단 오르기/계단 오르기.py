N = int(input())
stair = [int(input()) for _ in range(N)]
stair = [0] + stair
dp = [0]*(N+1)

if N >= 3:
    dp[1] = stair[1]
    dp[2] = stair[1]+stair[2]
    dp[3] = max(stair[1]+stair[3], stair[2]+stair[3])

    for i in range(4, N+1):
        back1 = dp[i-3]+stair[i-1]+stair[i]
        back2 = dp[i-2]+stair[i]
        dp[i] = max(back1, back2)
else:
    if N == 1:
        dp[1] = stair[1]
    if N == 2:
        dp[2] = stair[1] + stair[2]
        
print(dp[N])