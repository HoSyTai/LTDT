package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.interfaces.RSAKey;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public abstract class Graph {
	protected int numVexs;
	protected int[][] matrix;
	protected String path;
	protected boolean visit[];
	protected boolean Action_succes = true;



	public boolean isAction_succes() {
		return Action_succes;
	}

	public void setAction_succes(boolean action_succes) {
		Action_succes = action_succes;
	}

	public Graph(int numVexs, int[][] matrix) {
		super();
		this.numVexs = numVexs;
		this.matrix = new int[numVexs][numVexs];
	}

	public Graph(String path) {
		super();
		this.path = path;
		loadGraph(path);
		this.visit = new boolean[numVexs];
	}

	public Graph() {
		this.matrix = new int[numVexs][numVexs];

	}

	// phuong thuc load du lieu do thi ban dau
	public String loadGraph(String pathFile) {
		String rs = "";
		File file = new File(pathFile);
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			this.numVexs = Integer.valueOf(br.readLine());
			this.matrix = new int[numVexs][numVexs];
			String line = "";
			int row = 0;
			while ((line = br.readLine()) != null) {
				String[] temp = line.split(" ");
				for (int i = 0; i < temp.length; i++) {
					matrix[row][i] = Integer.valueOf(temp[i]);
				}
				row++;
			}
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				rs += matrix[i][j] + " ";
			}
			rs += "\n";
		}
		return rs;
	}

	public int getNumVexs() {
		return numVexs;
	}

	public void setNumVexs(int numVexs) {
		this.numVexs = numVexs;
	}

	public int[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}

	public String printMatrix() {
		
		String rs = "";
//		// make color
//		System.out.print("    ");
//		for (int i = 0; i < matrix.length; i++) {
//			System.out.print((i + 1) + " ");
//		}
//		System.out.println();
//		System.out.print("    ");
//		for (int i = 0; i < matrix.length; i++) {
//			System.out.print("- ");
//		}
//		System.out.println();

		for (int i = 0; i < matrix.length; i++) {
//			System.out.print((i + 1) + " - ");
			for (int j = 0; j < matrix[0].length; j++) {
				rs+= (matrix[i][j] + " ");
			}
			rs+= "\n";
		}
		return rs;
	}

	public int[] BFS_Trung(int v) {
		Queue<Integer> queue = new LinkedList<>();
		int[] rs = new int[matrix.length];
		queue.add(v);
		int index = 0;
		visit[v] = true;
		rs[index] = v;
		while (!queue.isEmpty()) {
			int start = queue.poll();
			if (visit[start] == false) {
				visit[start] = true;
				rs[++index] = start;
			}
			for (int i = 0; i < numVexs; i++) {
				if (matrix[start][i] != 0 && visit[i] == false) {
					queue.add(i);
				}
			}
		}
		return rs;
	}

	public boolean isConnected(int[][] matrix) {
		int soTPLT = 1;
		boolean flag = true;
		BFS_Trung(0);
		for (int i = 0; i < numVexs; i++) {
			if (visit[i] == false) {
				soTPLT++;
				flag = false;
			}
		}
		if (flag == false) {
			System.out.println("do thi khong lien thong : " + soTPLT);
		} else {
			System.out.println("do thi lien thong : " + soTPLT);
		}
		return flag;
	}

	public abstract void addEdges(int i, int j);

	public abstract void removeEdges(int i, int j);

	public abstract void addVex();
}
