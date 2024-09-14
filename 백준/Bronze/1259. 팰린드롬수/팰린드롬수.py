def palindrome(num):
    num = str(num)
    for i in range(len(num)//2):
        if num[i] != num[len(num)-1-i]:
            return False
    return True

while True:
    n = int(input())
    if n == 0:
        break

    if palindrome(n):
        print("yes")
    else:
        print("no")