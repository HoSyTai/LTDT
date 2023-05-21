package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public abstract class Graph {
	public int numVexs;
	protected int[][] matrix;
	protected String path;
	protected boolean visit[];
	protected boolean Action_succes = true;
	protected int weiTreeMin;
	protected String edgesTreeMin;
	protected int[][] tree_Min;
	protected String pathMinAB;




	public String getEdgesTreeMin() {
		return edgesTreeMin;
	}

	public void setEdgesTreeMin(String edgesTreeMin) {
		this.edgesTreeMin = edgesTreeMin;
	}

	public String getPathMinAB() {
		return pathMinAB;
	}

	public void setPathMinAB(String pathMinAB) {
		this.pathMinAB = pathMinAB;
	}

	public int getWeiTreeMin() {
		return weiTreeMin;
	}

	public void setWeiTreeMin(int weiTreeMin) {
		this.weiTreeMin = weiTreeMin;
	}

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

	public void setVisit(boolean[] visit) {
		this.visit = visit;
	}

	public boolean[] getVisit() {
		return visit;
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
	public String loadNumVex(String pathFile) {
		File file = new File(pathFile);
		String num ="";
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			num = br.readLine();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return num;
	}
	
	public String printMatrix() {
		String rs = "";
		for (int i = 0; i < getNumVexs(); i++) {
			for (int j = 0; j < getNumVexs(); j++) {
				rs+= (getMatrix()[i][j] + " ");
			}
			rs+= "\n";
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
	public abstract boolean isConnected();
		
	public abstract void addEdges(int i, int j);

	public abstract void removeEdges(int i, int j);

	public abstract void addVex();
	
	public abstract void removeVex(int vex);
	// kruskal
	public abstract int[][] kruskal();

    public abstract void removeEdges_hasWei(int x, int y);
	
	public abstract void addEdges_hasWei(int x, int y, int w);
		
	public abstract void AlgoDijstraAB(int startVex , int endVex);

}