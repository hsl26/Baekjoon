N = int(input())

def is_han(n):
    if n < 100:
        return True
    if n == 1000:
        return False
    arr = [n//100, (n%100)//10, n%10]
    sub = [arr[1]-arr[0], arr[2]-arr[1]]
    if sub[0] == sub[-1]:
        return True
    return False


ans = 0
for n in range(1, N+1):
    if is_han(n):
        ans += 1

print(ans)