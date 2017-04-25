package cn.edu.bjut.shortestPath;

import java.util.HashSet;
import java.util.Set;

import cn.edu.bjut.graph.MGraph;

public class DijkstraAlgorithm1 {

	public MGraph generateShortestPath(MGraph g, int n) {
		MGraph ret = g;// 其实对于Java这种值传递，这样没啥意义

		int[] dist = new int[g.n];
		int[] path = new int[g.n];
		Set<Integer> closed = new HashSet<>();
		for (int i = 0; i < g.n; i++) {
			dist[i] = -1;
			path[i] = -1;
		}

		dist[n] = 0;

		for (int i = 0; i < g.n; i++) {
			if (g.edges[n][i] > 0) {// 表示从n点到i点有权值
				dist[i] = g.edges[n][i];
				path[i] = n;
			}
		}

		closed.add(n);
		int k = 0;
		for (int m = 0; m < g.n; m++) {

			int min = -1;
			for (int i = 0; i < g.n; i++) {
				if (!closed.contains(i))
					if (dist[i] > 0)
						if (min == -1 || dist[i] < min) {
							min = dist[i];
							k = i;//k值的选取是关键
						}
			}

			
			closed.add(k);
			
			if(closed.size() == g.n)
				break;

			for (int i = 0; i < g.n; i++) {
				if (g.edges[k][i] > 0 && dist[k] > 0)
					if (dist[i] < 0 || dist[i] > dist[k] + g.edges[k][i]) {
						dist[i] = dist[k] + g.edges[k][i];
						path[i] = k;
					}
			}
			
			System.out.println("k:" + k);
			printDisth(dist, n);
			System.out.println("=======================");
		}

		printDisth(dist, n);
		printPath(path);

		return ret;
	}

	public void printPath(int[] path) {
		for (int i = 0; i < path.length; i++)
			System.out.print(path[i] + " ");
		System.out.println();
	}

	public void printDisth(int[] dist, int n) {
		System.out.println(n + ":");
		for (int i = 0; i < dist.length; i++)
			System.out.print(i + " ");
		System.out.println();
		for (int i = 0; i < dist.length; i++)
			System.out.print(dist[i] + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		MGraph g = new MGraph();
		g.n = 7;
		int[][] array = new int[g.n][g.n];
		array[0][1] = 4;
		array[0][2] = 6;
		array[0][3] = 6;
		array[1][2] = 1;
		array[1][4] = 7;
		array[2][4] = 6;
		array[2][5] = 4;
		array[3][2] = 2;
		array[3][5] = 5;
		array[4][6] = 6;
		array[5][4] = 1;
		array[5][6] = 8;
		g.edges = array;
		DijkstraAlgorithm1 algorithm = new DijkstraAlgorithm1();
		algorithm.generateShortestPath(g, 0);
	}

}
