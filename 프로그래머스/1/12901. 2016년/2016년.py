def solution(a, b):
    weekday=['THU','FRI','SAT','SUN','MON','TUE','WED']
    day=0
    for month in range(1, 13):
        if month==a:
            day+=b
            break
        else:
            if month==1 or month==3 or month==5 or month==7 or month==8 or month==10 or month==12:
                day+=31
            elif month==2:
                day+=29
            else:
                day+=30
    return weekday[day%7]