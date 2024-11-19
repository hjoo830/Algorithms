import sys, itertools

input = sys.stdin.readline
n, m = map(int, input().split())
if m == 1:
  for i in range(1, n + 1):
    print(i)
  exit()

numArr = list(itertools.permutations(range(1, n + 1), m))
for item in numArr:
  for i in range(m):
    print(item[i], end=' ')
  print()