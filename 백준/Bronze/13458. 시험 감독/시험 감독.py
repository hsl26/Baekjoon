N = int(input())
A = list(map(int, input().split()))
B, C = map(int, input().split())

total_viewer = 0
for a in A:
    current_viewer = 1
    if a > B:
        if (a - B) / C > (a - B) // C:
            current_viewer += (a - B) // C + 1
        else:
            current_viewer += (a - B) // C

    total_viewer += current_viewer

print(total_viewer)