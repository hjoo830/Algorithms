import sys

input = sys.stdin.readline

n, m = map(int, input().split())
nums = list(map(int, input().split()))
nums.sort()

def backtrack(s, path):
  if len(path) == m:
    print(*path)
    return

  for i in range(s, len(nums)):
    path.append(nums[i])
    backtrack(i, path)
    path.pop()

backtrack(0, [])