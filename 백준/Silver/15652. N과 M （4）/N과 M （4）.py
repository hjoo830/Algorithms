import sys

input = sys.stdin.readline

n, m = map(int, input().split())

def backtrack(s, path):
  if len(path) == m:
    print(*path)
    return
  
  for i in range(s, n + 1):
    path.append(i)
    backtrack(i, path)
    path.pop()

backtrack(1, [])