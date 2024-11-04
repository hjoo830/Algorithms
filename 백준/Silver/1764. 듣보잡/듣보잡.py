import sys

input = sys.stdin.readline
n, m = map(int, input().split(" "))
noHear = set()
noSee = set()

for _ in range(n):
  name = input().strip()
  noHear.add(name)

for _ in range(m):
  name = input().strip()
  noSee.add(name)

noHearNoSee = noHear.intersection(noSee)
noHearNoSee = sorted(list(noHearNoSee))

print(len(noHearNoSee))
for name in noHearNoSee:
  print(name)