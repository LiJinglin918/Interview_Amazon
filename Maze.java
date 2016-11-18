/*
给个array,其中只有一格是9，其他格子是0或1，0表示此路不通，1表示可以走，判断从（0,0) 点开始上下左右移动能否找到这个是9的格子
*/
// http://blog.csdn.net/lycorislqy/article/details/49202651

import java.util.*;
public class Maze2 {
	public static void main(String[] args) {
		int[][] matrix = {{0}};
		if (new Maze2().bfs(matrix, 0, 0))
			System.out.println("true");
		else
			System.out.println("false");
	}
	public class Point {
		int x;
		int y;
		int value;
		Point(int x, int y, int value) {
			this.x = x;
			this.y = y;
			this.value = value;
		}
	}
	public boolean bfs(int[][] maze, int startx, int starty) {
		if (maze == null)
			return false;
		if (maze.length < 1 || maze[0].length < 1)
			return false;
		LinkedList<Point> que = new LinkedList<>();
		Point p1 = new Point(startx, starty, maze[startx][starty]);
		que.add(p1);
		
		int width = maze[0].length;
		int height = maze.length;
		p1 = que.poll();
		
		while (p1.value != 9) {
			int x = p1.x;
			int y = p1.y;
			maze[x][y] = -1;
			if ((x + 1) < height) {
				if (maze[x + 1][y] > 0) {
					Point p2 = new Point(x + 1, y, maze[x + 1][y]);
					que.add(p2);
				}
			}
			if ((x - 1) >= 0) {
				if (maze[x - 1][y] > 0) {
					Point p2 = new Point(x - 1, y, maze[x - 1][y]);
					que.add(p2);
				}
			}
			if ((y + 1) < width) {
				if (maze[x][y + 1] > 0) {
					Point p2 = new Point(x, (y + 1), maze[x][y + 1]);
					que.add(p2);
				}
			}
			if ((y - 1) >= 0) {
				if (maze[x][y - 1] > 0) {
					Point p2 = new Point(x, y - 1, maze[x][y - 1]);
					que.add(p2);
				}
			}
			if (que.isEmpty()) {
				break;
			}
			else {
				p1 = que.poll();
			}
		}
		if (p1.value == 9)
			return true;
		else
			return false;
	}
}
