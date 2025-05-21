t = int(input())

def backtrack(start, path, currentSum):
    global answer
    if currentSum == k and path:
        answer += 1
    
    for i in range(start, n):
        path.append(a[i])
        backtrack(i + 1, path, currentSum + a[i])
        path.pop()

for tc in range(1, t + 1):
    n, k = map(int, input().split())
    a = list(map(int, input().split()))
    answer = 0
    
    backtrack(0, [], 0)
    print(f'#{tc} {answer}')