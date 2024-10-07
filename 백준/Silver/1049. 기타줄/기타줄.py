N, M = map(int, input().split())
set_cnt = N // 6
else_set = N % 6

s = [0]*M
p = [0]*M

for i in range(M):
    bs, bp = map(int, input().split())
    s[i] = bs
    p[i] = bp

ans = 1000*100

prices = [0, 0, 0]
# 전부 세트로 구매
if else_set == 0:
    prices[0] = set_cnt * min(s)
else:
    prices[0] = (set_cnt+1) * min(s)
# 세트 + 낱개
prices[1] = set_cnt*min(s) + else_set*min(p)
# 전부 낱개
prices[2] = N * min(p)

ans = min(ans, min(prices))

print(ans)