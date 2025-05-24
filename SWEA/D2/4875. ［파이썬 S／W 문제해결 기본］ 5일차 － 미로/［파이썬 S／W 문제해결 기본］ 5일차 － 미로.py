from collections import deque

T = int(input())
for tc in range(1, T + 1):
    n = int(input())
    maze = []
    for _ in range(n):
        row = list(map(int, input()))
        maze.append(row)

    for i in range(n):
        for j in range(n):
            if maze[i][j] == 2:
                startX = i
                startY = j
            elif maze[i][j] == 3:
                endX = i
                endY = j
            
    v = [[False] * n for _ in range(n)]
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    def bfs(x, y):
        q = deque()
        q.append((x, y))
        v[x][y] = True

        while q:
            cx, cy = q.popleft()

            for i in range(4):
                nx = cx + dx[i]
                ny = cy + dy[i]

                if nx == endX and ny == endY:
                    return 1
                
                if 0 <= nx < n and 0 <= ny < n:
                    if not v[nx][ny] and maze[nx][ny] == 0:
                        v[nx][ny] = True
                        q.append((nx, ny))
        return 0
    
    answer = bfs(startX, startY)
    print(f'#{tc} {answer}')