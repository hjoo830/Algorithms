T = int(input())
for test_case in range(1, T + 1):
    p, q, r, s, w = map(int, input().split())
    aCost = w * p
    if w <= r:
      bCost = q
    else:
      bCost = q + (w-r) * s
    
    answer = min(aCost, bCost)
    print(f'#{test_case} {answer}')