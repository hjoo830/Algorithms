import sys

input = sys.stdin.readline
s = input().strip()

result = []
word = []
tag = False

for c in s:
  if c == '<':
    if word:
      result.append(''.join(reversed(word)))
      word = []
    tag = True
    result.append(c)
  elif c == '>':
    tag = False
    result.append(c)
  elif tag:
    result.append(c)
  else:
    if c == ' ':
      result.append(''.join(reversed(word)))
      result.append(c)
      word = []
    else:
      word.append(c)

if word:
  result.append(''.join(reversed(word)))

print(''.join(result))