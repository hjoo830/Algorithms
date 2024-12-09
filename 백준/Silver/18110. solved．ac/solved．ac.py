import sys, math
def customRound(n):
  if n - math.floor(n) >= 0.5:
    return math.ceil(n)
  else:
    return math.floor(n)

input = sys.stdin.readline
n = int(input())
opinions = []
for i in range(n):
  opinion = int(input())
  opinions.append(opinion)
opinions.sort()

excludeNum = customRound(n * 0.15)
adjustedOpinions = opinions[excludeNum:n-excludeNum]
if len(adjustedOpinions) == 0:
  difficulty = 0
else:
  difficulty = customRound(sum(adjustedOpinions) / len(adjustedOpinions))
print(difficulty)