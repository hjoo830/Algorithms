import sys, math

input = sys.stdin.readline
N = input().strip()
dic = {'0': 0, '1': 0, '2': 0, '3': 0, '4': 0, '5': 0, '6': 0, '7': 0, '8': 0, '9': 0}
maxNum = 0

for i in N:
  dic[i] += 1

for key in dic:
  if maxNum < dic[key]:
    if key == '6' or key == '9':
      maxNum = math.ceil((dic['6'] + dic['9']) / 2)
    else:
      maxNum = dic[key]
print(maxNum)