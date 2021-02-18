package AOA_PROJECT_FINAL;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;

public class graph_make {
	
	public static HashMap<Integer, Vector<Integer>> graphmake() 
    {
		
    	Scanner scn = new Scanner(System.in);
        System.out.println("Enter total number of nodes");
        int n = scn.nextInt();
        HashMap<Integer, Vector<Integer>> adjList = new HashMap<Integer, Vector<Integer>>(n);
        for (int i = 0; i < n; i++) {
            adjList.put(i, new Vector<Integer>());
        }
		return adjList;
    }
	
    public static HashMap<Integer, Vector<Integer>> filereader1()
    {
    	HashMap<Integer, Vector<Integer>> adjList = new HashMap<>();
    	try {
    		File file = new File("C:\\Users\\siddh\\OneDrive\\Desktop\\ratings_data_1.txt");
    	    Scanner scn = new Scanner(file);
    	    Vector<Integer> movie = new Vector<Integer>();
    	    int lines = 5000;
    	    while(scn.hasNextLine() && lines-- > 0) {
    	    	String data = scn.nextLine();
    	    	
    	    	if (data.charAt(data.length()-1) == ':' ) 
    	    	{
					for (int i = 0; i < movie.size(); i++) {
						Vector<Integer> customerIds = new Vector<>();
						for (int j = 0; j < movie.size(); j++) {
							if (i != j) {
								customerIds.add(movie.get(j));
							}
						}
						adjList.put(movie.get(i),customerIds);
					}
					movie.clear();
    	    		// MOVIE
    	    	}
    	    	else {
    	    		
    	    		String[] parts = data.split("\\,");
    	    		String id = parts[0];
    	    		int ids = Integer.parseInt(id);
    	    		movie.add(ids);

    	    		// CUSTOMER REVIEW
    	    	}
    	    	//System.out.println(data);
    	    }
    	    	
    	} catch(Exception e) 
    	{
    		System.out.println(e);
    	}
		return adjList;
    }
	
    public static HashMap<Integer, Vector<Integer>> filereader2()
    {
    	HashMap<Integer, Vector<Integer>> adjList = new HashMap<>();
    	try {
    		File file = new File("C:\\Users\\siddh\\OneDrive\\Desktop\\ratings_data_1.txt");
    	    Scanner scn = new Scanner(file);
    	    Vector<Integer> movie = new Vector<Integer>();
    	    int lines = 5000;
    	    while(scn.hasNextLine() && lines-- > 0) {
    	    	String data = scn.nextLine();
    	    	
    	    	if (data.charAt(data.length()-1) == ':' ) 
    	    	{
    	    		for (int i = 0; i < movie.size(); i++) {
    	    			Vector<Integer> customerIds = new Vector<>();
						for (int j = 0; j < movie.size(); j++) {
							if (i != j) {
								customerIds.add(movie.get(j));
							}
						}
						adjList.put(movie.get(i),customerIds);
					}
					movie.clear();
    	    		// MOVIE
    	    	}
    	    	else {
    	    		
    	    		String[] parts = data.split("\\,");
    	    		String id = parts[0];
    	    		int ids = Integer.parseInt(id);
    	    		System.out.println(data.split(",")[1]);
    	    		if (Integer.parseInt(data.split(",")[1]) == 4) {
    	    			movie.add(ids);
    	    		}

    	    		// CUSTOMER REVIEW
    	    	}
    	    	//System.out.println(data);
    	    }
    	    	
    	} catch(Exception e) 
    	{
    		System.out.println(e);
    	}
		return adjList;
    }
    
    public static HashMap<Integer, Vector<Integer>> filereader3()
    {
    	HashMap<Integer, Vector<Integer>> adjList = new HashMap<>();
    	try {
    		File file = new File("C:\\Users\\siddh\\OneDrive\\Desktop\\ratings_data_1.txt");
    	    Scanner scn = new Scanner(file);
    	    Vector<Integer> movie = new Vector<Integer>();
    	    int lines = 5000;
    	    while(scn.hasNextLine() && lines-- > 0) {
    	    	String data = scn.nextLine();
    	    	
    	    	if (data.charAt(data.length()-1) == ':' ) 
    	    	{
    	    		for (int i = 0; i < movie.size(); i++) {
    	    			Vector<Integer> customerIds = new Vector<>();
						for (int j = 0; j < movie.size(); j++) {
							if (i != j) {
								customerIds.add(movie.get(j));
							}
						}
						adjList.put(movie.get(i),customerIds);
					}
					movie.clear();
    	    		// MOVIE
    	    	}
    	    	else {
    	    		
    	    		String[] parts = data.split("\\,");
    	    		String id = parts[0];
    	    		int ids = Integer.parseInt(id);
    	    		if (Integer.parseInt(data.split(",")[1]) == 5) {
    	    			movie.add(ids);
    	    		}

    	    		// CUSTOMER REVIEW
    	    	}
    	    	//System.out.println(data);
    	    }
    	    	
    	} catch(Exception e) 
    	{
    		System.out.println(e);
    	}
		return adjList;
    }
    
    static void printGraph2(Map<Integer, Vector<Integer>> adjList) 
    { 
    	for (Integer i: adjList.keySet()) {
    		System.out.println("Vertex: " + i);
    		System.out.println(adjList.get(i));
    	}
    }
    
    static void DepthFirstUntil(int v, boolean[] visited,HashMap<Integer, Vector<Integer>> adjList, Vector<Integer> nodes)
    {
        visited[v] = true;
        System.out.print(nodes.get(v) + " ");
        for (int x = 0; x < nodes.size(); x++) {
        	if (!visited[x])
                DepthFirstUntil(x, visited, adjList, nodes);
        }

    }
    static void connected_Components2(HashMap<Integer, Vector<Integer>> adjList)
    {
    	Vector<Integer> nodes = new Vector<Integer>();
    	for (Integer i: adjList.keySet()) {
    		nodes.add(i);
    	}
        int V = adjList.size();
        boolean[] visited = new boolean[V];
        System.out.println("\r\n" + "Connected components are : " + "\r\n");
        for (int v = 0; v < V; ++v) {
            if (!visited[v]) {
                // print all reachable vertices
                // from v
                DepthFirstUntil(v, visited, adjList, nodes);
                System.out.println();
            }
        }
    }
    
    static Boolean isCyclicUntil(int node, Boolean visited[], int parent,HashMap<Integer, Vector<Integer>> adjList,Vector<Integer> nodes2) 
    { 
        // Mark the current node as visited 
        visited[node] = true; 
        Integer i;
        
        /*
         * */

        // Recur for all the vertices 
        // adjacent to this vertex 
        if (adjList.get(node) == null) return false;
        Iterator<Integer> it = adjList.get(node).iterator(); 
        while (it.hasNext()) 
        { 
            i = it.next(); 

            // If an adjacent is not 
            // visited, then recur for that 
            // adjacent 
            if (!visited[i]) 
            {
                if (isCyclicUntil(i, visited, node, adjList ,nodes2)) 
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
    
    static String isCyclic2(HashMap<Integer, Vector<Integer>> adjList) 
    { 
        
        // Mark all the vertices as 
        // not visited and not part of 
        // recursion stack 
    	Vector<Integer> nodes2 = new Vector<Integer>();
    	for (Integer i: adjList.keySet()) {
    		nodes2.add(i);
    	}
    	
        Boolean visited[] = new Boolean[adjList.size()]; 
        for (int i = 0; i < adjList.size(); i++) 
            visited[i] = false; 

        // Call the recursive helper 
        // function to detect cycle in 
        // different DFS trees 
        System.out.print("\r\n" + "The cycle is : " + "\r\n"  + "\r\n");
        for (int u = 0; u < adjList.size(); u++) 
        { 
        
            // Don't recur for u if already visited 
            if (!visited[u]) 
                if (isCyclicUntil(u, visited, -1, adjList,nodes2)) 
                	
                	System.out.print("\r\n" + "The cycle is : " + "\r\n");
                	for(int i=0 ; i< visited.length ; i++) 
                	{
                		System.out.print(nodes2.get(i)+" ");
                	}
                    return ""; 
        } 

        return "False";
    } 
    
    public static Vector<Vector<Integer>> hashtoarr2(Map<Integer, Vector<Integer>> adjList)
    {
    	
    	Vector<Vector<Integer> > arrList =  new Vector<>();
        HashMap<Integer, Integer> indexMapping = new HashMap<>();
        int count = 0;
        for (Integer i: adjList.keySet()) {
        	indexMapping.put(i, count++);
        }        
        
        for(Integer i: adjList.keySet()) 
        {
        	Vector<Integer> arr = new Vector<Integer>();
        	for (Integer j: adjList.get(i)) {
        		arr.add(indexMapping.get(j));
        	}
        	arrList.add(arr);
        }
        
		return arrList;
    	
    }
    
    static void printShortestDistance2(Vector<Vector<Integer>> adj, int v)

    {
    	
    	// predecessor[i] array stores predecessor of
    	// i and distance array stores distance of i
    	// from s
    	System.out.println("\r\n" + "find shortest path");
    	Scanner scn = new Scanner(System.in);
    	System.out.println("enter the starting node value from 0 to 3887 :");
        int s = scn.nextInt();
        System.out.println("enter the destination node value from 0 to 3887:");
        
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
    
    static boolean BFS(Vector<Vector<Integer>> arrList, int src,int dest, int v, int pred[], int dist[])

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
    
}
