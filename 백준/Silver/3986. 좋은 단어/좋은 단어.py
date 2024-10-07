N = int(input())
ans = 0
for _ in range(N):
    word = input()
    stack = [0]
    for w in word:
        if stack[-1] == w:
            stack.pop()
        else:
            stack.append(w)
    if len(stack) == 1:
        ans += 1

print(ans)