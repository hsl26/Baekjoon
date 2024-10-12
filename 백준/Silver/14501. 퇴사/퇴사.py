N = int(input())
day = [0]*(N+1)
price = [0]*(N+1)
for i in range(1, N+1):
    d, p = map(int, input().split())
    day[i] = d
    price[i] = p

ans = 0

def bT(d, profit):
    global ans
    if d > N+1:
        return

    total = sum(profit)
    if total > ans:
        ans = total

    for i in range(d+1, N+1):
        if i+(day[i]-1) > N:
            continue

        profit.append(price[i])
        bT(i+(day[i]-1), profit)
        profit.pop()

bT(0, [])
print(ans)