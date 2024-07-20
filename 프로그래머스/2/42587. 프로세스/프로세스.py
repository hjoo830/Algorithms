from collections import deque

def solution(priorities, location):
    answer = 0
    q = deque([(priority, idx) for idx, priority in enumerate(priorities)])

    while q:
        current = q.popleft()

        if any(current[0] < item[0] for item in q):
            q.append(current)
        else:
            answer += 1
            if current[1] == location:
                return answer