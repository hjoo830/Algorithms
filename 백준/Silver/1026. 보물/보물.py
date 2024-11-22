import sys

input = sys.stdin.readline
n = int(input())
arrA = list(map(int, input().split()))
arrB = list(map(int, input().split()))

arrA.sort()
arrB.sort(reverse = True)

s = 0
for i in range(n):
  s += (arrA[i] * arrB[i])
print(s)