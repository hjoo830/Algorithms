import sys

input = sys.stdin.readline

n, m = map(int, input().split())
nums = sorted(map(int, input().split()))
result = []
v = [False] * (n + 1)

def backtrack(s, path):
  if len(path) == m:
    result.append(tuple(path))
    return

  for i in range(s, len(nums)):
    if not v[i]:
      v[i] = True
      path.append(nums[i])
      backtrack(i + 1, path)
      v[i] = False
      path.pop()

backtrack(0, [])

result = sorted(set(result))

for r in result:
  print(*r)