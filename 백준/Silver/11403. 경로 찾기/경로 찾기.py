import sys
from collections import deque

def bfs(adj, s, n):
  q = deque()
  q.append(s)
  v = [0] * n
  group = []
  
  while q:
    c = q.popleft()
    for nxt in adj[c]:
      if v[nxt] == 0:
        v[nxt] = 1
        q.append(nxt)
        group.append(nxt)
  return sorted(group)

input = sys.stdin.readline
n = int(input())
adj = [[] for _ in range(n)]

for i in range(n):
  row = list(map(int, input().split(" ")))
  for j in range(n):
    if row[j] == 1:
      adj[i].append(j)

groups = []
for i in range(n):
  group = bfs(adj, i, n)
  groups.append(group)

for i in range(n):
  g = groups[i]
  for j in range(n):
    if j in g:
      print("1", end=" ")
    else: 
      print("0", end=" ")
  print()