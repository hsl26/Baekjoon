two = str(input())
if len(two) % 3 != 0:
    two = '0'*(3 - len(two) % 3) + two

arr = []
for i in range(len(two), 0, -3):
    tmp = 0
    for idx, t in enumerate(two[i-3:i]):
        tmp += int(t)*(2**(2-idx))
    arr.append(str(tmp))

arr.reverse()
print(int(''.join(arr)))