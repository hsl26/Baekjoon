name = list(input())
ans = ['']*len(name)
cnt = [0]*26
for n in name:
    cnt[ord(n)-ord('A')] += 1

odd = []
for i in range(26):
    if cnt[i] % 2 == 1:
        odd.append(chr(i+ord('A')))

if len(odd) >= 2:
    print("I'm Sorry Hansoo")
else:
    if odd != []:
        ans[len(name) // 2] = odd[0]
        name.remove(odd[0])

    name.sort()

    for i in range(len(name)//2):
        ans[i] = name.pop(0)
        ans[-1*i-1] = name.pop(0)
    print(''.join(ans))