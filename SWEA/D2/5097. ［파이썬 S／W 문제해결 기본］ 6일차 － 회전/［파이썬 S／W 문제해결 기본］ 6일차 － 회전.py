from collections import deque

T = int(input())
for tc in range(1, T + 1):
    n, m = map(int, input().split())
    nums = list(map(int, input().split()))
    dq = deque(nums)
    dq.rotate(-m)
    print(f'#{tc} {dq[0]}')