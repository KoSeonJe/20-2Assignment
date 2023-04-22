package mainframe;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controal.CIdFounding;
import valueObject.VUser;


public class PIdFounding extends JFrame {


	private static final long serialVersionUID = 1L;
	
	private JLabel text;
	
	private JLabel nameLabel;
	private JTextField nameText;
	private JLabel AddressLabel;
	private JTextField AddressText;
	
	private JButton find;
	private JButton cancel;

	public PIdFounding() {
		this.setSize(400, 200);
		this.setVisible(true);
		this.setLayout(new GridLayout(4, 1)); 
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		JPanel panel1 = new JPanel();
		this.text = new JLabel("ã�� ID�� ������ �Է��ϼ���");
		panel1.add(this.text);
		this.add(panel1);
		
		JPanel panel2 = new JPanel();
		this.nameLabel = new JLabel("�̸�");
		panel2.add(this.nameLabel);
		this.nameText = new JTextField();
		this.nameText.setColumns(10);
		panel2.add(this.nameText);
		this.add(panel2);
		
		JPanel panel3 = new JPanel();
		this.AddressLabel = new JLabel("�ּ�");
		panel3.add(this.AddressLabel);
		this.AddressText = new JTextField();
		this.AddressText.setColumns(10);
		panel3.add(this.AddressText);
		this.add(panel3);
		
		JPanel panel4 = new JPanel();
		this.find = new JButton("FIND");
		this.cancel = new JButton("CANCEL");
		panel4.add(this.find);
		panel4.add(this.cancel);
		this.find.addActionListener(new ActionHandler());
		this.cancel.addActionListener(new ActionHandler());
		this.add(panel4);
		
		
	}
	public void intialize() {
		// TODO Auto-generated method stub
		
	}
	
	private void find(Object source) {
		// TODO Auto-generated method stub
		if(source.equals(this.find)) {
			CIdFounding cIdFounding = new CIdFounding();
			VUser vUser = cIdFounding.read(this.nameText.getText(), this.AddressText.getText());
			if(vUser != null) {
				JOptionPane.showMessageDialog(this, vUser.getName()+ "���� ���̵�� "+vUser.getUserId()+" "+ "�Դϴ�");
				this.dispose();
			}else {
				JOptionPane.showMessageDialog(this,"������ �����ϴ�");
	
			}
		}else if(source.equals(this.cancel)) {
			this.dispose();
		}
	}

	public class ActionHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
		
			find(event.getSource());
	}

	}
}
