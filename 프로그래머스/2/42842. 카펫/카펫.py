def solution(brown, yellow):
    # brown=2*w+2(h-2)
    # yellow=(w-2)*(h-2)

    for w in range(3, 2500):
        for h in range(3, 2500):
            if yellow == (w - 2) * (h - 2) and brown == 2 * w + 2 * (h - 2):
                return [max(w,h),min(w,h)]