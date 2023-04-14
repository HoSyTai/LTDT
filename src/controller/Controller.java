package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.management.modelmbean.ModelMBean;

import model.DirGraph;
import model.Graph;
import view.View;

public class Controller implements ActionListener{

    private View view;
    private static Graph model = new DirGraph();
	public Controller(View view) {
		super();
		this.view = view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	
		String src = e.getActionCommand();
		// các chức năng chỉnh sửa dữ liệu đồ thị 
		if (src.equals(view.btn_updateMTK.getText())) {
			String filePath = view.textFieldURl.getText();
			String mtk = model.loadGraph(filePath);
			view.textArea_mtk.setText(mtk);
			view.textArea_mtk.getText();
		}else if(src.equals(view.btnAdd.getText())) {
			int startVex = Integer.parseInt(view.textField_EdgeStart.getText());
			int endVex = Integer.parseInt(view.textField_EdgeEnd.getText());
			model.addEdges(Integer.valueOf(startVex), Integer.valueOf(endVex));
			if (model.isAction_succes()) {
			view.textArea_mtk.setText(model.printMatrix());
			view.textArea_mtk.getText();
			view.textArea_console.setText("Thêm cạnh thành công");
			view.textArea_console.getText();
			}else{
				view.textArea_console.setText("Thêm cạnh không thành công");
				view.textArea_console.getText();
			}
		}else if(src.equals(view.btnRemove.getText())) {
			int startVex = Integer.parseInt(view.textField_EdgeStart.getText());
			int endVex = Integer.parseInt(view.textField_EdgeEnd.getText());
			model.removeEdges(Integer.valueOf(startVex), Integer.valueOf(endVex));
			if (model.isAction_succes()) {
				view.textArea_mtk.setText(model.printMatrix());
				view.textArea_mtk.getText();
				view.textArea_console.setText("Xóa cạnh thành công");
				view.textArea_console.getText();
				}else {
					view.textArea_console.setText("Xóa cạnh không thành công");
					view.textArea_console.getText();
				}
		}else if(src.equals(view.btnEdgeAdd.getText())){
			model.addVex();
			view.textArea_mtk.setText(model.printMatrix());
		    view.textArea_mtk.getText();
		    view.textArea_console.setText("Thêm đỉnh thành công");
		    view.textArea_console.getText();
		}else if(src.equals(view.btnDeleteVex.getText())){
			model.removeVex(Integer.valueOf(view.textField_NameVex.getText()));
			view.textArea_mtk.setText(model.printMatrix());
		    view.textArea_mtk.getText();
		    view.textArea_console.setText("Xóa đỉnh thành công");
		    view.textArea_console.getText();
		}else if(src.equals(view.btnAdd_trongSo.getText())){
			int startVex = Integer.parseInt(view.textField_EdgeStart.getText());
			int endVex = Integer.parseInt(view.textField_EdgeEnd.getText());
			int weiEdges = Integer.parseInt(view.textField_trongSo.getText());
			model.addEdges_hasWei(startVex, endVex, weiEdges);
			view.textArea_mtk.setText(model.printMatrix());
		    view.textArea_mtk.getText();
		    view.textArea_console.setText("Thêm trọng số thành công");
		    view.textArea_console.getText();
		}else if(src.equals(view.btnDelete_trongSo.getText())){
			int startVex = Integer.parseInt(view.textField_EdgeStart.getText());
			int endVex = Integer.parseInt(view.textField_EdgeEnd.getText());
			model.removeEdges_hasWei(startVex, endVex);;
			view.textArea_mtk.setText(model.printMatrix());
		    view.textArea_mtk.getText();
		    view.textArea_console.setText("Xóa trọng số thành công");
		    view.textArea_console.getText();
		}
		
		
		
		//các giải thuật
		else if(src.equals(view.btn_findTree.getText())){
			model.kruskal();
			view.textArea_mtk.setText(model.printMatrix());
		    view.textArea_mtk.getText();
		    view.textArea_console.setText(model.getEdgesTreeMin()+ model.getWeiTreeMin());
		    view.textArea_console.getText();
		}else if (src.equals(view.btnCheckLT.getText())) {
			boolean isConnect = model.isConnected();
			if (isConnect==false) {
				view.textArea_console.setText("Đồ thị không liên thông");
			}else {
				view.textArea_console.setText("Đồ thị liên thông");
			}
			view.textArea_console.getText();
		}
	}
	public static void main(String[] args) {

	}
}
