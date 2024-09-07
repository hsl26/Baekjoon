A, B = map(str, input().split())

A_copy = A[2] + A[1] + A[0]
B_copy = B[2] + B[1] + B[0]

print(max(int(A_copy), int(B_copy)))