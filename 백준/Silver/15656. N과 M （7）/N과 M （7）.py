import sys

input = sys.stdin.readline

n, m = map(int, input().split())
nums = list(map(int, input().split()))
nums.sort()

def backtrack(path):
  if len(path) == m:
    print(*path)
    return

  for i in range(len(nums)):
    path.append(nums[i])
    backtrack(path)
    path.pop()

backtrack([])