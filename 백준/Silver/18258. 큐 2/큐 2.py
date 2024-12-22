import sys
from collections import deque

input = sys.stdin.readline
n = int(input())
dq = deque()
for _ in range(n):
  command = input().split()
  if command[0] == 'push':
    dq.append(command[1])
  elif command[0] == 'pop':
    if dq:
      c = dq.popleft()
      print(c)
    else:
      print(-1)
  elif command[0] == 'size':
    print(len(dq))
  elif command[0] == 'empty':
    if dq:
      print(0)
    else:
      print(1)
  elif command[0] == 'front':
    if dq:
      c = dq.popleft()
      print(c)
      dq.appendleft(c)
    else:
      print(-1)
  elif command[0] == 'back':
    if dq:
      c = dq.pop()
      print(c)
      dq.append(c)
    else:
      print(-1)