import sys

input = sys.stdin.readline
n = int(input())
stack = []

for i in range(n):
  command = input().split()
  if command[0] == "push":
    stack.append(command[1])
  elif command[0] == "pop":
    if stack:
      top = stack.pop()
      print(top)
    else:
      print(-1)
  elif command[0] == "size":
    print(len(stack))
  elif command[0] == "empty":
    if stack:
      print(0)
    else: 
      print(1)
  elif command[0] == "top":
    if stack:
      top = stack.pop()
      print(top)
      stack.append(top)
    else:
      print(-1)