import sys

input = sys.stdin.readline
n = int(input())
nums = set(map(int, input().split()))
m = int(input())
target = list(map(int, input().split()))

for t in target:
  if t in nums:
    print(1, end=' ')
  else:
    print(0, end=' ')