package graphView;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MyTreeShow extends JFrame implements MouseListener {
	public JLabel label;
	int vex = 1;

	ArrayList<Point> location_vex = new ArrayList<>();
	JPanel p = new JPanel();
	private int srcVex_x;
	private int srcVex_y;
	private int endVex_x;
	private int endVex_y;
	public MyTreeShow() {
		p.setBounds(0, 0, 500, 500);
		p.setOpaque(true);
	    p.addMouseListener(this);
	
	    this.add(p);  
		this.setBounds(100, 100, 500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		// TODO Auto-generated method stub

	}
	public void paint(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
		g2D.drawLine(srcVex_x, srcVex_y, endVex_x, endVex_y);
	}
	
	public void putvaluevex() {
		String input = JOptionPane.showInputDialog("Trọng số của cạnh " + vex + "->"+ vex +" là: ");
        int weiEdges = Integer.valueOf(input);
	}
	


	// add vex
	private void addVexicon(int x, int y) {
		// TODO Auto-generated method stub
		ImageIcon icon = new ImageIcon(
				"C:\\Users\\TUAN\\Desktop\\new workspace\\thuchanh_ltdt\\thuc_hanh_tkhdt\\graph_gui\\Circle-icon.png");
		label = new JLabel();
		label.setText(vex+"");
		vex++;
		label.setIcon(icon);
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setBounds(x, y, 50, 50);
		label.setForeground(new Color(0x00FF00));
		p.add(label);	
		p.setLayout(null);

	}
	// Mouse Listener event

@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	// vẽ đỉnh có hình tròn, tâm là ngay chỗ click chuột
		int x = e.getX()-28;
		int y = e.getY()-22;
		this.addVexicon(x, y);
	// lưu trữ vị trí đỉnh mới tạo
//		Point point = new Point();
//		point.x = e.getX()-28;
//		point.y= e.getY()-22;
//		location_vex.add(vex, point);
		
//		System.out.println(x + " : "+y);
//		System.out.println(location_vex.get(vex-1));
		p.revalidate();
		p.repaint();

	}

//	@Override
//	public void mousePressed(MouseEvent e) {
//		// TODO Auto-generated method stub
//		// tạo một biết Point lưu vị trí đỉnh 
//		int centerSrcX = (int) test.getModel().getSource().getLocation().getX() + Vertex.R;
//		int centerSrcY = (int) test.getModel().getSource().getLocation().getY() + Vertex.R;
//		int centerDesX = (int) test.getModel().getDestination().getLocation().getX() + Vertex.R;
//		int centerDesY = (int) test.getModel().getDestination().getLocation().getY() + Vertex.R;
//
//		int adjacent = (int) Math.abs(test.getModel().getSource().getLocation().getX()
//				- this.getDestination().getLocation().getX());
//		int opposite = (int) Math.abs(test.getModel().getSource().getLocation().getY()
//				- test.getModel().getDestination().getLocation().getY());
//
//		int degree = (int) Math.toDegrees(Math.atan((double) opposite / adjacent));
//		int dx = (int) (24 * Math.cos(Math.toRadians(degree)));
//		int dy = (int) (24 * Math.sin(Math.toRadians(degree)));
//
//		int stSrcX = centerSrcX <= centerDesX ? centerSrcX + dx : centerSrcX - dx;
//		int stSrcY = centerSrcY <= centerDesY ? centerSrcY + dy : centerSrcY - dy;
//		int desDesX = (int) test.getModel().getDestination().getLocation().getX();
//		int desDesY = (int) test.getModel().getDestination().getLocation().getY();
//		double angle = Math.atan2(desDesY - stSrcY, desDesX - stSrcX);
//		int length = 15;
//		int arrowX1 = desDesX - (int) (length * Math.cos(angle - Math.PI / 6));
//		int arrowY1 = desDesY - (int) (length * Math.sin(angle - Math.PI / 6));
//		int arrowX2 = desDesX - (int) (length * Math.cos(angle + Math.PI / 6));
//		int arrowY2 = desDesY - (int) (length * Math.sin(angle + Math.PI / 6));
//
//		test.drawLine(g2d, test.getModel().getDefaultColor(), stSrcX, stSrcY, desDesX, desDesY, arrowX1, arrowY1, arrowX2, arrowY2, "");
//	}



	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
//		 endVex_x = e.getXOnScreen()- 497;
//		 endVex_y = e.getYOnScreen() - 216;
//		System.out.println(endVex_x + " " + endVex_y);
//		paint(getGraphics());

	}
	



	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) {
		new MyTreeShow();
	}
}
