package graph;

import java.util.ArrayList;

public class DetectCycleInUndirectedGraph {
	
	 public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
		    
		 	//visited array
	        boolean visited[] = new boolean[V];
	        
	        //this loop will ensure that we are covering connected as well as unconnected components
	        for(int i=0; i < V; i++){
	            if(visited[i] == false){
	                if(cycleDFS(i, adj, visited, -1)) 
	                    return true;
	            }
	        }
	        
	        return false;
	    }
	    
	    public boolean cycleDFS(int V, ArrayList<ArrayList<Integer>> adj, boolean[] visited, int parent){
	        
	    	//firstly we visited V so mark it true
	        visited[V] = true;
	        
	        //getting all neighbors of V
	        for(int nbr : adj.get(V)){
	            if(visited[nbr] == false){
	            	//parent-> V
	                if(cycleDFS(nbr, adj, visited, V)){
	                    return true;
	                }
	            }
	            
	            //else part means it's visited means cycle can be there
	            //as once we move from parent to nbr we mark parent as true
	            //now if we traverse from nbr to it's neighbors then it can again go to it's parent
	            //eg. 1-->2, 3 (1's neighbors are 2 and 3)
	            //so if we traverse 2's neighbors then 1 will also be there so that needs to be exclude
	            else if(nbr != parent) return true;
	        }
	        
	        //cycle is not there
	        return false;
	        
	    }

}
