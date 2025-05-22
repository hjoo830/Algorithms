def solution(elements):
    circle = elements + elements
    result = set()
    
    for i in range(len(elements)):
        result.add(elements[i])
    
    for size in range(1, len(elements) + 1):
        for start in range(len(elements)):
            result.add(sum(circle[start : start + size]))
            
    return len(result)
