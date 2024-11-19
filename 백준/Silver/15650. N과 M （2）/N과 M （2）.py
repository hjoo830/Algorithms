import sys, itertools

input = sys.stdin.readline
n, m = map(int, input().split())

numArr = list(itertools.combinations(range(1, n + 1), m))
for item in numArr:
  for i in range(m):
    print(item[i], end=' ')
  print()