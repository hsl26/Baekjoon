import sys
input = sys.stdin.readline

N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]

arr.sort(key=lambda x:(x[1], x[0]))

tmp_end = 0
ans = 0
for s, e in arr:
    if tmp_end <= s:
        tmp_end = e
        ans += 1

print(ans)