S = list(input())
ans = [''] * len(S)

tag = False
start = 0

def Reverse(s, e):
    arr = S[s:e]
    arr.reverse()
    for ni in range(s, e):
        ans[ni] = arr[ni - s]
    return

for i in range(len(S)):
    if S[i] == '<':
        tag = True
        Reverse(start, i)
        start = i + 1

    if S[i] == '>':
        tag = False
        ans[i] = S[i]
        start = i+1

    if tag:
        ans[i] = S[i]
        continue

    if S[i] == ' ':
        Reverse(start, i)
        ans[i] = ' '

        start = i+1

if ans[-1] == '':
    Reverse(start, len(S))


print(''.join(ans))