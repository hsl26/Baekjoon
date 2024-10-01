N, K = map(int, input().split())
people = [i for i in range(1, N+1)]
ans = []

while True:
    if len(people) == 0:
        break
    for _ in range(K):
        people.append(people[0])
        people = people[1:]
    ans.append(str(people[-1]))
    people.pop()

ans_str = ', '.join(ans)
print(f"<{ans_str}>")