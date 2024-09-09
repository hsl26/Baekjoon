N, M = map(int, input().split())
reverse_com = [list(map(int, input().split())) for _ in range(M)]

box = []
for i in range(1, N+1):
    box.append(str(i))


def reverse(arr):
    reverse_arr = ["0" for _ in range(len(arr))]

    for i in range(len(arr)):
        reverse_arr[len(arr)-1-i] = arr[i]

    return reverse_arr


for i, j in reverse_com:
    new_arr = reverse(box[i-1:j])
    for b in range(len(new_arr)):
        box[b+i-1] = new_arr[b]

print(" ".join(box))