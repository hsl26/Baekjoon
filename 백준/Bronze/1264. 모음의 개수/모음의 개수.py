word_list = ['a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U']

while True:
    cnt = 0
    str = input()
    if str == '#':
        break
    for c in str:
        if c in word_list:
            cnt += 1
    print(cnt)