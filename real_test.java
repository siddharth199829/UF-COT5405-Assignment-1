package AOA_PROJECT_FINAL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Vector;

public class real_test {

	public static void main(String[] args) {
		
		HashMap<Integer, Vector<Integer>> adjList;
		Vector<Vector<Integer>> arrList;
        
        Scanner scn = new Scanner(System.in); 
        System.out.println("Press 1 to print Graph Criteria 1 (two nodes are connected with each other if they rated the same movie)");
        System.out.println("Press 2 to print Graph Criteria 2 (two nodes are connected with each other if they rated '4' the same movie)");
        System.out.println("Press 3 to print Graph Criteria 3 (two nodes are connected with each other if they rated '5' the same movie)");
        int a = scn.nextInt();
        
		if(a == 1) 
		{
			adjList = graph_make.filereader1();
			graph_make.printGraph2(adjList);
			graph_make.connected_Components2(adjList);
			System.out.println(graph_make.isCyclic2(adjList));
			arrList = graph_make.hashtoarr2(adjList);
			graph_make.printShortestDistance2(arrList,arrList.size());
		}
		
		else if(a == 2) 
		{
			adjList = graph_make.filereader2();
			graph_make.printGraph2(adjList);
			graph_make.connected_Components2(adjList);
			System.out.println(graph_make.isCyclic2(adjList));
			arrList = graph_make.hashtoarr2(adjList);
			graph_make.printShortestDistance2(arrList,arrList.size());
		}
		else if(a == 3) 
		{
			adjList = graph_make.filereader3();
			graph_make.printGraph2(adjList);
			graph_make.connected_Components2(adjList);
			System.out.println(graph_make.isCyclic2(adjList));
			arrList = graph_make.hashtoarr2(adjList);
			graph_make.printShortestDistance2(arrList,arrList.size());
		}
		else if(a !=1 || a != 2 || a !=3 ) 
		{
			System.out.print("invalid input try again");
		}
	}
}
