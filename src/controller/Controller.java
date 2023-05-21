package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javax.swing.JFileChooser;

import model.DirGraph;
import model.Graph;
import view.View;

public class Controller implements ActionListener {

	private View view;
	private static Graph model = new DirGraph();

	
	public Controller() {
	}

	public Controller(View view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String src = e.getActionCommand();
		JFileChooser fc = new JFileChooser();
		// các chức năng chỉnh sửa dữ liệu đồ thị
		if (src.equals(view.btn_updateMTK.getText())) {
			String filePath = view.textFieldURL.getText();
			String mtk = model.loadGraph(filePath);
			view.textArea_mtk.setText(mtk);
			view.textArea_mtk.getText();
			String totalVex = model.loadNumVex(filePath);
			view.textField_TotalVex.setText(totalVex);
			view.textField_TotalVex.getText();
			view.textArea_console.setText("");
			view.textArea_console.getText();
		} else {
			if (src.equals(view.btnOpen.getText())) {
				int returnVal = fc.showOpenDialog(view);
				File file = fc.getSelectedFile();
				this.view.textFieldURL.setText(file.getAbsolutePath());
			}

			else if (src.equals(view.btnAdd.getText())) {
				int startVex = Integer.parseInt(view.textField_EdgeStart.getText());
				int endVex = Integer.parseInt(view.textField_EdgeEnd.getText());
				model.addEdges(Integer.valueOf(startVex), Integer.valueOf(endVex));
				if (model.isAction_succes()) {
					view.textArea_mtk.setText(model.printMatrix());
					view.textArea_mtk.getText();
					view.textArea_console.setText("Thêm cạnh thành công");
					view.textArea_console.getText();
					String fileName= view.textFieldURL.getText();
					save(fileName);
				} else {
					view.textArea_console.setText("Thêm cạnh không thành công");
					view.textArea_console.getText();
				}
			} else if (src.equals(view.btnRemove.getText())) {
				int startVex = Integer.parseInt(view.textField_EdgeStart.getText());
				int endVex = Integer.parseInt(view.textField_EdgeEnd.getText());
				model.removeEdges(Integer.valueOf(startVex), Integer.valueOf(endVex));
				if (model.isAction_succes()) {
					view.textArea_mtk.setText(model.printMatrix());
					view.textArea_mtk.getText();
					view.textArea_console.setText("Xóa cạnh thành công");
					view.textArea_console.getText();
					String fileName= view.textFieldURL.getText();
					save(fileName);
				} else {
					view.textArea_console.setText("Xóa cạnh không thành công");
					view.textArea_console.getText();
				}
			} else if (src.equals(view.btnAddVex.getText())) {
				model.addVex();
				view.textArea_mtk.setText(model.printMatrix());
				view.textArea_mtk.getText();
				view.textArea_console.setText("Thêm đỉnh thành công");
				view.textArea_console.getText();
				int temp = Integer.parseInt(view.textField_TotalVex.getText());
				temp = temp + 1;
				String total = String.valueOf(temp);
				view.textField_TotalVex.setText(total);
				String fileName= view.textFieldURL.getText();
				save(fileName);
			} else if (src.equals(view.btnDeleteVex.getText())) {
				model.removeVex(Integer.valueOf(view.textField_NameVex.getText()));
				if (model.isAction_succes()) {
					view.textArea_mtk.setText(model.printMatrix());
					view.textArea_mtk.getText();
					view.textArea_console.setText("Xóa đỉnh thành công");
					view.textArea_console.getText();
					int temp = Integer.parseInt(view.textField_TotalVex.getText());
					temp = temp - 1;
					String total = String.valueOf(temp);
					view.textField_TotalVex.setText(total);
					String fileName= view.textFieldURL.getText();
					save(fileName);
				} else {
					view.textArea_console.setText("Xóa đỉnh không thành công");
					view.textArea_console.getText();
				}
			} else if (src.equals(view.btnAdd_trongSo.getText())) {
				int startVex = Integer.parseInt(view.textField_EdgeStart.getText());
				int endVex = Integer.parseInt(view.textField_EdgeEnd.getText());
				int weiEdges = Integer.parseInt(view.textField_trongSo.getText());
				model.addEdges_hasWei(startVex, endVex, weiEdges);
				view.textArea_mtk.setText(model.printMatrix());
				view.textArea_mtk.getText();
				view.textArea_console.setText("Thêm trọng số thành công");
				view.textArea_console.getText();
				String fileName= view.textFieldURL.getText();
				save(fileName);
			} else if (src.equals(view.btnDelete_trongSo.getText())) {
				int startVex = Integer.parseInt(view.textField_EdgeStart.getText());
				int endVex = Integer.parseInt(view.textField_EdgeEnd.getText());
				model.removeEdges_hasWei(startVex, endVex);
				view.textArea_mtk.setText(model.printMatrix());
				view.textArea_mtk.getText();
				view.textArea_console.setText("Xóa trọng số thành công");
				view.textArea_console.getText();
				String fileName= view.textFieldURL.getText();
				save(fileName);
			}

			// các giải thuật
			else if (src.equals(view.btn_findTree.getText())) {
				model.kruskal();
				if (model.isConnected()) {
					
				
				view.textArea_console.setText(
						"Thứ tự duyệt các cạnh: " + "\n" + model.getEdgesTreeMin() + "Tổng chi phí cây bao trùm: "
								+ model.getWeiTreeMin() + "\n" + "Ma trận cây bao trùm: \n" + model.printMatrix());
				view.textArea_console.getText();
				}else {
					view.textArea_console.setText("Đồ thị không liên thông, \n" + "->" + "không tìm được đường đi");
				}
			} else if (src.equals(view.btnCheckLT.getText())) {
				boolean isConnect = model.isConnected();
				if (isConnect == false) {
					view.textArea_console.setText("Đồ thị không liên thông");
				} else {
					view.textArea_console.setText("Đồ thị liên thông");
				}
				view.textArea_console.getText();
			}
			else if (src.equals(view.btnfindMin.getText())) {
					int startVex = Integer.parseInt(view.textField_EdgeStart.getText());
					int endVex = Integer.parseInt(view.textField_EdgeEnd.getText());
					model.AlgoDijstraAB(startVex, endVex);
					boolean isConnect = model.isConnected();
					if (isConnect == false) {
						view.textArea_console.setText("Đồ thị không liên thông, \n" + "->" + "không tìm được đường đi");
						view.textArea_console.getText();
					} else {
						view.textArea_console.setText(model.getPathMinAB());	
						view.textArea_console.getText();	

					}
					
			}
		}
	}
	
	
	public void save(String fileName) {
		fileName = view.textFieldURL.getText();
		String data = view.textArea_mtk.getText();
		String numVex = view.textField_TotalVex.getText();
		try {
			PrintWriter pw = new PrintWriter(fileName);
			pw.print(numVex + "\n");
			pw.print(data);
			pw.flush();
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

	}
}