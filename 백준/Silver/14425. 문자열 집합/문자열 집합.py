import sys

input = sys.stdin.readline
n, m = map(int, input().split())
s = set()
count = 0

for _ in range(n):
  string = input().strip()
  s.add(string)

for _ in range(m):
  target = input().strip()
  if target in s:
    count += 1
    
print(count)