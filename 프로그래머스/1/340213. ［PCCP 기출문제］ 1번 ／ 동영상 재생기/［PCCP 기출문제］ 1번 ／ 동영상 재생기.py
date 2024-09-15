def solution(video_len, pos, op_start, op_end, commands):
    lenMin, lenSec = map(int, video_len.split(':'))
    min, sec = map(int, pos.split(':'))
    startMin, startSec = map(int, op_start.split(':'))
    endMin, endSec = map(int, op_end.split(':'))
    
    for command in commands:
        if (min * 60 + sec) >= (startMin * 60 + startSec) and (min * 60 + sec) <= (endMin * 60 + endSec):
                min = endMin
                sec = endSec
                
        if command == 'prev':
            sec -= 10
        elif command == 'next':
            sec += 10
        
        if sec < 0:
            if min > 0: 
                min -= 1
                sec += 60
            else:
                min = 0
                sec = 0
                
        if sec >= 60:
            min += 1
            sec -= 60
            
        if (min * 60 + sec) >= (lenMin * 60 + lenSec):
            min = lenMin
            sec = lenSec
                
    if (min * 60 + sec) >= (startMin * 60 + startSec) and (min * 60 + sec) <= (endMin * 60 + endSec):
        min = endMin
        sec = endSec
            
    if min < 10 :
        min = '0' + str(min)
    if sec < 10 :
        sec = '0' + str(sec)

    return str(min) + ':' + str(sec)