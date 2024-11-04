import sys

input = sys.stdin.readline
t = int(input())

for _ in range(t):
  n = int(input())
  clothes = {}

  for _ in range(n):
    name, category = input().strip().split()
    if category not in clothes:
      clothes[category] = []
    clothes[category].append(name)

  count = 1
  for c in clothes.values():
    count *= (len(c) + 1)
  print(count - 1)