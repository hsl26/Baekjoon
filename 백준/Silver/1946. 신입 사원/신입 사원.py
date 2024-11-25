import sys
input = sys.stdin.readline

T = int(input())

for _ in range(T):
    N = int(input())
    rank = [list(map(int, input().split())) for _ in range(N)]
    rank.sort(key=lambda x:x[0])

    ans = 1
    itv = rank[0][1]
    for i in range(1, N):
        if itv >= rank[i][1]:
            ans += 1

        itv = min(itv, rank[i][1])

    print(ans)