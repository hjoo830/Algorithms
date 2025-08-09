from collections import deque
def bfs(si, sj, v):
    q=deque()

    q.append((si,sj))
    v[si][sj]=1

    while q:
        ci,cj = q.popleft()
        # 4방향, 미방문, >0(빙산이 있는 곳)
        for di,dj in ((1,0),(-1,0),(0,1),(0,-1)):
            ni,nj=ci+di, cj+dj
            if v[ni][nj]==0 and arr[ni][nj]>0:
                q.append((ni,nj))
                v[ni][nj]=1

def solve(): # 1년씩 증가시켜 보면서 언제 두 덩어리가 되는지
    for year in range(1, 900000):
        # 4방향의 0 개수 세기
        zero_count=[[0]*M for _ in range(N)]
        for i in range(1, N-1):
            for j in range(1, M-1):
                if arr[i][j]==0: # 바다 부분이면 넘어가고
                    continue
                for di,dj in ((1,0),(-1,0),(0,1),(0,-1)): # 빙산 부분이면 4방향
                    ni,nj=i+di, j+dj #ni,nj는 주변(4방향)의 좌표
                    if arr[ni][nj]==0: # 주변이 0이면 
                        zero_count[i][j]+=1 # 0 개수 추가
                    
        # 높이 줄이기
        for i in range(1, N-1):
            for j in range(1, M-1):
                if zero_count[i][j]>0: # 해당 칸 주변 0 개수가 존재하면
                    arr[i][j]=max(0, arr[i][j]-zero_count[i][j]) # 그 칸의 빙산의 높이-0개수. 음수면 0으로
        
        # 빙산 덩어리 개수 세기
        v=[[0]*M for _ in range(N)]
        count=0
        for i in range(1, N-1):
            for j in range(1, M-1):
                if v[i][j]==0 and arr[i][j]>0: # 미방문, 빙산인 칸이면
                    bfs(i, j, v)
                    count+=1 # 덩어리 개수 1 증가
                    if count>1 : # 두덩어리 이상이면
                        return year # 몇년후인지 반환
        if count==0: # 덩어리 개수 0이면 
            return 0
    return -1 # 여기까지 올 일 없지만

N, M=map(int, input().split())
arr=[list(map(int, input().split())) for _ in range(N)] # 띄어쓰기로 구분된 2차원 배열 입력받기
answer=solve()
print(answer)