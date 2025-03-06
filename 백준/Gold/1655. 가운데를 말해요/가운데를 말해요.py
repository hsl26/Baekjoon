import heapq
import sys

input = sys.stdin.readline

N = int(input())

leftheap = []
rightheap = []

for i in range(1, N+1):
    num = int(input())

    if len(leftheap) == len(rightheap):
        heapq.heappush(leftheap, -num)
    else:
        heapq.heappush(rightheap, num)

    if rightheap and -leftheap[0] > rightheap[0]:
        l = -heapq.heappop(leftheap)
        r = heapq.heappop(rightheap)

        heapq.heappush(leftheap, -r)
        heapq.heappush(rightheap, l)

    print(-leftheap[0])