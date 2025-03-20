def solution(schedules, timelogs, startday):
    answer = len(schedules)
    saveTimes = []
    
    for sc in schedules:
        hour = sc // 100
        minute = sc % 100
        
        if (minute + 10 >= 60):
            saveM = minute + 10 - 60
            saveH = hour + 1
        else:
            saveM = minute + 10
            saveH = hour
        saveTimes.append(saveH * 100 + saveM)
    
    for i in range(len(timelogs)):
        for day in range(startday, startday + 7):
            if (day % 7 == 6) or (day % 7 == 0):
                continue
            if saveTimes[i] < timelogs[i][day - startday]:
                answer -= 1
                break
        
    return answer