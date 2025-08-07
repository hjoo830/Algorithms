import java.io.*;
import java.util.*;

public class Solution {	
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int left = 1;
    	int right = 2;
    	int down = 3;
    	
    	for (int tc = 1; tc <= 10; tc++) {
    		int t = Integer.parseInt(br.readLine());
    		int[][] grid = new int[100][100];
    		int answer = 0;
    		int flag = 0;
    		
    		for(int i = 0; i < 100; i++) {
    			StringTokenizer st = new StringTokenizer(br.readLine());
    			for(int j = 0; j < 100; j++) {
    				grid[i][j] = Integer.parseInt(st.nextToken());
    			}
    		}
    		
    		for (int i = 0; i < grid.length; i++) {
    			int x = i;
    			int y = 0;
    			flag = down;
    			if(grid[0][i] == 1) {
    				y++;
    				while(y < 100) {
    					if(grid[y][x] == 2) {
    						answer = i;
    						break;
    					}
    					if (flag == down) {
    						if (x - 1 >= 0 && grid[y][x - 1] == 1) {
    							x--;
    							flag = left;
    						} else if ( x + 1 < 100 && grid[y][x + 1] == 1) {
    							x++;
    							flag = right;
    						}else {
    							y++;
    							flag = down;
    						}
    					} else if (flag == right) {
    						while(x < 100 && grid[y][x] == 1) {
    							x++;
    						}
    						x--;
    						y++;
    						flag = down;
    					} else {
    						while (x >= 0 && grid[y][x] == 1) {
    							x--;
    						}
    						x++;
    						y++;
    						flag = down;
    					}
    				}
    			}
    		}
    		System.out.printf("#%d %d%n", tc, answer);
    	}
    }
}