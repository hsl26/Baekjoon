rot = ord('a')
ROT = ord('A')

S = input()
for s in S:
    if s.isupper():
        num = (ord(s) + 13 - ROT) % 26
        print(chr(ROT+num), end='')
    elif s.islower():
        num = (ord(s) + 13 - rot) % 26
        print(chr(rot+num), end='')
    else:
        print(s, end='')