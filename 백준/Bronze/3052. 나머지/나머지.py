num = [int(input()) for _ in range(10)]
remainder = [num[i] % 42 for i in range(10)]

print(len(list(set(remainder))))