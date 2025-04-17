import sys

input = sys.stdin.readline

n, m = map(int, input().split())
q = []
colSums = []

for i in range(n):
  clap = list(map(int, input().split()))
  q.append(clap)
a = int(input())

for c in range(m):
  colSum = 0
  for r in range(n):
    colSum += q[r][c]
  colSums.append(colSum)

currentSum = sum(colSums[:a])
maxSum = currentSum

for i in range(m - a):
  currentSum += colSums[i + a] - colSums[i]
  maxSum = max(maxSum, currentSum)
print(maxSum)