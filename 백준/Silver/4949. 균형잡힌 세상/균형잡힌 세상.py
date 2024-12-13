import sys
input = sys.stdin.readline

def isVPS(ps):
  stack = []
  for p in ps:
    if not stack and p == ')' or not stack and p == ']':
      return 'no'
    if p == '(' or p == '[':
      stack.append(p)
    if p == ')':
      top = stack.pop()
      if top != '(':
        return 'no'
    if p == ']':
      top = stack.pop()
      if top != '[':
        return 'no'
      
  if stack:
    return 'no'
  else:
    return 'yes'

while True:
  inputString = input().rstrip()
  
  if inputString == '.':
    break
  
  ps = [s for s in inputString if s in '()[]']
  print(isVPS(ps))