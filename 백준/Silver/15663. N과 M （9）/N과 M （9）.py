import sys

input = sys.stdin.readline

n, m = map(int, input().split())
nums = list(map(int, input().split()))
nums.sort()
result = []
v = [False] * (n + 1)

def backtrack(path):
  if len(path) == m:
    result.append(tuple(path))
    return

  for i in range(len(nums)):
    if not v[i]:
      v[i] = True
      path.append(nums[i])
      backtrack(path)
      v[i] = False
      path.pop()

backtrack([])

result = sorted(set(result))

for r in result:
  print(*r)