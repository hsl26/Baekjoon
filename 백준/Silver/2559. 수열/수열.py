N, K = map(int, input().split())
temp = list(map(int, input().split()))

temp_sum = sum(temp[:K])
ans = temp_sum

for i in range(0, N-K):
    temp_sum = temp_sum - temp[i] + temp[i+K]
    if temp_sum > ans:
        ans = temp_sum

print(ans)