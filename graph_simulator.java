package AOA_PROJECT_FINAL;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;

public class graph_simulator {
	
	static void nCycle(Map<Integer, Vector<Integer>> adjList) 
	{
		int i = 0;
		int j;
	  	while (i < adjList.size()) 
	  	{
	  		j = i+1;
	  		while (j < adjList.size()) 
	  		{
	  			if (Math.abs(j-i) == 1 || Math.abs(j-i) == adjList.size()-1) 
	  			{
	  			    adjList.get(i).add(j);
	  			    adjList.get(j).add(i);
	  			}
	  			j++;
	  		}	
	  		i++;
	  	}
	 }
	
	static void complete_graph(Map<Integer, Vector<Integer>> adjList) 
	{
		int i = 0;
		int j;
	  	while (i < adjList.size()) 
	  	{
	  		j = i+1;
	  		while (j < adjList.size()) 
	  		{
	  			if (Math.abs(j-i) > 0) 
	  			{
	  			    adjList.get(i).add(j);
	  			    adjList.get(j).add(i);
	  			}
	  			j++;
	  		}	
	  		i++;
	  	}
	 }
	
	static void equivalence_mod_k(Map<Integer, Vector<Integer>> adjList) 
	{
    	Scanner scn = new Scanner(System.in);
        System.out.println("Enter the value of k which is less than or equal to number of nodes");
        int k = scn.nextInt();
		int i = 0;
		int j;
	  	while (i < adjList.size()) 
	  	{
	  		j = i+1;
	  		while (j < adjList.size()) 
	  		{
	  			if (Math.abs(j-i)%k == 0) 
	  			{
	  			    adjList.get(i).add(j);
	  			    adjList.get(j).add(i);
	  			}
	  			j++;
	  		}	
	  		i++;
	  	}
	 }
}
