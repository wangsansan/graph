package cn.edu.bjut.readAll;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import cn.edu.bjut.graph.MGraph;

public class DepthFirst {

	public void goThroughTreeByDepthFirst(MGraph g) {
		int readNow = 0;
		Stack<Integer> readAlready = new Stack<>();
		List<Integer> popAlready = new LinkedList<>();
		while (readAlready.size() + popAlready.size() < g.n) {
			if(!readAlready.contains(readNow)){
				readAlready.push(readNow);
				System.out.print(readNow + " ");
				if(readAlready.size() + popAlready.size() == g.n)
					break;
			}
			boolean findChild = false;
			for (int i = 0; i < g.n; i++) {
				if (g.edges[readNow][i] != 0) {// 代表两点之间有连接，能联通
					if(!readAlready.contains(i) && !popAlready.contains(i)){
						readNow = i;
						findChild = true;
						break;
					}
				}
			}
			if(!findChild){
				popAlready.add(readAlready.pop());
				readNow = readAlready.peek();
			}
		}
	}
	
	public static void main(String[] args){
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
		DepthFirst goThroughGraph = new DepthFirst();
		goThroughGraph.goThroughTreeByDepthFirst(g);
	}

}
