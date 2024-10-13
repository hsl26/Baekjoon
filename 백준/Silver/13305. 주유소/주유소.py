N = int(input())
street = list(map(int, input().split()))
cost = list(map(int, input().split()))

min_cost = cost[0]*street[0]
oil = 0
for i in range(1, N-1):
    if cost[i]*street[i] < cost[oil]*street[i]:
        min_cost += cost[i]*street[i]
        oil = i
    else:
        min_cost += cost[oil]*street[i]

print(min_cost)