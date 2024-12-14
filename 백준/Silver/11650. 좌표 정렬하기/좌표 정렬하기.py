import sys

input = sys.stdin.readline
n = int(input())
points = []

for i in range(n):
  x, y = map(int, input().split())
  points.append((x, y))

points.sort(key = lambda x : (x[0], x[1]))

for p in points:
  print(p[0], p[1])