n = int(input())
tile = [0] * (n+1 if n > 1 else 2)

tile[0] = 1
tile[1] = 1

for i in range(2, n+1):
    tile[i] = tile[i-1] + 2*tile[i-2]

print(tile[n]%10007)