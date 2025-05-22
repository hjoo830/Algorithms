import sys

input = sys.stdin.readline

s = input().strip()
m = int(input())
left = []
right = []

for c in s:
  left.append(c)

for i in range(m):
  command = input().split()

  if command[0] == 'L' and left:
    c = left.pop()
    right.append(c)

  if command[0] == 'D' and right:
    c = right.pop()
    left.append(c)

  if command[0] == 'B' and left:
    left.pop()

  if command[0] == 'P':
    value = command[1]
    left.append(value)

right.reverse()
print(''.join(left + right))