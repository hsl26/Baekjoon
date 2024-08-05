word = input()

for i in range(26):
    current = ord('a') + i
    print(word.count(chr(current)), end=" ")