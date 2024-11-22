import sys

input = sys.stdin.readline
n = int(input())
nums = []
for _ in range(n):
  num = int(input())
  nums.append(num)

print(round(sum(nums) / len(nums)))
nums.sort()
print(nums[int(len(nums) / 2)])

numCount = {}
for num in nums:
  if not num in numCount:
    numCount[num] = 1
  else:
    numCount[num] += 1
numCountList = sorted(numCount.items(), key = lambda x : x[1], reverse = True)

frequency = numCountList[0][1]
mode = numCountList[0][0]
modeList = []

for num in numCountList:
  if num[1] == frequency:
    modeList.append(num[0])

modeList.sort()
if len(modeList) == 1:
  print(modeList[0])
else: 
  print(modeList[1])

print(max(nums) - min(nums))