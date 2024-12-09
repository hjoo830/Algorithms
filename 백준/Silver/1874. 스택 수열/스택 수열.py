import sys

input = sys.stdin.readline
n = int(input())
stack = []
target = []
result = []
answer = []
idx = 0

for _ in range(n):
  num = int(input())
  target.append(num)

for i in range(1, n + 1):
  stack.append(i)
  answer.append('+')
  c = stack.pop()
  if c == target[idx]:
    answer.append('-')
    result.append(c)
    idx += 1
    while stack:
      if c > target[idx]:
        c = stack.pop()
        if c == target[idx]:
          answer.append('-')
          result.append(c)
          idx += 1
      else:
        break
  else:
    stack.append(i)

if result != target:
  print('NO')
else:
  print(*answer, sep='\n')