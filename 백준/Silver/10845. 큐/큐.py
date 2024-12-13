import sys
from collections import deque

input = sys.stdin.readline
n = int(input())
dq = deque()

for _ in range(n):
  command = input().split()

  if command[0] == 'push':
    dq.appendleft(command[1])

  elif command[0] == 'pop':
    if dq:
      num = dq.pop()
      print(num)
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
      num = dq.pop()
      print(num)
      dq.append(num)
    else:
      print(-1)
  
  elif command[0] == 'back':
    if dq:
      num = dq.popleft()
      print(num)
      dq.appendleft(num)
    else:
      print(-1)