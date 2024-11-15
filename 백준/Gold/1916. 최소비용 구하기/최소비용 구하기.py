import sys, heapq

input = sys.stdin.readline

n = int(input())
m = int(input())
INF = float('inf')
graph = [[] for _ in range(n + 1)]

for _ in range(m):
  u, v, w = map(int, input().split())
  graph[u].append((v, w))
start, end = map(int, input().split())

v = [0] * (n + 1)
d = [INF] * (n + 1)

def dijkstra(s):
  q = []
  heapq.heappush(q, (0, s))
  d[s] = 0

  while q:
    dist, now = heapq.heappop(q)

    if d[now] < dist:
      continue

    for i in graph[now]:
      if dist + i[1] < d[i[0]]:
        d[i[0]] = dist + i[1]
        heapq.heappush(q, (dist + i[1], i[0]))

dijkstra(start)
print(d[end])