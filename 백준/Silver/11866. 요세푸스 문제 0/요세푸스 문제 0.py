import sys
from collections import deque

input = sys.stdin.readline
n, k = map(int, input().split())
people = deque()
count = 0
result = []
for i in range(1, n + 1):
  people.append(i)

while len(people):
  count += 1
  if count == k:
    p = people.popleft()
    result.append(p)
    count = 0
  else:
    p = people.popleft()
    people.append(p)
    
print('<', end='')
print(*result, sep=', ', end='')
print('>')