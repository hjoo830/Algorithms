def solution(people, limit):
    answer = 0

    people.sort()
    l = 0
    r = len(people)-1

    while l <= r:
        if people[l] + people[r] > limit:
            answer += 1 # people[r] 혼자 보트 하나
            r -= 1
        else: 
            answer += 1
            r -= 1
            l += 1

    return answer