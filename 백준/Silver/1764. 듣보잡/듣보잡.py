N, M = map(int, input().split())
no_heard = {input(): 1 for _ in range(N)}
no_saw = [input() for _ in range(M)]

ans = []
for s in no_saw:
    try:
        if no_heard[s] == 1:
            ans.append(s)
    except:
        continue

ans.sort()
print(len(ans))
for a in ans:
    print(a)