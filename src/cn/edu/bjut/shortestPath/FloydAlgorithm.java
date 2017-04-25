package cn.edu.bjut.shortestPath;

import cn.edu.bjut.graph.MGraph;

public class FloydAlgorithm {

	public MGraph generateShortestPath(MGraph g){
		MGraph ret = g;
		
		int[][] dist = new int[g.n][g.n];
		int[][] path = new int[g.n][g.n];
		
		for(int i = 0; i < g.n; i++)
			for(int j = 0; j < g.n; j++){
				if(i != j)
					dist[i][j] = -1;
				else
					dist[i][j] = 0;
				path[i][j] = -1;
			}
		
		for(int i = 0; i < g.n; i++)
			for(int j = 0; j < g.n; j++)
				if(g.edges[i][j] > 0){
					dist[i][j] = g.edges[i][j];
				}
		
		showTwoDArray(dist);
		System.out.println("----------------------------");
		showTwoDArray(path);
		System.out.println("************************");
		
		for(int k = 0; k < g.n; k++){
			for(int i = 0; i < g.n; i++)
				for(int j = 0; j < g.n; j++){
					if(dist[k][j] > 0 && dist[i][k] > 0){
						if(dist[i][j] < 0 || dist[i][k] + dist[k][j] < dist[i][j]){
							dist[i][j] = dist[i][k] + dist[k][j];
							path[i][j] = k;
						}
					}
				}
			
			System.out.println(k + ":");
			showTwoDArray(dist);
			System.out.println("----------------------------");
			showTwoDArray(path);
			System.out.println("************************");
		}
		System.out.println("final:");
		showTwoDArray(dist);
		System.out.println("----------------------------");
		showTwoDArray(path);
		
		return ret;
	}
	
	public void showTwoDArray(int[][] array){
		for(int i = 0; i < array.length; i++){
			for(int j = 0; j < array[0].length; j++)
				System.out.print(array[i][j] + " ");
			System.out.println();
		}
	}
	
	public static void main(String[] args){
		MGraph g = new MGraph();
		g.n = 4;
		int[][] array = new int[g.n][g.n];
		array[0][1] = 5;
		array[0][3] = 7;
		array[1][2] = 4;
		array[1][3] = 2;
		array[2][1] = 3;
		array[2][0] = 3;
		array[2][3] = 2;
		array[3][2] = 1;
		g.edges = array;
//		FloydAlgorithm algorithm = new FloydAlgorithm();
//		algorithm.generateShortestPath(g);
		DijkstraAlgorithm1 algorithm2 = new DijkstraAlgorithm1();
		algorithm2.generateShortestPath(g, 1);
	}
	
}
