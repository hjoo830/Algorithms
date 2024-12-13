import sys

input = sys.stdin.readline
n = int(input())
user = []
for i in range(n):
  age, name = input().split()
  user.append((int(age), i, name))

user.sort(key = lambda x : (x[0], x[1]))

for u in user:
  print(u[0], u[2])