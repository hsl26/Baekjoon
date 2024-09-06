ans = ['D', 'C', 'B', 'A', 'E']

for _ in range(3):
    arr = list(map(int, input().split()))
    print(ans[sum(arr)])