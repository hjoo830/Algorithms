import sys, itertools
input = sys.stdin.readline

while True:
  nums = list(map(int, input().split()))
  if nums == [0]:
    break
  k = nums[0]
  nums = nums[1:]

  results = list(itertools.combinations(nums, 6))
  for result in results:
    for r in result:
      print(r, end=' ')
    print()
  print()