def bfs(si, sj, h):
    q=[]

    q.append((si,sj))
    v[si][sj]=1

    while q:
        ci,cj = q.pop(0)
        # 4방향, 범위내, 미방문, 높이>h
        for di,dj in ((1,0),(-1,0),(0,1),(0,-1)):
            ni,nj=ci+di, cj+dj
            if 0<=ni<N and 0<=nj<N and v[ni][nj]==0 and arr[ni][nj]>h:
                q.append((ni,nj))
                v[ni][nj]=1

def solve(h): # 높이가 h일때 안전 영역 개수 리턴
    count=0
    for i in range(N):
        for j in range(N):
            if v[i][j]==0 and arr[i][j]>h: # 미방문, 안전 영역이면
                bfs(i, j, h)
                count+=1 # 안전 영역 개수 1 증가
    return count


N=int(input())
arr=[list(map(int, input().split())) for _ in range(N)] # 띄어쓰기로 구분된 2차원 배열 입력받기

answer=0
for h in range(101): # 높이 모든 경우 다 해보고, 
    v=[[0]*N for _ in range(N)]
    answer=max(answer, solve(h)) # 영역 개수 최대값
print(answer)