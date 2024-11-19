import sys

input = sys.stdin.readline
n = int(input())
score = [0] * n
for i in range(n):
  score[i] = int(input())

if n == 1:
    print(score[0])
    exit()

dp = [[0, 0, 0] for _ in range(n)]

dp[0][1] = score[0]
dp[0][2] = score[0]
dp[1][1] = score[1]
dp[1][2] = score[0] + score[1]

for i in range(2, n):
  dp[i][1] = max(dp[i - 2][1], dp[i - 2][2]) + score[i]
  dp[i][2] = dp[i - 1][1] + score[i]

print(max(dp[n - 1][1], dp[n - 1][2]))
