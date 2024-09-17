N, B = map(int, input().split())
std = ord('A')-10

ans = []
while True:
    if N < B:
        ans.append(N)
        break
    ans.append(N % B)
    N = N//B

for i in range(len(ans)-1, -1, -1):
    if ans[i] >= 10:
        print(chr(std+ans[i]), end='')
    else:
        print(ans[i], end='')