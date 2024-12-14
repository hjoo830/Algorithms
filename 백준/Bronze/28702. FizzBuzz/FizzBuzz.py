import sys

input = sys.stdin.readline
str1 = input().strip()
str2 = input().strip()
str3 = input().strip()

def fizzBuzz(n):
  if n % 3 == 0 and n % 5 == 0:
    print('FizzBuzz')
  elif n % 3 == 0 and n % 5 != 0:
    print('Fizz')
  elif n % 3 != 0 and n % 5 == 0:
    print('Buzz')
  elif n % 3 != 0 and n % 5 != 0:
    print(n)
  
if str.isdigit(str1):
  fizzBuzz(int(str1) + 3)
elif str.isdigit(str2):
  fizzBuzz(int(str2) + 2)
elif str.isdigit(str3):
  fizzBuzz(int(str3) + 1)