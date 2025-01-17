import sys

input = sys.stdin.readline
n = int(input())
nums =list(map(int, input().split()))

dp = [0] * (n + 1)
dp[0] = nums[0]
result = dp[0]

for i in range(1, n):
  dp[i] = max(nums[i], dp[i - 1] + nums[i])
  result = max(result, dp[i])
print(result)