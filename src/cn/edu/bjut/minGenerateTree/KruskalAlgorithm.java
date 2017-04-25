package cn.edu.bjut.minGenerateTree;

import java.util.HashSet;
import java.util.Set;

import cn.edu.bjut.graph.MGraph;

public class KruskalAlgorithm {

	public void buildMinGeneratedTree(MGraph g) {
		// TODO Auto-generated method stub
		Set<Integer> closed = new HashSet<>();
		for (int m = 0; m < g.n; m++) {
			int min = -1;
			int point1 = 0, point2 = 0;
			for (int i = 0; i < g.n; i++) {
				for (int j = 0; j < g.n; j++) {
					if (i != j) {
						if(!(closed.contains(i) && closed.contains(j))){
							if(g.edges[i][j] > 0){
								if(min == -1 || g.edges[i][j] < min){
									min = g.edges[i][j];
									point1 = i;
									point2 = j;
								}
							}
						}
					}
				}
			}
			closed.add(point1);
			closed.add(point2);
			System.out.println(point1 + ":" + point2);
			
			if(closed.size() == g.n)
				break;
		}
	}

	public static void main(String[] args) {
		MGraph g = new MGraph();
		g.n = 5;
		int[][] array = new int[g.n][g.n];
		array[0][1] = 5;
		array[0][2] = 1;
		array[0][3] = 2;
		array[1][0] = 5;
		array[1][2] = 3;
		array[1][4] = 4;
		array[2][0] = 1;
		array[2][1] = 3;
		array[2][3] = 6;
		array[2][4] = 2;
		array[3][0] = 2;
		array[3][2] = 6;
		array[3][4] = 3;
		array[4][1] = 4;
		array[4][2] = 2;
		array[4][3] = 3;
		g.edges = array;
		KruskalAlgorithm algorithm = new KruskalAlgorithm();
		algorithm.buildMinGeneratedTree(g);
	}
	
}
