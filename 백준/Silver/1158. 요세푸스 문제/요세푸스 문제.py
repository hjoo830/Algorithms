import sys

input = sys.stdin.readline

n, k = map(int, input().split())
people = []
result = []
targetIdx = 0

for i in range(1, n + 1):
  people.append(i)

while (len(result) < n):
  targetIdx = (targetIdx + k - 1) % len(people)

  result.append(people[targetIdx])
  del people[targetIdx]
  
print(f"<{', '.join(map(str, result))}>")