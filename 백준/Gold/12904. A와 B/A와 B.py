S = list(input())
T = list(input())

# 맨 뒤가 A면 pop
# 맨 뒤가 B면 pop 후 문자열 뒤집기
ans = 0
while T:
    last = T.pop()
    if last == 'B':
        T.reverse()
    if T == S:
        ans = 1

print(ans)