S = input()

ans = [-1 for _ in range(26)]
for idx, s in enumerate(S):
    if ans[ord(s) - ord('a')] == -1:
        ans[ord(s) - ord('a')] = idx

for n in ans:
    print(n, end=' ')