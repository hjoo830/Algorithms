import sys

input = sys.stdin.readline

n, s = map(int, input().split())
nums = sorted(map(int, input().split()))
count = 0

def backtrack(start, path, currentSum):
  global count
  if currentSum == s and path:
    count += 1

  for i in range(start, n):
    path.append(nums[i])
    backtrack(i + 1, path, currentSum + nums[i])
    path.pop()

backtrack(0, [], 0)
print(count)