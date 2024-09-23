X = int(input())
idx = 1
sum = 0

while True:
    if sum < X <= (sum+idx):
        break
    sum += idx
    idx += 1

total = idx + 1

if idx%2 == 0:
    up = X - sum
    down = total-up
else:
    down = X - sum
    up = total-down

print(f'{up}/{down}')