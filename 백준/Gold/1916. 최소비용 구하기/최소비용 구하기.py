import sys
import heapq
input = sys.stdin.readline

N = int(input())
M = int(input())
INF = 100000*100000+1
distance = [INF for _ in range(N+1)]
graph = [[] for _ in range(N+1)]

for _ in range(M):
    u, v, w = map(int, input().split())
    graph[u].append((v,w))
    
start, end = map(int, input().split())

def dijkstra(start):
    q = []
    heapq.heappush(q, (0, start))
    distance[start] = 0
    
    while q:
        dist, now = heapq.heappop(q)
        if distance[now] < dist:
            continue
        for i in graph[now]:
            cost = dist + i[1]
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))
    
dijkstra(start)
print(distance[end])