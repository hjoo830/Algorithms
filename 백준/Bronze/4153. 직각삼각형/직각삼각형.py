while True:
  triangle = input()
  if triangle == '0 0 0':
    break
  a, b, c = sorted(map(int, triangle.split(' ')))
  if a ** 2 + b ** 2 == c ** 2:
    print("right")
  else:
    print("wrong")