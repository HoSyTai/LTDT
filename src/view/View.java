package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import controller.Controller;
import model.Graph;

import javax.swing.JTextArea;
import java.awt.Checkbox;

public class View extends JFrame {

	
//	public Graph model;
	public JPanel contentPane;
	public JTextField textField;
	public JButton btnUpdate;
	public JTextField textField_EdgeStart;
	public JTextField textField_EdgeEnd;
	public JTextField textField_EdgeAdd;
	public JButton btnAdd;
	public JButton btnRemove;
	public JButton btnAdd_trongSo;
	public JButton btnEdgeAdd;
	public JTextArea textArea_console;
	public JTextArea textArea_mtk;
	private JTextField textField_trongSo;
	private JButton btnDelete_trongSo;

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
		
		textField = new JTextField();
		textField.setBounds(171, 8, 280, 31);
		panel.add(textField);
		textField.setColumns(10);
		
		btnUpdate = new JButton("Cập nhật dữ liệu");
		btnUpdate.setBackground(UIManager.getColor("CheckBoxMenuItem.selectionBackground"));
		btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnUpdate.setBounds(550, 7, 174, 32);
		
		btnUpdate.addActionListener(ac);
		panel.add(btnUpdate);
		
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
		
		btnAdd.addActionListener(ac);
		btnAdd = new JButton("Thêm cạnh");
		btnAdd.setForeground(SystemColor.control);
		btnAdd.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnAdd.setBackground(SystemColor.textHighlight);
		btnAdd.setBounds(275, 10, 174, 32);
		panel_1.add(btnAdd);
		
		btnRemove.addActionListener(ac);
		btnRemove = new JButton("Xóa cạnh");
		btnRemove.setForeground(SystemColor.control);
		btnRemove.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnRemove.setBackground(SystemColor.textHighlight);
		btnRemove.setBounds(275, 52, 174, 32);
		panel_1.add(btnRemove);
		
		
		btnAdd_trongSo = new JButton("Thêm cạnh có trọng số");
		btnAdd_trongSo.setForeground(SystemColor.control);
		btnAdd_trongSo.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnAdd_trongSo.setBackground(SystemColor.textHighlight);
		btnAdd_trongSo.setBounds(275, 94, 174, 32);
		panel_1.add(btnAdd_trongSo);
		
		btnEdgeAdd.addActionListener(ac);
		btnEdgeAdd = new JButton("Thêm đỉnh");
		btnEdgeAdd.setForeground(SystemColor.control);
		btnEdgeAdd.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnEdgeAdd.setBackground(SystemColor.textHighlight);
		btnEdgeAdd.setBounds(578, 73, 174, 32);
		panel_1.add(btnEdgeAdd);
		
		JLabel lblEdgeAdd = new JLabel("Tên đỉnh");
		lblEdgeAdd.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblEdgeAdd.setBounds(483, 10, 102, 32);
		panel_1.add(lblEdgeAdd);
		
		textField_EdgeAdd = new JTextField();
		textField_EdgeAdd.setColumns(10);
		textField_EdgeAdd.setBounds(624, 12, 96, 30);
		panel_1.add(textField_EdgeAdd);
		
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
		
		JButton btnDeleteVex = new JButton("Xóa đỉnh");
		btnDeleteVex.setForeground(SystemColor.menu);
		btnDeleteVex.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnDeleteVex.setBackground(SystemColor.textHighlight);
		btnDeleteVex.setBounds(578, 118, 174, 32);
		panel_1.add(btnDeleteVex);
		
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
		
		JButton btnCheckLT = new JButton("Kiểm tra liên thông");
		btnCheckLT.setForeground(SystemColor.menu);
		btnCheckLT.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnCheckLT.setBackground(SystemColor.textHighlight);
		btnCheckLT.setBounds(10, 77, 205, 32);
		panel_2.add(btnCheckLT);
		
		JButton btn_findTree = new JButton("Tìm cây có trọng lượng nhỏ nhất");
		btn_findTree.setForeground(SystemColor.menu);
		btn_findTree.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btn_findTree.setBackground(SystemColor.textHighlight);
		btn_findTree.setBounds(10, 158, 205, 32);
		panel_2.add(btn_findTree);
		
		JLabel lbl_console = new JLabel("Console");
		lbl_console.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lbl_console.setBounds(50, 292, 88, 30);
		contentPane.add(lbl_console);
		
		JLabel lbl_mtk = new JLabel("Ma trận kề");
		lbl_mtk.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lbl_mtk.setBounds(350, 292, 119, 30);
		contentPane.add(lbl_mtk);
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