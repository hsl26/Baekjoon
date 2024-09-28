N = int(input())
ans = list(set(list(map(int, input().split()))))
ans.sort()
for a in ans:
    print(a, end=' ')