import sys

input = sys.stdin.readline
n = int(input())
num = 0
count = 0

while True:
  num += 1
  if '666' in str(num):
    count += 1
  if count == n:
    break
print(num)