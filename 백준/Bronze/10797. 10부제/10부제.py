date = int(input()) % 10
car = list(map(int, input().split()))

cnt = car.count(date)

print(cnt)