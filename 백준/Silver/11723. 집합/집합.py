import sys

input = sys.stdin.readline
m = int(input())
s = set()

for _ in range(m):
  operation = input().strip().split(" ")
  op = operation[0]
  if len(operation) == 2:
    n = int(operation[1])
    if op == "add":
      s.add(n)
    elif op == "remove":
      s.discard(n)
    elif op == "check":
      print(1 if n in s else 0)
    elif op == "toggle":
      if n in s:
        s.discard(n)
      else:
        s.add(n)
  else:
    if op == "all":
      s = set(range(1, 21))
    elif op == "empty":
      s = set()