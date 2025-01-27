import sys

input = sys.stdin.readline
n = int(input())
count = 0

def isGroupWord(word):
  for w in word:
    if not w in arr:
      arr.append(w)
    elif arr[-1] != w:
      return False
    else:
      arr.append(w) 
  return True

for _ in range(n):
  arr = []
  word = input().strip()
  if isGroupWord(word):
    count += 1

print(count)