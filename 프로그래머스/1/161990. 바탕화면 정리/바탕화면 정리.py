def solution(wallpaper):
    grid = list(map(list, wallpaper))
    r = []
    c = []
    
    for i in range(len(grid)):
        for j in range(len(grid[i])):
            if grid[i][j] == '#':
                r.append(i) 
                c.append(j)
                    
    return [min(r), min(c), max(r) + 1, max(c) + 1]