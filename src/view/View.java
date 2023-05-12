package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import controller.Controller;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.ScrollPaneConstants;

public class View extends JFrame {

	
//	public Graph model;
	public JPanel contentPane;
	public JTextField textFieldURl;
	public JButton btnUpdate;
	public JTextField textField_EdgeStart;
	public JTextField textField_EdgeEnd;
	public JTextField textField_NameVex;
	public JButton btnAdd;
	public JButton btnRemove;
	public JButton btnAdd_trongSo;
	public JButton btnEdgeAdd;
	public JTextArea textArea_console;
	public JTextArea textArea_mtk;
	public JTextField textField_trongSo;
	public JButton btnDelete_trongSo;
	public JButton btnCheckLT;
	public JButton btnDeleteVex;
	public JButton btn_findTree;
	public JButton btn_updateMTK;
	private JScrollPane scrollPane_mtk;
	private JButton btnfindMin;

	/**
	 * Create the frame.
	 */
	public View() {
		
		setTitle("LTDT_Nhom16_2023");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		
		ActionListener ac = new Controller(this);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 255, 204));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 255, 255));
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(50, 10, 800, 60);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Link file đồ thị ban đầu");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 10, 151, 13);
		panel.add(lblNewLabel);
		
		textFieldURl = new JTextField();
		textFieldURl.setBounds(171, 8, 280, 31);
		panel.add(textFieldURl);
		textFieldURl.setColumns(10);
		
		btnUpdate = new JButton("Open file");
		btnUpdate.setBackground(UIManager.getColor("CheckBoxMenuItem.selectionBackground"));
		btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnUpdate.setBounds(484, 7, 127, 32);
		
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_bt_OpenFile_actionPerformed(e);
			}

			private void do_bt_OpenFile_actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				int status = fileChooser.showOpenDialog(null);
				if (status == fileChooser.APPROVE_OPTION) {
					File file = fileChooser.getSelectedFile();
					textFieldURl.setText(file.getAbsolutePath());
				}}
			
		});
		panel.add(btnUpdate);
		
		btn_updateMTK = new JButton("Ma trận kề");
		btn_updateMTK.setForeground(SystemColor.menu);
		btn_updateMTK.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btn_updateMTK.setBackground(SystemColor.textHighlight);
		btn_updateMTK.setBounds(621, 7, 133, 32);
		panel.add(btn_updateMTK);
		btn_updateMTK.addActionListener(ac);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(153, 255, 255));
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(50, 102, 800, 180);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblEdgeStrart = new JLabel("Từ đỉnh");
		lblEdgeStrart.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblEdgeStrart.setBounds(20, 10, 69, 32);
		panel_1.add(lblEdgeStrart);
		
		JLabel lblEdgeEnd = new JLabel("Đến đỉnh");	
		lblEdgeEnd.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblEdgeEnd.setBounds(20, 62, 69, 30);
		panel_1.add(lblEdgeEnd);
		
		textField_EdgeStart = new JTextField();
		textField_EdgeStart.setBounds(120, 12, 96, 30);
		panel_1.add(textField_EdgeStart);
		textField_EdgeStart.setColumns(10);
		
		textField_EdgeEnd = new JTextField();
		textField_EdgeEnd.setColumns(10);
		textField_EdgeEnd.setBounds(120, 63, 96, 30);
		panel_1.add(textField_EdgeEnd);
		
		btnAdd = new JButton("Thêm cạnh");
		btnAdd.setForeground(SystemColor.control);
		btnAdd.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnAdd.setBackground(SystemColor.textHighlight);
		btnAdd.setBounds(275, 10, 174, 32);
		panel_1.add(btnAdd);
		btnAdd.addActionListener(ac);

		btnRemove = new JButton("Xóa cạnh");
		btnRemove.setForeground(SystemColor.control);
		btnRemove.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnRemove.setBackground(SystemColor.textHighlight);
		btnRemove.setBounds(275, 52, 174, 32);
		panel_1.add(btnRemove);
		btnRemove.addActionListener(ac);

		
		btnAdd_trongSo = new JButton("Thêm cạnh có trọng số");
		btnAdd_trongSo.setForeground(SystemColor.control);
		btnAdd_trongSo.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnAdd_trongSo.setBackground(SystemColor.textHighlight);
		btnAdd_trongSo.setBounds(275, 94, 174, 32);
		panel_1.add(btnAdd_trongSo);
		
		btnAdd_trongSo.addActionListener(ac);
		
		btnEdgeAdd = new JButton("Thêm đỉnh");
		btnEdgeAdd.setForeground(SystemColor.control);
		btnEdgeAdd.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnEdgeAdd.setBackground(SystemColor.textHighlight);
		btnEdgeAdd.setBounds(578, 73, 174, 32);
		panel_1.add(btnEdgeAdd);
		
		btnEdgeAdd.addActionListener(ac);

		JLabel lblEdgeAdd = new JLabel("Tên đỉnh");
		lblEdgeAdd.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblEdgeAdd.setBounds(483, 10, 102, 32);
		panel_1.add(lblEdgeAdd);
		
		textField_NameVex = new JTextField();
		textField_NameVex.setColumns(10);
		textField_NameVex.setBounds(624, 12, 96, 30);
		panel_1.add(textField_NameVex);
		
		JLabel lbl_trongSo = new JLabel("Trọng Số");
		lbl_trongSo.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lbl_trongSo.setBounds(20, 113, 69, 30);
		panel_1.add(lbl_trongSo);
		
		textField_trongSo = new JTextField();
		textField_trongSo.setColumns(10);
		textField_trongSo.setBounds(120, 113, 96, 30);
		panel_1.add(textField_trongSo);
		
		btnDelete_trongSo = new JButton("Xóa cạnh có trọng số");
		btnDelete_trongSo.setForeground(SystemColor.menu);
		btnDelete_trongSo.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnDelete_trongSo.setBackground(SystemColor.textHighlight);
		btnDelete_trongSo.setBounds(275, 136, 174, 32);
		panel_1.add(btnDelete_trongSo);
		
		btnDelete_trongSo.addActionListener(ac);
		
		btnDeleteVex = new JButton("Xóa đỉnh");
		btnDeleteVex.setForeground(SystemColor.menu);
		btnDeleteVex.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnDeleteVex.setBackground(SystemColor.textHighlight);
		btnDeleteVex.setBounds(578, 118, 174, 32);
		panel_1.add(btnDeleteVex);
		btnDeleteVex.addActionListener(ac);
		
		textArea_console = new JTextArea();
		textArea_console.setBackground(new Color(255, 255, 255));
		textArea_console.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		textArea_console.setLineWrap(true);
		textArea_console.setForeground(SystemColor.textText);
		textArea_console.setBounds(50, 320, 290, 313);
		contentPane.add(textArea_console);
		
		textArea_mtk = new JTextArea();
		textArea_mtk.setBackground(new Color(255, 255, 255));
		textArea_mtk.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		textArea_mtk.setLineWrap(true);
		textArea_mtk.setForeground(SystemColor.textText);
		textArea_mtk.setBounds(350, 320, 280, 313);
		contentPane.add(textArea_mtk);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(640, 320, 225, 313);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lbl_giaiThuat = new JLabel("Các giải thuật");
		lbl_giaiThuat.setBounds(32, 10, 133, 30);
		panel_2.add(lbl_giaiThuat);
		lbl_giaiThuat.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		btnCheckLT = new JButton("Kiểm tra liên thông");
		btnCheckLT.setForeground(SystemColor.menu);
		btnCheckLT.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnCheckLT.setBackground(SystemColor.textHighlight);
		btnCheckLT.setBounds(10, 77, 205, 32);
		panel_2.add(btnCheckLT);
		btnCheckLT.addActionListener(ac);
		
		btn_findTree = new JButton("Tìm cây có trọng lượng nhỏ nhất");
		btn_findTree.setForeground(SystemColor.menu);
		btn_findTree.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btn_findTree.setBackground(SystemColor.textHighlight);
		btn_findTree.setBounds(10, 158, 205, 32);
		panel_2.add(btn_findTree);
		btn_findTree.addActionListener(ac);
		
		btnfindMin = new JButton("Đường đi ngắn nhất 2 đỉnh");
		btnfindMin.setForeground(SystemColor.menu);
		btnfindMin.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnfindMin.setBackground(SystemColor.textHighlight);
		btnfindMin.setBounds(10, 239, 205, 32);
		panel_2.add(btnfindMin);
		btnfindMin.addActionListener(ac);
	
		JLabel lbl_console = new JLabel("Console");
		lbl_console.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lbl_console.setBounds(50, 292, 88, 30);
		contentPane.add(lbl_console);
		
		JLabel lbl_mtk = new JLabel("Ma trận kề");
		lbl_mtk.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lbl_mtk.setBounds(350, 292, 119, 30);
		contentPane.add(lbl_mtk);
		
		JScrollPane scrollPane_console = new JScrollPane(textArea_console);
		scrollPane_console.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane_console.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_console.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_console.setBounds(50, 320, 290, 313);
		contentPane.add(scrollPane_console);
		
		scrollPane_mtk = new JScrollPane(textArea_mtk);
		scrollPane_mtk.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane_mtk.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_mtk.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_mtk.setBounds(360, 320, 269, 313);
		contentPane.add(scrollPane_mtk);
		
		
		
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View frame = new View();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
