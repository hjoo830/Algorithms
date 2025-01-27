import sys

input = sys.stdin.readline
string = input().strip()
croatia = ['c=', 'c-', 'dz=', 'd-', 'lj', 'nj', 's=', 'z=']

for c in croatia:
  string = string.replace(c, '@')
print(len(string))  