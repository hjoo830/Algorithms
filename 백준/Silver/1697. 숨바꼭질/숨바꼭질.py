def bfs(s, e):
    q=[]
    v=[0]*200001

    q.append(s)
    v[s]=1

    while q:
        # ch,ci,cj = q.pop(0) # deque 썼으니까 popleft로 바꿔줌
        c = q.pop(0)
        if c==e: # 목적지 도착
            return v[e]-1
        # 3방향(-1, +1, *2), 범위내(0<= <=200000), 미방문
        for n in (c-1, c+1, c*2):
            if 0<=n<=200000 and v[n]==0:
                q.append(n)
                v[n]=v[c]+1

N, K = map(int, input(). split()) # 수빈이와 동생의 위치 
answer=bfs(N, K)
print(answer)
