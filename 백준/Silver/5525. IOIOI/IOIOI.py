import sys

input = sys.stdin.readline
n = int(input())
m = int(input())
s = input()
count = 0

pn = 'I'
for _ in range(n):
  pn += 'OI'

for i in range(m - len(pn) + 1):
  if s[i:i + len(pn)] == pn:
    count += 1

print(count)