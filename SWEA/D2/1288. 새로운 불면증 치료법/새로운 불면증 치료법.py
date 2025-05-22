t = int(input())
for tc in range(1, t + 1):
    n = int(input())
    i = 0
    nums = set()
    
    while len(nums) < 10:
        i += 1
        for num in str(i * n):
            nums.add(num)
            
    print(f'#{tc} {i*n}')