import sys
input = sys.stdin.readline

n = int(input())
company = set()
for i in range(n):
  name, record = input().split()
  if record == 'enter':
    company.add(name)
  elif name in company:
    company.discard(name)

for person in sorted(company, reverse=True):
   print(person)