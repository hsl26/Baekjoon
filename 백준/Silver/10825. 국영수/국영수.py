N = int(input())
arr = [tuple(input().split()) for _ in range(N)]
arr.sort(key=lambda x:(-int(x[1]), int(x[2]), -int(x[3]), x[0]))

for name, _, _, _ in arr:
    print(name)