a, b = map(int, input().split())

# Please write your code here.
def is_prime(num):
    if num == 1: return False
    for n in range(2, num//2+1):
        if num%n == 0:
            return False
    return True

result = 0
for n in range(a, b+1):
    if is_prime(n):
        result += n

print(result)