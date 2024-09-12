A, B, V = map(int, input().split())

day = (V - A) // (A-B)

if day < (V - A) / (A-B):
    day += 1

print(day + 1)