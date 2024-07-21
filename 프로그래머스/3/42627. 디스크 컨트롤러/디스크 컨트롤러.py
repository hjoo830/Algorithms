import heapq

def solution(jobs):
    answer = 0
    currentTime = 0
    startTime = -1
    waitingJobs = []
    count = 0
    
    print(jobs)
    while count < len(jobs):
        for i in range(len(jobs)):
            if jobs[i][0] <= currentTime and jobs[i][0] > startTime:
                heapq.heappush(waitingJobs, (jobs[i][1], jobs[i][0]))
        
        if len(waitingJobs) > 0:
            currentJob = heapq.heappop(waitingJobs)
            startTime = currentTime
            currentTime += currentJob[0]
            answer += (currentTime - currentJob[1])
            count += 1
        else:
            currentTime += 1
            
    return answer // len(jobs)