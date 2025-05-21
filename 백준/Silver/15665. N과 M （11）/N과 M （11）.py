import sys

input = sys.stdin.readline

n, m = map(int, input().split())
nums = sorted(map(int, input().split()))
result = []

def backtrack(path):
  if len(path) == m:
    result.append(tuple(path))
    return

  for i in range(len(nums)):
    path.append(nums[i])
    backtrack(path)
    path.pop()

backtrack([])

result = sorted(set(result))

for r in result:
  print(*r)