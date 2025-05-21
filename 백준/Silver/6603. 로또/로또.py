import sys

input = sys.stdin.readline

def backtrack(s, start, path):
  if len(path) == 6:
    print(*path)
    return
  
  for i in range(start, k):
    path.append(s[i])
    backtrack(s, i + 1, path)
    path.pop()

while True:
  nums = list(map(int, input().split()))
  k = nums[0]
  
  if k == 0:
    break

  s = nums[1:]
  s.sort()
  backtrack(s, 0, [])
  print()