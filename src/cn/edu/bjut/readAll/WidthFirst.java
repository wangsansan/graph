package cn.edu.bjut.readAll;

import java.util.LinkedList;
import java.util.List;

import cn.edu.bjut.graph.MGraph;

public class WidthFirst {

	public void goThroughTreeByWidthFirst(MGraph g) {
		int first = 0;
		List<Integer> readAlready = new LinkedList<>();
		readAlready.add(first);
		System.out.print(first + " ");
		for (int j = 0; j < readAlready.size(); j++) {
			int readNow = readAlready.get(j);
			if (readAlready.size() == g.n)
				break;

			for (int i = 0; i < g.n; i++) {
				if (g.edges[readNow][i] != 0) {
					if (!readAlready.contains(i)) {
						System.out.print(i + " ");
						readAlready.add(i);
					}
				}
			}
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
		array[2][0] = 1;
		array[2][3] = 6;
		array[3][0] = 2;
		array[3][2] = 6;
		array[3][4] = 3;
		array[4][3] = 3;
		g.edges = array;
		WidthFirst goThroughGraph = new WidthFirst();
		goThroughGraph.goThroughTreeByWidthFirst(g);
	}

}
