def is_prime(num):
    if num == 1:
        return False
    for n in range(2, num):
        if num % n == 0:
            return False
    return True


N = int(input())
arr = list(map(int, input().split()))

ans = 0
for num in arr:
    if is_prime(num):
        ans += 1

print(ans)