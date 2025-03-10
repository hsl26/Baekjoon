import sys 
import heapq
input = sys.stdin.readline

N, M, X = map(int, input().split())

INF = 10000*1000+1
distance = [INF for _ in range(N+1)]
graph = [[] for _ in range(N+1)]
    
for _ in range(M):
    start, end, time = map(int, input().split())
    graph[start].append((end, time))
   
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
       
max_time = 0
for student in range(1, N+1):
    time = 0
    distance = [INF for _ in range(N+1)]
    dijkstra(student)
    time += distance[X]
    distance = [INF for _ in range(N+1)]
    dijkstra(X)
    time += distance[student]
    max_time = max(max_time, time)
    
print(max_time)