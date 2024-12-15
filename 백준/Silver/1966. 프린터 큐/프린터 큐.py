import sys
from collections import deque

input = sys.stdin.readline
t = int(input())
for _ in range(t):
  n, m = map(int, input().split())
  priority = list(map(int, input().split()))
  q = deque()
  result = []

  for i in range(n):
    q.append((priority[i], i))

  while q:
    maxPriority = max(q)[0]
    p, idx = q.popleft()
    
    if p == maxPriority:
      result.append(idx)
    else:
      q.append((p, idx))
    
  print(result.index(m) + 1)