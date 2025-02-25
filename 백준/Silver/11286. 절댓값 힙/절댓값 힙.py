import sys
import heapq
input = sys.stdin.readline

N = int(input())

heap_p = []
heap_m = []

for _ in range(N):
    x = int(input())
    if x == 0:
        if len(heap_m) == 0 and len(heap_p) == 0:
            print(0)
        else:
            if len(heap_m) != 0 and len(heap_p) != 0:
                if heap_m[0] <= heap_p[0]:
                    print(-heapq.heappop(heap_m))
                else:
                    print(heapq.heappop(heap_p))
            else:
                if len(heap_m) == 0:
                    print(heapq.heappop(heap_p))
                else:
                    print(-heapq.heappop(heap_m))
    else:
        if x < 0:
            heapq.heappush(heap_m, -x)
        else:
            heapq.heappush(heap_p, x)
        