def getConstructor(n):
  num = n
  while (n != 0):
    num += n % 10
    n //= 10
  return num
  
selfNums = set()
for i in range(1, 10001):
  constructor = getConstructor(i)
  if constructor <= 10000:
    selfNums.add(constructor)
for i in range(1, 10001):
  if i not in selfNums:
    print(i)