import sys

input = sys.stdin.readline
n = int(input())
goodWord = 0

for _ in range(n):
  count = 0
  stack = []
  word = input().strip()

  for w in word:
    if not stack:
      stack.append(w)
    else:
      top = stack.pop()
      if top == w:
        count += 1
      else:
        stack.append(top)
        stack.append(w)

  if len(word) / 2 == count:
    goodWord += 1

print(goodWord)