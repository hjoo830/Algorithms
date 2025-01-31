import sys

input = sys.stdin.readline
n, m = map(int, input().split())
arr = []

for i in range(n):
  row = list(map(int, input().split()))
  arr.append(row)

k = int(input())
for _ in range(k):
  arrSum = 0
  i, j, x, y = map(int, input().split())
  for r in range(i - 1, x):  
    arrSum += sum(arr[r][j - 1:y])
  print(arrSum)