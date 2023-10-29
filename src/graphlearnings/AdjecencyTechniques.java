package graphlearnings;

import java.util.ArrayList;

//Following Anuj Bhayya's Graph playlist
public class AdjecencyTechniques {
	
	//Adjecency Matrix
	public static void addEdge(int arr[][], int source, int dest) {
		arr[source][dest] = 1;
		arr[dest][source] = 1;
	}
	
	//Adjecency ArrayList
	public static void addEdge(ArrayList<ArrayList<Integer>> arr, int source, int dest) {
		arr.get(source).add(dest);
		arr.get(dest).add(source);
	}
	
	
	public static void main(String args[]) {
		
		int e = 5;
		int v = 10;
		
	}

}
