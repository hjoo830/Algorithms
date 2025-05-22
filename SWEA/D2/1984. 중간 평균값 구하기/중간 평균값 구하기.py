t = int(input())
for tc in range(1, t + 1):
    nums = sorted(map(int, input().split()))
    nums = nums[1:9]
    answer = round(sum(nums) / 8)
    print(f'#{tc} {answer}')