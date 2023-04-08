package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.management.modelmbean.ModelMBean;

import model.DirGraph;
import model.Graph;
import view.View;

public class Controller implements ActionListener{

    private View view;
    private Graph model;
	public Controller(View view) {
		super();
		this.view = view;
	}
	
	public void eventUpdateDateOrigin() {
		
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
		}
	}
	public static void main(String[] args) {
		View view = new View(); 
		Graph model = new DirGraph();
		Controller c1 = new Controller(view);
		System.out.println(c1.view.btnUpdate.getText()+"");
		view.textField.setText("C:\\Users\\TUAN\\Desktop\\new workspace\\project\\dothilienthong");
		System.out.println();
		System.out.println(model.loadGraph(view.textField.getText()));
	}
}
