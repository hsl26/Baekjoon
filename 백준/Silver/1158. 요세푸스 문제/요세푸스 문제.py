N, K = map(int, input().split())
people = [str(i) for i in range(1, N+1)]

ans = []
num = 0
for _ in range(N):
    num += K-1
    if num >= len(people):
        num %= len(people)

    ans.append(people.pop(num))

print("<", ", ".join(ans)[:], ">", sep='')