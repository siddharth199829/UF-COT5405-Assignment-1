package AOA_PROJECT_FINAL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;

public class simulated_test {
	
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
	
    static void printGraph(Map<Integer, Vector<Integer>> adjList) 
    { 
        for (int i = 0; i < adjList.size(); i++) { 
            System.out.println("\nAdjacency list of vertex " + i); 
            System.out.print(i); 
            for (int j = 0; j < adjList.get(i).size(); j++) { 
                System.out.print(" -> "+adjList.get(i).get(j)); 
            } 
            System.out.println(); 
        } 
    }
    
    // this function converts Map<Integer, ArrayList<Integer>> to ArrayList<ArrayList<Integer>>
    
    public static Vector<Vector<Integer>> hashtoarr(Map<Integer, Vector<Integer>> adjList)
    {
    	Vector<Vector<Integer> > arrList =  new Vector<>(adjList.size());
        
        for(int i = 0; i < adjList.size(); i++ ) 
        {
        	 arrList.add(adjList.get(i));
        }
		return arrList;
    }
	
	public static void main(String[] args) {
		
		HashMap<Integer, Vector<Integer>> adjList;
		Vector<Vector<Integer>> arrList;
		
        
		System.out.println("N-CYCLE GRAPH");
		adjList = graphmake();
		graph_simulator.nCycle(adjList);
		printGraph(adjList);
        graph_operations.connected_Components(adjList);
        System.out.println(graph_operations.isCyclic(adjList));
        arrList = hashtoarr(adjList);
        graph_operations.printShortestDistance(arrList,arrList.size());
        
        
        System.out.println("\r\n" + "\r\n" + "COMPLETE GRAPH");
		adjList = graphmake();
		graph_simulator.complete_graph(adjList);
		printGraph(adjList);
        graph_operations.connected_Components(adjList);
        System.out.println(graph_operations.isCyclic(adjList));
        arrList = hashtoarr(adjList);
        graph_operations.printShortestDistance(arrList,arrList.size());
        
        
        System.out.println( "\r\n" + "\r\n" + "EMPTY GRAPH");
		adjList = graphmake();
		printGraph(adjList);
        graph_operations.connected_Components(adjList);
        System.out.println(graph_operations.isCyclic(adjList));
        arrList = hashtoarr(adjList);
        graph_operations.printShortestDistance(arrList,arrList.size());
        
        
        System.out.println( "\r\n" + "\r\n" + "K MOD GRAPH");
		adjList = graphmake();
		graph_simulator.equivalence_mod_k(adjList);
		printGraph(adjList);
        graph_operations.connected_Components(adjList);
        System.out.println(graph_operations.isCyclic(adjList));
        arrList = hashtoarr(adjList);
        graph_operations.printShortestDistance(arrList,arrList.size());

	}

}
