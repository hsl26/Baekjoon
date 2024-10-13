N, M = map(int, input().split())
arr = list(map(int, input().split()))

q = [i for i in range(1, N+1)]

ans = 0
idx = 0
while arr:
    num_idx = q.index(arr[0])
    len_q = len(q)
    
    idx %= len_q
    
    if arr[0] == q[idx]:
        q.pop(idx)
        arr.pop(0)
        continue
        
    sub = (num_idx - idx)
    ans = ans + min(sub%len_q, (len_q-sub)%len_q)
    idx = num_idx

print(ans)