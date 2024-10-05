num_a, num_b = map(int, input().split())
A = list(map(int, input().split()))
B = list(map(int, input().split()))

both = len(A+B) - len(list(set(A+B)))

print(len(A)+len(B)-2*both)