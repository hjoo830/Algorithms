import sys

maxN = 40
zero = [0] * (maxN + 1)
one = [0] * (maxN + 1)

zero[0] = 1
one[1] = 1

for i in range(2, maxN + 1):
  zero[i] = zero[i - 1] + zero[i - 2]
  one[i] = one[i - 1] + one[i - 2]

input = sys.stdin.readline
t = int(input())
for i in range(t):
  n = int(input())
  print(zero[n], one[n])