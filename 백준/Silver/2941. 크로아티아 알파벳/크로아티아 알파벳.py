arr = ['c=', 'c-', 'dz=', 'd-', 'lj', 'nj', 's=', 'z=']
word = input()
word += '0'

ans = 0
while True:
    if len(word) == 1:
        break

    ans += 1
    if word[:2] in arr:
        word = word[2:]
    elif word[:3] in arr:
        word = word[3:]
    else:
        word = word[1:]

print(ans)