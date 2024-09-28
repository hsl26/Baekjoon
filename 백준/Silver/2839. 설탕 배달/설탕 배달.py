N = int(input())
ans = 5001

for i in range(N//5+1):
    cnt = i
    curN = N - 5*i
    if curN % 3 == 0:
        cnt += curN//3
        if cnt < ans:
            ans = cnt

print(ans if ans != 5001 else -1)