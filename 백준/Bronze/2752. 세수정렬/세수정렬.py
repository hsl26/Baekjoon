number = list(map(int, input().split()))

number.sort()

for idx in range(3):
    print(number[idx], end=' ')