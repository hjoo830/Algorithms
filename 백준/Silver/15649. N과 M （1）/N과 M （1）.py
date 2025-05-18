import sys

input = sys.stdin.readline

n, m = map(int, input().split())
v = [False] * (n + 1)

def backtrack(path):
  if len(path) == m:
    print(*path)
    return
  
  for i in range(1, n + 1):
    if not v[i]:
      v[i] = True
      path.append(i)
      backtrack(path)
      path.pop()
      v[i] = False

backtrack([])