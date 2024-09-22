N = int(input())
ans = 0

for _ in range(N):
    word = list(input())
    tmp = [word[0]]
    for i in range(1, len(word)):
        if tmp[-1] == word[i]:
            tmp += [word[i]]
        else:
            if word[i] in set(tmp):
                ans -= 1
                break
            else:
                tmp += [word[i]]
            
    ans += 1
print(ans)