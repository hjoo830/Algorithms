import sys
from collections import deque

def bfs(adj, s, n):
  distances = [float('inf')] * (n + 1)
  distances[s] = 0

  q = deque()
  q.append(s)

  while q:
    user = q.popleft()
    for neighbor in adj[user]:
      if distances[neighbor] == float('inf'):
        distances[neighbor] = distances[user] + 1
        q.append(neighbor)
  return sum(distances[1:])

input = sys.stdin.readline
n, m = map(int, input().split(" "))
adj = [[] for _ in range(n + 1)]

for _ in range(m):
  s, e = map(int, input().split(" "))
  adj[s].append(e)
  adj[e].append(s)

kevinBacon = [0] * (n + 1)
for i in range(1, n + 1):
  kevinBacon[i] = bfs(adj, i, n)

minKavinBacon = min(kevinBacon[1:])
minPerson = kevinBacon.index(minKavinBacon)
print(minPerson)