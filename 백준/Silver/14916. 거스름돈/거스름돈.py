n = int(input())
ans = 100001

for i in range(0, n//5+1):
    cnt = i
    curr_n = n - 5*i
    if curr_n % 2 == 0:
        cnt += curr_n // 2
        if cnt < ans:
            ans = cnt

print(ans if ans != 100001 else -1)