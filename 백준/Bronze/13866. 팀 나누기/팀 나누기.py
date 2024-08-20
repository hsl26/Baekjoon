A, B, C, D = list(map(int, input().split()))

all = A+B+C+D
min_max = min(A,B,C,D) + max(A,B,C,D)
middle = all - min_max

ans = min_max-middle if min_max>middle else middle-min_max
print(ans)