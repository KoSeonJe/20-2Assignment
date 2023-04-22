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

import controal.CPasswordFounding;
import valueObject.VLogin;

public class PPasswordFounding extends JFrame {

	private static final long serialVersionUID = 1L;
	
    private JLabel text;
	
	private JLabel ID;
	private JTextField IDtext;
	private JLabel nameLabel;
	private JTextField nameText;
	private JLabel AddressLabel;
	private JTextField AddressText;
	
	private JButton find;
	private JButton cancel;
	
	
	public PPasswordFounding() {
		this.setSize(400, 250);
		this.setVisible(true);
		this.setLayout(new GridLayout(5, 1)); 
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		JPanel panel1 = new JPanel();
		this.text = new JLabel("찾을 ID의 정보를 입력하세요");
		panel1.add(this.text);
		this.add(panel1);
		
		JPanel panel = new JPanel();
		this.ID = new JLabel("ID");
		panel.add(this.ID);
		this.IDtext = new JTextField();
		this.IDtext.setColumns(10);
		panel.add(this.IDtext);
		this.add(panel);
		
		JPanel panel2 = new JPanel();
		this.nameLabel = new JLabel("이름");
		panel2.add(this.nameLabel);
		this.nameText = new JTextField();
		this.nameText.setColumns(10);
		panel2.add(this.nameText);
		this.add(panel2);
		
		JPanel panel3 = new JPanel();
		this.AddressLabel = new JLabel("주소");
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
			CPasswordFounding cPasswordFounding = new CPasswordFounding();
			VLogin vLogin = cPasswordFounding.read(this.IDtext.getText(),this.nameText.getText(), this.AddressText.getText());
			if(vLogin != null) {
				JOptionPane.showMessageDialog(this, vLogin.getName()+ "님의 비밀번호는 "+vLogin.getPassword()+" "+ "입니다");
				this.dispose();
			}else {
				JOptionPane.showMessageDialog(this,"정보가 없습니다");
	
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
