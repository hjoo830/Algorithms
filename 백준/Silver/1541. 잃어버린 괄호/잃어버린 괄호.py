import sys, re

input = sys.stdin.readline
expression = input()
arr = re.findall(r"\d+|[+-]", expression)

minusIndex = []
for i in range(len(arr)):
  if arr[i] == '-':
    minusIndex.append(i)

if minusIndex:
  minusSum = 0
  for i in range(len(minusIndex)-1):
    minusSum += sum(map(int, (arr[minusIndex[i]+1:minusIndex[i+1]:2])))
  minusSum += sum(map(int, (arr[minusIndex[-1]+1::2])))

  result = sum(map(int, (arr[:minusIndex[0]:2])))
  result -= minusSum
  print(result)
else:
  print(sum(map(int, (arr[::2]))))