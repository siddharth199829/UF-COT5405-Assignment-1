package AOA_PROJECT_FINAL;

import java.util.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Vector;

public class graph_operations {
	
    static void DepthFirstUntil(int v, boolean[] visited,HashMap<Integer, Vector<Integer>> adjList)
    {
        visited[v] = true;
        System.out.print(v + " ");
        for (int x : adjList.get(v)) {
            if (!visited[x])
                DepthFirstUntil(x, visited, adjList);
        }
    }
    static void connected_Components(HashMap<Integer, Vector<Integer>> adjList)
    {
        int V = adjList.size();
        boolean[] visited = new boolean[V];
        System.out.println("\r\n"+"The connected components are :");
        for (int v = 0; v < V; ++v) {
            if (!visited[v]) {
                // print all reachable vertices
                // from v
                DepthFirstUntil(v, visited, adjList);
                System.out.println();
            }
        }
        System.out.println("\r\n");
    }
    
    static Boolean isCyclicUntil(int node, Boolean visited[], int parent,HashMap<Integer, Vector<Integer>> adjList ) 
    { 
        // Mark the current node as visited 
        visited[node] = true; 
        Integer i;

        // Recur for all the vertices 
        // adjacent to this vertex 
        Iterator<Integer> it = adjList.get(node).iterator(); 
        while (it.hasNext()) 
        { 
            i = it.next(); 

            // If an adjacent is not 
            // visited, then recur for that 
            // adjacent 
            if (!visited[i]) 
            {
                if (isCyclicUntil(i, visited, node, adjList)) 
                    return true;
            } 

            // If an adjacent is visited 
            // and not parent of current 
            // vertex, then there is a cycle. 
            else if (i != parent)
                return true; 
        } 
        return false; 
    } 
    
    static String isCyclic(HashMap<Integer, Vector<Integer>> adjList) 
    { 
        
        // Mark all the vertices as 
        // not visited and not part of 
        // recursion stack 
        Boolean visited[] = new Boolean[adjList.size()]; 
        for (int i = 0; i < adjList.size(); i++) 
            visited[i] = false; 

        // Call the recursive helper 
        // function to detect cycle in 
        // different DFS trees 
        for (int u = 0; u < adjList.size(); u++) 
        { 
            // Don't recur for u if already visited 
            if (!visited[u]) 
                if (isCyclicUntil(u, visited, -1, adjList)) {
                	
                	System.out.print("The cycle is : " + "\r\n");
                	for(int i=0 ; i< visited.length ; i++) 
                	{
                		System.out.print(i+" ");
                	}
                	// print visted array here (only true items)
                	return "";
                }      
        } 
        return "Does not contain cycle";
    } 
    
    public static void printShortestDistance(Vector<Vector<Integer>> adj, int v)

    {
    	
    	// predecessor[i] array stores predecessor of
    	// i and distance array stores distance of i
    	// from s
    	System.out.println("\r\n" + "find shortest path");
    	Scanner scn = new Scanner(System.in);
    	System.out.println("enter the starting node :");
        int s = scn.nextInt();
        System.out.println("enter the destination node :");
        
        int dest = scn.nextInt();
    	int pred[] = new int[v];
    	int dist[] = new int[v];

    	if (BFS(adj, s, dest, v, pred, dist) == false) {
   
    		System.out.println("Given source and destination" + 
                                "are not connected");
    		
    		return;
    	}
    	// LinkedList to store path
    	LinkedList<Integer> path = new LinkedList<Integer>();
    	int crawl = dest;
    	path.add(crawl);
    	while (pred[crawl] != -1) {
    		path.add(pred[crawl]);
    		crawl = pred[crawl];
    	}
    	// Print distance

    	System.out.println("Shortest path length is: " + dist[dest]);
    	// Print path
    	System.out.println("Path is ::");
    	for (int i = path.size() - 1; i >= 0; i--) {
    		System.out.print(path.get(i) + " ");
    	}
    }

    // a modified version of BFS that stores predecessor
    // of each vertex in array pred
    // and its distance from source in array dist
    
    public static boolean BFS(Vector<Vector<Integer>> arrList, int src,int dest, int v, int pred[], int dist[])

    {

    	// a queue to maintain queue of vertices whose
    	// adjacency list is to be scanned as per normal
    	// BFS algorithm using LinkedList of Integer type

    	LinkedList<Integer> queue = new LinkedList<Integer>();

    	// boolean array visited[] which stores the
    	// information whether ith vertex is reached
    	// at least once in the Breadth first search

    	boolean visited[] = new boolean[v];
    	
    	// initially all vertices are unvisited
    	// so v[i] for all i is false
    	// and as no path is yet constructed
    	// dist[i] for all i set to infinity
    	
    	for (int i = 0; i < v; i++) 
    	{
    		visited[i] = false;
    		dist[i] = Integer.MAX_VALUE;
    		pred[i] = -1;
    	}
    	// now source is first to be visited and
    	// distance from source to itself should be 0
    	visited[src] = true;
    	dist[src] = 0;
    	queue.add(src);
    	
    	// bfs Algorithm
    	while (!queue.isEmpty()) {
    		int u = queue.remove();
    		for (int i = 0; i < arrList.get(u).size(); i++) {
    			if (visited[arrList.get(u).get(i)] == false) {
    				visited[arrList.get(u).get(i)] = true;
    				dist[arrList.get(u).get(i)] = dist[u] + 1;
    				pred[arrList.get(u).get(i)] = u;
    				queue.add(arrList.get(u).get(i));
    				// stopping condition (when we find
    				// our destination)
    				if (arrList.get(u).get(i) == dest)
    					return true;
    			}
    		}
    	}
    	return false;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
