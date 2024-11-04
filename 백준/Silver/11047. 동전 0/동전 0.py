import sys

input = sys.stdin.readline
n, k = map(int, input().split(" "))
a = []
for _ in range(n):
  a.append(int(input()))

a.sort(reverse = True)

count = 0
for i in a:
  if i > k:
    continue
  else:
    count += k//i
    k %= i

print(count)