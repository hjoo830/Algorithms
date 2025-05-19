import sys

input = sys.stdin.readline

n, m = map(int, input().split())

def backtrack(path):
  if len(path) == m:
    print(*path)
    return
  
  for i in range(1, n + 1):
    path.append(i)
    backtrack(path)
    path.pop()

backtrack([])