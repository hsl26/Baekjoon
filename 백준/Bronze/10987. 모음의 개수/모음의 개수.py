word = list(input())

cnt = 0
aeiou = ['a', 'e', 'i', 'o', 'u']
for w in word:
    if w in aeiou:
        cnt += 1

print(cnt)