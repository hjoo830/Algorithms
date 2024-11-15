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

d = [INF] * (n + 1)
prev = [-1] * (n + 1)

def dijkstra(s):
  q = []
  heapq.heappush(q, (0, s))
  d[s] = 0

  while q:
    dist, now = heapq.heappop(q)

    if d[now] < dist:
      continue
    
    for n, w in graph[now]:
      if d[n] > w + dist:
        d[n] = w + dist
        prev[n] = now
        heapq.heappush(q, (d[n], n))

dijkstra(start)
print(d[end])

path = []
c = end
while c != -1:
  path.append(c)
  c = prev[c]

path.reverse()
print(len(path))
print(*path)