n = int(input())
arr = [int(input()) for _ in range(n)]
stack = [-1]
ans = []

cur = 1
while arr:
    if stack[-1] == arr[0]:
        ans.append('-')
        stack.pop()
        arr.pop(0)
        continue

    if cur <= arr[0]:
        ans.append('+')
        stack.append(cur)
        cur += 1

    else:
        ans = ["NO"]
        break

for a in ans:
    print(a)