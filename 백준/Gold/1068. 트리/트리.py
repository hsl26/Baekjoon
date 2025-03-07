N = int(input())
arr = list(map(int, input().split()))
e = int(input())

dict = {i:[] for i in range(N)}

for i in range(N):
    if arr[i] == -1:
        continue

    dict[arr[i]].append(i)


def remove(p, childs):
    arr[p] = -2

    if childs == []:
        return

    for c in childs:
        remove(c, dict[c])


remove(e, dict[e])


dict = {i:[] for i in range(N)}

for i in range(N):
    if arr[i] < 0:
        continue

    dict[arr[i]].append(i)


cnt = 0
for i in range(N):
    if arr[i] != -2 and dict[i] == []:
        cnt += 1

print(cnt)