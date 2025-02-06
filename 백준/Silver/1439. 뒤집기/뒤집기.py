import sys

input = sys.stdin.readline
string = input().strip()
prev = string[0]
group = 1

for s in string:
  if s != prev:
    group += 1
    prev = s

print(group // 2)