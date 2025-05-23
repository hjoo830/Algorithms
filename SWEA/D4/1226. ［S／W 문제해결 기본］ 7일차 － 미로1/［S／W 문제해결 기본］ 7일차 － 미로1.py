from collections import deque

for _ in range(1, 11):
    tc = int(input())
    maze = []
    for _ in range(16):
        row = list(map(int, input()))
        maze.append(row)

    for r in range(16):
        for c in range(16):
            if maze[r][c] == 2:
                startX = r
                startY = c
            elif maze[r][c] == 3:
                endX = r
                endY = c
                break

    v = [[False] * 16 for _ in range(16)]
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    def bfs (x, y):
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
                
                if 0 <= nx < 16 and 0 <= ny < 16:
                    if not v[nx][ny] and maze[nx][ny] == 0:
                        v[nx][ny] = True
                        q.append((nx, ny))
                        
        return 0
  
    answer = bfs(startX, startY)

    print(f'#{tc} {answer}')