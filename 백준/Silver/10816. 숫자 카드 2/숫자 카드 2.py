import sys

input = sys.stdin.readline
n = int(input())
nums = list(map(int, input().split()))
m = int(input())
target = list(map(int, input().split()))

count = {}
for num in nums:
  if num in count:
    count[num] += 1
  else:
    count[num] = 1

for t in target:
  if t in count:
    print(count[t], end=' ')
  else:
    print(0, end=' ')