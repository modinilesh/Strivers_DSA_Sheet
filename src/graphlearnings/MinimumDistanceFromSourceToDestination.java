package graphlearnings;

import java.util.*;
import java.util.LinkedList;

public class MinimumDistanceFromSourceToDestination {
	
	//addEdge
	public static void addEdge(ArrayList<ArrayList<Integer>> adj, int i, int j)
    {
        adj.get(i).add(j);
        adj.get(j).add(i);
    }
	
	
	//It can be solved using BFS
	public static ArrayList<Integer> minDistanceBFS(int vertex, int src, int dest, ArrayList<ArrayList<Integer>> adj) {
		
		//creating visited array, that will ensure we won't stuck in same loop of visited element
		boolean visited[] = new boolean[200];
		
		//create dist[] array which will maintain distance from source
		int dist[] = new int[vertex];
		
		//predecessor array
		int pred[] = new int[vertex];
		
		for(int i=0; i<vertex; i++) {
			dist[i] = Integer.MAX_VALUE;
			pred[i] = -1;
		}
		
		//queue
		LinkedList<Integer> queue = new LinkedList<>();
		queue.add(src);
		visited[src] = true;
		dist[src] = 0;
		
		//let's write logic here
		while(!queue.isEmpty()) {
			int curr = queue.remove();
			
			//traverse each neighbor 
			for(int i=0; i<adj.get(curr).size(); i++) {
				int nbr = adj.get(curr).get(i);
				
				//if neighbor is not visited
				if(visited[nbr] == false) {
					visited[nbr] = true;
					dist[nbr] = dist[curr] + 1;
					pred[nbr] = curr;
					queue.add(nbr);
					
					//exit condition
					if(nbr == dest) {
						System.out.println("Shortest distance : "+ dist[dest]);
//						System.out.println(Arrays.toString(pred));
					}
				}
			}
		}
		//declaring ans, it is shortest path
		ArrayList<Integer> ans = new ArrayList<>();
		ans.add(dest);
		
		//Now predecessor array will help help us to get shortest path
		System.out.println("Pred array is : "+Arrays.toString(pred));
		int i = dest;
		while (pred[i] != -1) {
            ans.add(0, pred[i]);
            i = pred[i];
        }
		
		return ans;
	}
	
	//main function
	public static void main(String args[]) {
		//creating a new graph for example 
//		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
//		Scanner sc = new Scanner(System.in);
//		
//		//ask input of vertex
//		System.out.println("Enter no. of vertex : ");
//		int vertex = sc.nextInt();
//		
//		for(int i=0; i<=vertex; i++) {
//			adj.add(i, new ArrayList<Integer>());
//		}
//		
//		//will ask for values of neighbors
//		System.out.println("Enter values of neighbors");
//		for(int i=0; i<=vertex; i++) {
//			boolean flag = true;
//			while(flag) {
//				System.out.println("Enter value of neighbor of vertex " +i);
//				int val = sc.nextInt();
//				adj.get(i).add(val);
//				System.out.println("Is there any other neighbor ? (0/1)");
//				int temp = sc.nextInt();
//				if(temp == 0) break;
//			}
//		}
//		
		
		  // No of vertices
        int v = 8;
 
        // Adjacency list for storing which vertices are connected
        ArrayList<ArrayList<Integer>> adj = 
                            new ArrayList<ArrayList<Integer>>(v);
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<Integer>());
        }
 
        // Creating graph given in the above diagram.
        // add_edge function takes adjacency list, source
        // and destination vertex as argument and forms
        // an edge between them.
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 3);
        addEdge(adj, 1, 2);
        addEdge(adj, 3, 4);
        addEdge(adj, 3, 7);
        addEdge(adj, 4, 5);
        addEdge(adj, 4, 6);
        addEdge(adj, 4, 7);
        addEdge(adj, 5, 6);
        addEdge(adj, 6, 7);
        int source = 2, dest = 6;
        
 
    // function to form edge between two vertices
    // source and dest
 
		
		
		
		System.out.println(adj);
		System.out.println("Shortest Path :" + minDistanceBFS(v, source, dest, adj));
//		System.out.println("Shortest Distance :" + (minDistanceBFS(v, source, dest, adj).size() - 1));
	}

}
