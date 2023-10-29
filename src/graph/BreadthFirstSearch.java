package graph;

import java.util.*;

public class BreadthFirstSearch {
	
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        boolean visited[] = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<>();
        
        //adding first element
        queue.add(0);
        visited[0] = true;
        ans.add(0);
        
        while(!queue.isEmpty()){
            int curr = queue.remove();
            
            for(int i=0; i<adj.get(curr).size(); i++){
                int nbr = adj.get(curr).get(i);
                
                //check if nbr is visited
                if(visited[nbr] == false){
                    visited[nbr] = true;
                    ans.add(nbr);
                    queue.add(nbr);
                }
            }
        }
        
        return ans;
        
    }

}
