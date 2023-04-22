package sugangsincheong;

import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class PControlPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private JButton moveRight;
	private JButton moveLeft;
	private JButton movetooRight;
	private JButton movetooLeft;
	public PControlPanel(ActionListener actionListener){
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.moveRight = new JButton(" >");
		this.moveRight.addActionListener(actionListener);
		this.add(this.moveRight);
		
		this.movetooRight = new JButton(">>");
		this.movetooRight.addActionListener(actionListener);
		this.add(this.movetooRight);
		
		JLabel label = new JLabel("\r");
		this.add(label);
		
		JLabel label2 = new JLabel("\r");
		this.add(label2);

		this.moveLeft = new JButton(" <");
		this.moveLeft.addActionListener(actionListener);
		this.add(this.moveLeft);
		
		this.movetooLeft = new JButton("<<");
		this.movetooLeft.addActionListener(actionListener);
		this.add(this.movetooLeft);

	}

	public void intialize() {
		// TODO Auto-generated method stub
		
	}

	public Object getMoveRight() {
		// TODO Auto-generated method stub
		return this.moveRight;
	}
	
	public Object getMoveTooRight() {
		// TODO Auto-generated method stub
		return this.movetooRight;
	}

	public Object getMoveLeft() {
		// TODO Auto-generated method stub
		return this.moveLeft;
	}
	
	public Object getMoveTooLeft() {
		// TODO Auto-generated method stub
		return this.movetooLeft;
	}
}
