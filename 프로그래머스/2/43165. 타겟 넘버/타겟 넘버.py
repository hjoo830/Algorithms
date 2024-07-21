def solution(numbers, target):
    def dfs(n, sum):
        if n==len(numbers):
            if sum==target: return 1
            else: return 0
        add=dfs(n+1, sum+numbers[n])
        sub=dfs(n+1, sum-numbers[n])
        return add+sub
    return dfs(0,0)