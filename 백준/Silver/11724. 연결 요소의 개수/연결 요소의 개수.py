import sys
from collections import deque

def bfs(s):
  q = deque()
  q.append(s)
  v[s] = 1

  while q:
    c = q.popleft()
    for n in adj[c]:
      if v[n] == 0:
        q.append(n)
        v[n] = 1

input = sys.stdin.readline
n, m = map(int, input().split(" "))
adj = [[] for _ in range(n + 1)]

for i in range(m):
  s, e = map(int, input().split(" "))
  adj[s].append(e)
  adj[e].append(s)

v = [0] * (n + 1)
count = 0

for i in range(1, n + 1):
  if v[i] == 0:
    bfs(i)
    count += 1

print(count)