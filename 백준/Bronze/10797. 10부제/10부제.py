date = int(input()) % 10
car = list(map(int, input().split()))

cnt = 0
for c in car:
    if c == date:
        cnt += 1
print(cnt)