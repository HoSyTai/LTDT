package model;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class DirGraph extends Graph {
//	boolean addedVex = false;
	public DirGraph(String path) {
		super(path);
		// TODO Auto-generated constructor stub
	}
	public DirGraph() {
		

	}

	@Override
	public void addEdges(int i, int j) {
		// TODO Auto-generated method stub
		
		if ((i >= 0 && j >= 0) && (i < getNumVexs() && j < getNumVexs())) {
			getMatrix()[i][j]++;
			setAction_succes(true);
		} else {
			setAction_succes(false);
		}
	}

	@Override
	public void removeEdges(int i, int j) {
		if ((i >= 0 && j >= 0) && (i < getNumVexs() && j < getNumVexs())) {
			if (getMatrix()[i][j] > 0) {
				getMatrix()[i][j]--;
				setAction_succes(true);
			} else {
				setAction_succes(false);
			}
		}
	}
	@Override
	public void addVex() {
		 int [][] matrixAfterAddVex = new int[matrix.length + 1][matrix.length + 1];
		int lenMatrixAfterAdd = matrixAfterAddVex.length;
		for (int i = 0; i <lenMatrixAfterAdd; i++) {
			for (int j = 0; j < lenMatrixAfterAdd; j++) {
				matrixAfterAddVex[i][j] = ((i<matrix.length) && (j <matrix.length))
						? matrix[i][j] : 0;
				
			}
		}		
		setMatrix(matrixAfterAddVex);
		setNumVexs(lenMatrixAfterAdd);
	}
		
		
//		for (int i = 0; i < numVexs; i++) {
//				exitVex = true;
//		}
//		if (exitVex == true) {
//			System.out.println("dinh da ton tai");
//		} else {
//			for (int i = 0; i < matrixAfterAddVex.length; i++) {
//
//			}
//			for (int i = 0; i < matrixAfterAddVex.length; i++) {
//				for (int j = 0; j < matrixAfterAddVex[0].length; j++) {
//					if (i < matrix.length && j < matrix.length) {
//						System.out.print(matrix[i][j] + " ");
//					} else {
//						System.out.print(matrixAfterAddVex[i][j] + " ");
//					}
//				}
//				System.out.println();
//			}

//		}
	
	public static void main(String[] args) {
		String pathFile1 = "C:\\Users\\TUAN\\Desktop\\new workspace\\Demo\\src\\dothilienthong";
		Graph dg1 = new DirGraph(pathFile1);
		System.out.println(dg1.loadGraph(pathFile1));
		System.out.println(dg1.matrix.length);
//		System.out.println(dg1.addVex());
//		System.out.println(dg1.addVex());
//		dg1.printMatrix();
//		dg1.removeEdges(1, 2);
//		dg1.printMatrix();
//		System.out.println("add vẽx ");
//		
//		System.out.println(dg1.addVex());
//	
//		
//		System.out.println(Arrays.toString(dg1.BFS_Trung(0)));
//		System.out.println(dg1.isConnected(dg1.matrix));
//		
//		String pathFile2 = "C:\\Users\\Admin\\eclipse-workspace\\LTDT\\src\\algorithm\\dothilienthong";
//		Graph dg2 = new DirGraph(pathFile2);
//		dg2.loadGraph(pathFile2);
//		dg2.printMatrix();
//		System.out.println(Arrays.toString(dg2.BFS_Trung(0)));
//		System.out.println(dg2.isConnected(dg2.matrix));
//System.out.println();
//		System.out.println(dg2.loadGraph(pathFile2));
	}
}