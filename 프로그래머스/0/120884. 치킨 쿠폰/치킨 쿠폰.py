def solution(chicken):
    answer = 0
    coupon=0
    while chicken>0:
        coupon+=chicken%10
        chicken//=10
        answer+=chicken
    while coupon//10:
        chicken=coupon//10
        answer+=chicken
        coupon%=10
    if chicken+coupon>=10:
        answer+=(chicken+coupon)//10
    return answer