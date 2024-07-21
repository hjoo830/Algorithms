def solution(numbers):
    answer = ''
    strList=list(map(str, numbers))
    strList.sort(key = lambda x: x*3, reverse=True)
    if strList[0]=='0': return '0'
    return answer.join(strList)