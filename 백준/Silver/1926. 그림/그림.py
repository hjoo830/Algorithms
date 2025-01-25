import sys
from collections import deque

def bfs(graph, v, start, n, m):
  q = deque([start])
  dx = [-1, 1, 0, 0]
  dy = [0, 0, -1, 1]
  v[start[0]][start[1]] = 1
  size = 1

  while q:
    y, x = q.popleft()
    for i in range(4):
      ny = y + dy[i]
      nx = x + dx[i]
      if 0 <= ny < n and 0 <= nx < m:
        if graph[ny][nx] == 1 and v[ny][nx] == 0:
          v[ny][nx] = 1
          q.append((ny, nx))
          size += 1
  return size

input = sys.stdin.readline
n, m = map(int, input().split())
location = []
for _ in range(n):
  row = list(map(int, input().split()))
  location.append(row)

v = [[0 for _ in range(m)] for _ in range(n)]
count = 0
maxSize = 0

for i in range(n):
  for j in range(m):
    if location[i][j] == 1 and v[i][j] == 0:
      size = bfs(location, v, (i, j), n, m)
      maxSize = max(maxSize, size)
      count += 1

print(count)
print(maxSize)