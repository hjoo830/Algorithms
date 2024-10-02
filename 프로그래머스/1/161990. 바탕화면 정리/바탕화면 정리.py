def solution(wallpaper):
    grid = list(map(list, wallpaper))
    
    minRow = len(wallpaper)
    minCol = len(wallpaper[0])
    maxRow = 0
    maxCol = 0
    
    for i in range(len(grid)):
        for j in range(len(grid[i])):
            if grid[i][j] == '#':
                row = i 
                col = j
                if minRow > i:
                    minRow = i
                if minCol > j:
                    minCol = j
                if maxRow < i:
                    maxRow = i
                if maxCol < j:
                    maxCol = j
                    
    return [minRow, minCol, maxRow + 1, maxCol + 1]