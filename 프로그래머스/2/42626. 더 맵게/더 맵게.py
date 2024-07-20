import heapq

def solution(scoville, K):
    answer = 0
    heapq.heapify(scoville)
    while scoville[0] < K and len(scoville)>1: # 모든 음식의 스코빌 지수가 K 이상일 때까지
        first = heapq.heappop(scoville)
        second = heapq.heappop(scoville)
        heapq.heappush(scoville, first+second*2)
        answer+=1
    if scoville[0] < K:
        return -1
    return answer