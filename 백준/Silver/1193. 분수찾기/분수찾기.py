import sys

input = sys.stdin.readline
x = int(input())
group = 1
total = 0

while total + group < x:
  total += group
  group += 1

position = x - total

if group % 2 == 1: # 대각선 위로
  row = group - position + 1
  col = position

else: # 대각선 아래로
  row = position
  col = group - position + 1

print(f"{row}/{col}")