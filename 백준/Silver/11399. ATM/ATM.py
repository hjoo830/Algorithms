import sys

input = sys.stdin.readline
n = int(input())
p = list(map(int, input().split(" ")))
p.sort()
waitingSum = 0
waitingTime = 0
for time in p:
  waitingTime += time
  waitingSum += waitingTime
print(waitingSum)