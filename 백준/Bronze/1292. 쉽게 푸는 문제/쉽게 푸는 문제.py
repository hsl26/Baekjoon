A, B = map(int, input().split())
num = 1
arr = []
while True:
    if len(arr) > B:
        break
    arr += [num for _ in range(num)]
    num += 1

print(sum(arr[A-1:B]))