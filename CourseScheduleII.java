/*
There are a total of n courses you have to take, labeled from 0 to n - 1.
Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.
There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.
For example:
2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1]
4, [[1,0],[2,0],[3,1],[3,2]]
There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. So one correct course order is [0,1,2,3]. Another correct ordering is[0,2,1,3].
Note:
The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
*/

public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();                    
        for (int i = 0; i < numCourses; i++) 
        	adj.add(new ArrayList<Integer>());                         // from the index 0 to n, store new ArrayList<Integer>
        for (int[] edge : prerequisites) {                        
        	adj.get(edge[1]).add(edge[0]);                             // form AdjList                                            
        }
        int[] visited = new int[numCourses];
        LinkedList<Integer> topoSeq = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
        	if (visited[i] == 0 && !DFS(topoSeq, adj, visited, i))     // DFS, successful DFS, add elements to res; otherwise return {0}
        		return new int[0];
        }
        int[] res = new int[topoSeq.size()];
        for (int i = 0; i < res.length; i++)                        
        	res[i] = topoSeq.get(i);
        return res;
    }
    private boolean DFS(LinkedList<Integer> topoSeq, List<List<Integer>> adj, int[] visited, int cur) {
    	visited[cur] = 1;
    	for (int i : adj.get(cur)) {
    		if (visited[i] == 1 || (visited[i] == 0 && !DFS(topoSeq, adj, visited, i)))
    			return false;
    	}
    	topoSeq.addFirst(cur);                                         // addFirst, reverse the elements
    	visited[cur] = 2;
    	return true;
    }
    
    
    public int[] findOrder2(int numCourses, int[][] prerequisites) {
		List<List<Integer>> posts = new ArrayList<>();
		for (int i = 0; i < numCourses; i++) {
			posts.add(new ArrayList<>());
		}
		int[] preNums = new int[numCourses];                // int[] inDegree
		for (int i = 0; i < prerequisites.length; i++) {
			posts.get(prerequisites[i][1]).add(prerequisites[i][0]);
			preNums[prerequisites[i][0]]++;
		}
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < numCourses; i++) {
			if (preNums[i] == 0)
				q.add(i);
		}
		int[] res = new int[numCourses];
		int count = 0;
		while (!q.isEmpty()) {
			int x = q.poll();
			res[count] = x;
			for (int i : posts.get(x)) {
				if (--preNums[i] == 0)
					q.add(i);
			}
			count++;
		}
		if (count != numCourses)
			return new int[0];
		return res;
	}
}
