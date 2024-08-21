A, B, C = map(int, input().split())

print(A+B+C - min(A, B, C) - max(A, B, C))