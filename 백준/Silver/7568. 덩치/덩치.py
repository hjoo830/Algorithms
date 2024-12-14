import sys

input = sys.stdin.readline
n = int(input())
size = []
result = []

for i in range(n):
  w, h = map(int, input().split())
  size.append((w, h))

for i in range(n):
  rank = 1
  w1, h1 = size[i]
  for j in range(n):
    w2, h2 = size[j]
    if w1 < w2 and h1 < h2:
      rank += 1
  result.append(rank)
print(*result)