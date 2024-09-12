arr = [int(input()) for _ in range(9)]
arr.sort()

ans = []
for i in range(9):
    for j in range(i, 9):
        if sum(arr) - arr[i] - arr[j] == 100:
            ans = [i, j]
            break
    if len(ans) == 2:
        break

for a in arr:
    if a == arr[ans[0]] or a == arr[ans[1]]:
        continue
    else:
        print(a)