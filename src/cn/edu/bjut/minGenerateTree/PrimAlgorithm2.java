package cn.edu.bjut.minGenerateTree;

import java.util.LinkedList;
import java.util.List;

import cn.edu.bjut.graph.MGraph;

public class PrimAlgorithm2 {

	public void buildMinGeneratedTree(MGraph g, int start) {
		List<Integer> closed = new LinkedList<>();
		closed.add(start);
		/*
		 * dist数组中保存的是节点i到已有最小生成树的最小权值
		 * 在Dijkstra算法中，dist数组中保存的是从节点start到节点i的最小权值
		 */
		int[] dist = new int[g.n];
		for (int i = 0; i < g.n; i++) {
			if (g.edges[start][i] > 0) {
				dist[i] = g.edges[start][i];
			} else {
				dist[i] = -1;
			}
		}

		dist[start] = 0;

		for (int m = 0; m < g.n; m++) {

			int min = -1;
			int k = -1;
			for (int i = 0; i < g.n; i++) {
				if (dist[i] > 0 && !closed.contains(i)) {
					if (min == -1 || dist[i] < min) {
						min = dist[i];
						k = i;
					}
				}
			}

			closed.add(k);

			for (int i = 0; i < g.n; i++) {
				if (g.edges[k][i] > 0) {
					if (dist[i] < 0 || dist[k] + g.edges[k][i] < dist[i]) {
						dist[i] = g.edges[k][i];
					}
				}
			}

			System.out.println(k);
			if (closed.size() == g.n)
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
		PrimAlgorithm2 algorithm = new PrimAlgorithm2();
		algorithm.buildMinGeneratedTree(g, 0);
	}

}
