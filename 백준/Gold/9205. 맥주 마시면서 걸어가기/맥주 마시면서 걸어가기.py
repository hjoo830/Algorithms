from collections import deque
def bfs(sj, si, ej, ei):
    q=deque()
    v=[0]*n

    q.append((sj,si))

    while q:
        cj,ci = q.popleft()
        if abs(cj-ej)+abs(ci-ei)<=1000: # 목적지 도달가능
            return 'happy'
        
        # 미방문 모든 편의점좌표: 범위내인지 체크
        for i in range(n):
            if v[i]==0:     # 미방문 편의점
                nj,ni = lst[i]
                if abs(cj-nj)+abs(ci-ni)<=1000: # 범위내
                    q.append((nj,ni))
                    v[i]=1
    return 'sad'

t=int(input())
for testCase in range(t):
    n=int(input())
    sj, si = map(int, input().split())
    lst = []

    for _ in range(n):
        tj, ti = map(int, input().split())
        lst.append((tj,ti))
    ej, ei = map(int, input().split())

    answer=bfs(sj,si,ej,ei)
    print(answer)