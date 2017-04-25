package cn.edu.bjut.algorithm;

import cn.edu.bjut.graph.MGraph;

public class Algorithm {

	public int algorithm(MGraph g){
		int[][] A = new int[g.MAX][g.MAX];
		int[] B = new int[g.MAX];
		int i,j,k,m;
		
		for(i = 0; i < g.n; i++)
			for(j = 0; j < g.n; j++)
				A[i][j] = g.edges[i][j];
		
		showArray(A,g.n);
		
		for(k = 0; k < g.n; k++)
			for(i = 0; i < g.n; i++)
				for(j = 0; j < g.n; j++)
					if(A[i][k] + A[k][j] < A[i][j])
						A[i][j] = A[i][k] + A[k][j];
		
		showArray(A,g.n);
		
		for(j = 0; j < g.n; j++){
			B[j] = A[0][j];
			for(i = 1; i < g.n; i++)
				if(B[j] < A[i][j])
					B[j] = A[i][j];
		}
		
		k = 0; m = B[k];
		for(i = 1; i < g.n; i++){
			if(B[i] < m){
				m = B[i];
				k = i;
			}
		}
		return k;
	}
	
	public void showArray(int[][] array, int n){
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++)
				System.out.print(array[i][j] + " ");
			System.out.println();
		}
		System.out.println("*******************");
	}
	
	public void show(MGraph g){
		for(int i = 0; i < g.n; i++){
			for(int j = 0; j < g.n; j++)
				System.out.print(g.edges[i][j] + " ");
			System.out.println();
		}
		System.out.println("*******************");
	}
	
	public static void main(String[] args){
		MGraph g = new MGraph();
		g.n = 6;
		int[][] array = new int[g.MAX][g.MAX];
		for(int i = 0; i < g.n; i++)
			for(int j = 0; j < g.n; j++)
				array[i][j] = 100;
		array[1][2] = array[2][1] = 1;
		array[2][3] = array[3][2] = 5;
		array[3][4] = array[4][3] = 4;
		array[1][3] = array[3][1] = 3;
		array[1][5] = array[5][1] = 2;
		array[3][5] = array[5][3] = 4;
		array[4][5] = array[5][4] = 3;
		array[1][0] = array[0][1] = 1;
		array[0][5] = array[5][0] = 2;
		array[0][4] = array[4][0] = 2;
		g.edges = array;
		Algorithm test = new Algorithm();
		test.algorithm(g);
	}
	
}
