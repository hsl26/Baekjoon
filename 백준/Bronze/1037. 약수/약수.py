N = int(input())
N_arr = list(map(int, input().split()))
N_arr.sort()

print(N_arr[0]*N_arr[-1])