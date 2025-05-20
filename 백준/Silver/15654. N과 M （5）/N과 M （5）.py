import sys

input = sys.stdin.readline

n, m = map(int, input().split())
nums = list(map(int, input().split()))
nums.sort()

v = [False] * (n + 1)

def backtrack(path):
  if len(path) == m:
    print(*path)
    return

  for i in range(len(nums)):
    if not v[i]:
      path.append(nums[i])
      v[i] = True
      backtrack(path)
      path.pop()
      v[i] = False

backtrack([])