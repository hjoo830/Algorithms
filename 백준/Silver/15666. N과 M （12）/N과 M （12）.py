import sys

input = sys.stdin.readline

n, m = map(int, input().split())
nums = sorted(map(int, input().split()))
result = []

def backtrack(s, path):
  if len(path) == m:
    result.append(tuple(path))
    return

  for i in range(s, len(nums)):
    path.append(nums[i])
    backtrack(i, path)
    path.pop()

backtrack(0, [])

result = sorted(set(result))

for r in result:
  print(*r)