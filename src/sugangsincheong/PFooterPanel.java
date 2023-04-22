package sugangsincheong;

import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JPanel;

import valueObject.VGangjwa;

public class PFooterPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private JLabel label;
	private Vector<VGangjwa> data;
	private int total;
	private String totalvalue;
	public PFooterPanel() {
		this.label = new JLabel();
		this.add(this.label);
	}

	public void intialize(Vector<VGangjwa> vGangjwa) {
		// TODO Auto-generated method stub
		this.data = vGangjwa;
		organize();
		this.label.setText("신청된 학점: " + this.totalvalue+ "/20");
	}
	
	public void organize() {
		int data = 0;
		this.total = 0;
		for (VGangjwa vGangjwa : this.data) {
			data = Integer.parseInt(vGangjwa.getScore());
			total = total + data;
		}
		this.totalvalue = Integer.toString(this.total);
	}
	
}
