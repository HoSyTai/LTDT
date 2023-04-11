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
		if (src.equals(view.btnUpdate.getText())) {
			view.textField.setText("C:\\Users\\TUAN\\Desktop\\new workspace\\project\\dothilienthong");
			String filePath = view.textField.getText();
			String mtk = model.loadGraph(filePath);
			view.textArea_mtk.setText(mtk);
			view.textArea_mtk.getText();
		}else if(src.equals(view.btnAdd.getText())) {
			String startVex = view.textField_EdgeStart.getText();
			String endVex = view.textField_EdgeEnd.getText();
			model.addEdges(Integer.valueOf(startVex), Integer.valueOf(endVex));
			if (model.isAction_succes()) {
			view.textArea_mtk.setText(model.printMatrix());
			view.textArea_mtk.getText();
			view.textArea_console.setText("Them canh thanh cong");
			view.textArea_console.getText();
			}else {
				view.textArea_console.setText("Them canh khong thanh cong");
				view.textArea_console.getText();
			}
		}else if(src.equals(view.btnRemove.getText())) {
			String startVex = view.textField_EdgeStart.getText();
			String endVex = view.textField_EdgeEnd.getText();
			model.removeEdges(Integer.valueOf(startVex), Integer.valueOf(endVex));
			if (model.isAction_succes()) {
				view.textArea_mtk.setText(model.printMatrix());
				view.textArea_mtk.getText();
				view.textArea_console.setText("Xoa canh thanh cong");
				view.textArea_console.getText();
				}else {
					view.textArea_console.setText("Xoa canh khong thanh cong");
					view.textArea_console.getText();
				}
			
		}
	}
	public static void main(String[] args) {
		View view = new View(); 
//		Graph model = new DirGraph();
		Controller c1 = new Controller(view);
		System.out.println(c1.view.btnUpdate.getText()+"");
		view.textField.setText("C:\\Users\\TUAN\\Desktop\\new workspace\\project\\dothilienthong");
		System.out.println();
		System.out.println(model.loadGraph(view.textField.getText()));
	}
}
