import sys

input = sys.stdin.readline
gradeDict = {'A+': 4.5, 'A0': 4.0, 'B+': 3.5, 'B0': 3.0, 'C+': 2.5, 'C0': 2.0, 'D+': 1.5, 'D0': 1.0, 'F': 0}
gradeSum = 0
creditSum = 0
for _ in range(20):
  subject, credit, grade = input().split()
  credit = int(credit[0])
  if grade == 'P':
    continue

  gradeSum += credit * gradeDict[grade]
  creditSum += credit

print(gradeSum / creditSum)