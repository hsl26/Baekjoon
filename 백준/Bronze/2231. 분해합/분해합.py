N = int(input())
ans = 1000001
num = N - len(str(N))*9 if N - len(str(N))*9 >= 0 else 0

while True:
    if num >= N:
        break
    if num + sum(list(map(int, list(str(num))))) == N:
        if ans > num:
            ans = num
    num += 1

if ans == 1000001:
    ans = 0
print(ans)