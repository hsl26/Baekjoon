word = list(input())

if len(word)%2 == 1:
    del word[len(word)//2]

def is_palindrome(w):
    for i in range(len(word)//2):
        if w[i] != w[len(word)-1-i]:
            return 0
    return 1

print(is_palindrome(word))