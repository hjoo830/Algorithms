import sys

input = sys.stdin.readline
n, m = map(int, input().split())
d = {}
reverse_d = {}

for i in range(1, n + 1):
  name = input().strip()
  d[name] = i
  reverse_d[i] = name

for _ in range(m):
  q = input().strip()
  if q.isdigit():
    print(reverse_d[int(q)])
  else:
    print(d[q])