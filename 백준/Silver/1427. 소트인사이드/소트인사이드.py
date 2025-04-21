import sys

input = sys.stdin.readline

n = input().strip()
nArr = [num for num in n]
nArr.sort(reverse=True)
print(''.join(nArr))