package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class DirGraph extends Graph {
	public DirGraph(String path) {
		super(path);
	}

	public DirGraph() {

	}

	@Override
	public void addEdges(int i, int j) {
		// TODO Auto-generated method stub
		if (i == j) {
			setAction_succes(false);
		} else {
			if (i >= 0 && j >= 0 && getMatrix()[i][j] == 1) {
				setAction_succes(false);
			} else {
				getMatrix()[i][j]++;
				setAction_succes(true);
			}
		}
	}

	@Override
	public void removeEdges(int startVex, int endVex) {
		if ((startVex >= 0 && endVex >= 0) && (startVex < getNumVexs() && endVex < getNumVexs())) {
			if (getMatrix()[startVex][endVex] > 0) {
				getMatrix()[startVex][endVex]--;
				setAction_succes(true);
			} else {
				setAction_succes(false);
			}
		}
	}

	@Override
	public void addVex() {
		int[][] matrixAfterAddVex = new int[getNumVexs() + 1][getNumVexs() + 1];
		int lenMatrixAfterAdd = matrixAfterAddVex.length;
		for (int i = 0; i < lenMatrixAfterAdd; i++) {
			for (int j = 0; j < lenMatrixAfterAdd; j++) {
				matrixAfterAddVex[i][j] = ((i < getNumVexs()) && (j < getNumVexs())) ? matrix[i][j] : 0;

			}
		}
		setMatrix(matrixAfterAddVex);
		setNumVexs(lenMatrixAfterAdd);
	}

	@Override
	public void removeVex(int vex) {
		int[][] matrixAfterRemoveVex = new int[getNumVexs() - 1][getNumVexs() - 1];
		for (int i = 0; i < getNumVexs(); i++) {
			for (int j = 0; j < getNumVexs(); j++) {
				if ((vex < getNumVexs() && vex > -1)) {
					setAction_succes(true);
					int decIndex_i = i - 1;
					int decIndex_j = j - 1;
					if (i == vex || j == vex) {
						continue;
					} else if (i < vex && j < vex) {
						matrixAfterRemoveVex[i][j] = getMatrix()[i][j];
					} else if (i > vex && j < vex) {
						matrixAfterRemoveVex[decIndex_i][j] = getMatrix()[i][j];
					} else if (i > vex && j > vex) {
						matrixAfterRemoveVex[decIndex_i][decIndex_j] = getMatrix()[i][j];
					} else if (i < vex && j > vex) {
						matrixAfterRemoveVex[i][decIndex_j] = getMatrix()[i][j];
					}
				} else {
					setAction_succes(false);
				}
			}
		}
		setMatrix(matrixAfterRemoveVex);
		setNumVexs(matrixAfterRemoveVex.length);
	}

	public boolean checkListEmpty(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				if (matrix[i][j] != 0) {
					return false;
				}
			}
		}
		return true;
	}

	// xem lại
	@Override
	public int[][] kruskal() {
		if (isConnected()) {
			// ma trận kề của cây bao trùm nhỏ nhất
			tree_Min = new int[getNumVexs()][getNumVexs()];
			String edgesTree = "";
			// danh sách cạnh của đồ thị ===> sắp xếp nó tăng dần theo trọng số
			ArrayList<Edges> list = new ArrayList<>();
			for (int i = 0; i < getMatrix().length; i++) {
				for (int j = 0; j < getMatrix().length; j++) {
					if (getMatrix()[i][j] != 0) {
						Edges c = new Edges(i, j, getMatrix()[i][j]);
						list.add(c);
					}
				}
			}
			Collections.sort(list);
			int[][] tree = new int[getNumVexs()][getNumVexs()];
			int sum = 0;
			int[][] E = getMatrix();
			int socanh = 0;
			while (socanh < getNumVexs() - 1 && checkListEmpty(E) == false) {
				for (int i = 0; i < list.size(); i++) {
					Edges min = list.get(i);
					removeEdges_hasWei(E, min.x, min.y);
					if (hasCycles(tree, min.x, min.y) == false) {
						addEdges_hasWei(tree, min.x, min.y, min.w);
						socanh++;
						edgesTree += (min.x + "->" + min.y + " : " + min.w) + "\n";
						tree_Min[min.x][min.y] = min.w;
						sum += min.w;
					}
				}
			}
			setEdgesTreeMin(edgesTree);
			setWeiTreeMin(sum);
			setMatrix(tree_Min);
		}

		return this.getMatrix();
	}

	public boolean hasCycles(int[][] matrix, int x, int y) {
		Stack<Integer> stack = new Stack<>();
		boolean[] visit = new boolean[matrix.length];
		stack.push(x);
		while (!stack.isEmpty()) {
			int temp = stack.pop();
			visit[temp] = true;
			if (visit[temp] == visit[y]) {
				return true;
			} else {
				for (int i = 0; i < visit.length; i++) {
					if (matrix[temp][i] != 0 && visit[i] == false) {
						stack.push(i);
						visit[i] = true;
					}
				}
			}

		}

		return false;
	}

	public void removeEdges_hasWei(int[][] matrix, int x, int y) {
		if (x >= 0 && x <= matrix.length && y >= 0 && y <= matrix.length && matrix[x][y] == 1) {
			if (x == y) {
				matrix[x][y] = 0;
			} else {
				matrix[x][y] = 0;
				matrix[y][x] = 0;
			}
		}

	}

	public void addEdges_hasWei(int[][] matrix, int x, int y, int w) {
		// TODO Auto-generated method stub
		if (x >= 0 && x <= numVexs && y >= 0 && y <= numVexs) {
			if (x == y) {
				matrix[x][y] = w;
			} else {
				matrix[x][y] = w;
				matrix[y][x] = w;
			}
		}
	}

	class Edges implements Comparable<Edges> {
		int x;
		int y;
		int w;

		public Edges(int x, int y, int w) {
			super();
			this.x = x;
			this.y = y;
			this.w = w;
		}

		@Override
		public int compareTo(Edges o) {
			// TODO Auto-generated method stub
			return this.w - o.w;
		}
	}

	private int[] BFS_Trung(int v) {
		/*
		 * y tuong : chi can co canh noi giua 2 dinh bat ki la do thi lien thong ( lien
		 * thong mot phan
		 */
		setVisit(new boolean[getNumVexs()]);
		;
		int[][] UnGraph = new int[getNumVexs()][getNumVexs()];
		DirConvertToUn(UnGraph);
		Queue<Integer> queue = new LinkedList<>();
		int[] rs = new int[UnGraph.length];
		queue.add(v);
		int index = 0;
		getVisit()[v] = true;
		rs[index] = v;
		while (!queue.isEmpty()) {
			int start = queue.poll();
			if (getVisit()[start] == false) {
				getVisit()[start] = true;
				rs[++index] = start;
			}
			for (int i = 0; i < getNumVexs(); i++) {
				if (UnGraph[start][i] != 0 && getVisit()[i] == false) {
					queue.add(i);
				}
			}
		}
		return rs;
	}

	public void DirConvertToUn(int[][] matrix) {
		// TODO Auto-generated method stub
		for (int i = 0; i < getNumVexs(); i++) {
			for (int j = 0; j < getNumVexs(); j++) {
				if (getMatrix()[i][j] != 0) {
					matrix[i][j] = getMatrix()[i][j];
					matrix[j][i] = getMatrix()[i][j];
				}
			}
		}
	}

	@Override
	public boolean isConnected() {
		BFS_Trung(0);
		for (int i = 0; i < getNumVexs(); i++) {
			if (getVisit()[i] == false) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {

//		Graph dg = new DirGraph("C:\\Users\\TUAN\\Desktop\\new workspace\\Demo\\src\\dothikhonglienthong");
//		System.out.println(dg.printMatrix());
//		System.out.println("before convert : \n" + dg.printMatrix());
//		System.out.println("after convert : \n " + dg.printMatrix());
//		System.out.println(dg.isConnected());
		Graph d = new DirGraph("C:\\Users\\TUAN\\Desktop\\file test\\kruskal_test");
		d.AlgoDijstraAB(0, 3);
		System.out.println(d.getPathMinAB());

	}

	@Override
	public void removeEdges_hasWei(int x, int y) {
		// TODO Auto-generated method stub
		getMatrix()[x][y] = 0;
	}

	@Override
	public void addEdges_hasWei(int x, int y, int w) {
		// TODO Auto-generated method stub
		getMatrix()[x][y] = w;
	}

	private ArrayList<Integer> adjacentVertices(int v) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		for (int i = 0; i < getMatrix().length; i++) {
			if (matrix[v][i] != 0) {
				res.add(i);
			}
		}
		return res;
	}

	@Override
	public void AlgoDijstraAB(int s, int e) {
		// TODO Auto-generated method stub
		double[] L = new double[matrix.length];
		int[] P = new int[matrix.length];
		List<Integer> R = new ArrayList<>();
		for (int i = 0; i < matrix.length; i++) {
			L[i] = Double.POSITIVE_INFINITY;
			P[i] = -1;
			R.add(i);
		}
		L[s] = 0;
		while (!R.isEmpty()) {
			Integer v = R.get(0);
			for (Integer i : R) {
				if (L[i] < L[v])
					v = i;
			}
			R.remove(v);
			for (Integer i : adjacentVertices(v)) {
				if (L[i] > L[v] + matrix[v][i]) {
					L[i] = L[v] + matrix[v][i];
					P[i] = v;
				}
			}
		}

		for (int i = 0; i < matrix.length; i++) {
			if (i != s && L[i] != Double.POSITIVE_INFINITY) {
				List<Integer> path = new ArrayList<>();
				int k = i;
				while (k != -1) {
					path.add(0, k);
					k = P[k];
				}
				if (i == e) {
					pathMinAB = "duong di ngan nhat tu:" + s + " den " + i + ": \n" + path + " co do dai " + L[i];
				}
			}
		}
	}
}