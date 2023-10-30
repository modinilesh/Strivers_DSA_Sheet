package graph;

import java.util.ArrayList;

public class DepthFirstSearch {
	
public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        
        //ans List
        ArrayList<Integer> ans = new ArrayList<>();
        
        //visited array
        boolean[] visited = new boolean[V];
        
        //let's call DFS now
        dfs(0, adj, ans, visited);
/*        
        //if disconnected components are there
        for(int i=0; i<V; i++) {
        	if(visited[i] == false) {
        		dfs(i, adj, ans, visited);
        	}
        }
*/        
        
        return ans;
    }
    
    //Let's define DFS
    public void dfs(int V, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ans, boolean[] visited){
        
        visited[V] = true;
        ans.add(V);
        
        for(int nbrs : adj.get(V)){
            //not visited yet
            if(visited[nbrs] == false){
                dfs(nbrs, adj, ans, visited);
            }
        }
        
    }

}
