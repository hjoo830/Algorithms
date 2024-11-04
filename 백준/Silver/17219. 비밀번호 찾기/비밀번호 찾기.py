import sys

input = sys.stdin.readline
n, m = map(int, input().split(" "))
pwDict = {}
for _ in range(n):
  site, pw = input().strip().split(" ")
  pwDict[site] = pw

for _ in range(m):
  site = input().strip()
  print(pwDict[site])