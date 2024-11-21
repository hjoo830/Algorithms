import sys, heapq

input = sys.stdin.readline
n = int(input())
h = []
for i in range(n):
  x = int(input())
  if x == 0:
    if not h:
      print(0)
    else:
      print(heapq.heappop(h))

  else:
    heapq.heappush(h, x)