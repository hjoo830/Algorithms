import sys

input = sys.stdin.readline
t = int(input())

def isVPS(ps):
  stack = []
  for p in ps:
    if not stack and p == ')':
      return 'NO'
    if p == '(':
      stack.append(p)
    if p == ')':
      stack.pop()
  if stack:
    return 'NO'
  else:
    return 'YES'

for _ in range(t):
  ps = list(input().strip())
  print(isVPS(ps))