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
import controal.CSavedata;
import valueObject.VLogin;
import valueObject.VUser;



public class PSaveUserData extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private JLabel Text;
	
	private JLabel userId;
	private JTextField userIdText;
	
	private JLabel passwordLabel;
	private JTextField passwordText;
	
	private JLabel Text2;
	
	private JLabel key;
	private JTextField keyText;
	
	private JLabel nameLabel;
	private JTextField nameText;
	
	private JLabel Address;
	private JTextField AddressText;
	
	private JButton join;
	private JButton cancle;

	public PSaveUserData() {
		
       this.setSize(300, 500);
		this.setVisible(true);
		this.setLayout(new GridLayout(9,1)); 
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		
		JPanel panel1 = new JPanel();
		this.Text = new JLabel("사용할 ID와 PassWord 입력");
		panel1.add(this.Text);
		this.add(panel1);
		
		JPanel panel2 = new JPanel();
		this.userId = new JLabel("ID");
		panel2.add(this.userId);
		this.userIdText = new JTextField();
		this.userIdText.setColumns(10);
		panel2.add(this.userIdText);
		this.add(panel2);
		
		JPanel panel3 = new JPanel();
		this.passwordLabel = new JLabel("PassWord");
		panel3.add(this.passwordLabel);
		this.passwordText = new JTextField();
		this.passwordText.setColumns(10);
		panel3.add(this.passwordText);
		this.add(panel3);
		
		JPanel panel4 = new JPanel();
		this.Text2 = new JLabel("개인정보 입력");
		panel4.add(this.Text2);
		this.add(panel4);
		
		JPanel panel5 = new JPanel();
		this.key = new JLabel("ID 확인");
		panel5.add(this.key);
		this.keyText = new JTextField();
		this.keyText.setColumns(10);
		panel5.add(this.keyText);
		this.add(panel5);
		
		JPanel panel6 = new JPanel();
		this.nameLabel = new JLabel("name");
		panel6.add(this.nameLabel);
		this.nameText = new JTextField();
		this.nameText.setColumns(10);
		panel6.add(this.nameText);
		this.add(panel6);
		
		JPanel panel7 = new JPanel();
		this.Address = new JLabel("Address");
		panel7.add(this.Address);
		this.AddressText = new JTextField();
		this.AddressText.setColumns(10);
		panel7.add(this.AddressText);
		this.add(panel7);
		
		JPanel panel8 = new JPanel();
		this.join = new JButton("JOIN");
		this.cancle = new JButton("CANCEL");
		panel8.add(this.join);
		panel8.add(this.cancle);
		this.join.addActionListener(new ActionHandler());
		this.cancle.addActionListener(new ActionHandler());
		this.add(panel8);
	}
	public void intialize() {
		
	}
	private void save(Object source) {

		if(source.equals(this.join)) {
			String userId = this.userIdText.getText();
			String password = this.passwordText.getText();
			String name2 = this.nameText.getText();
			VLogin vLogin = new VLogin();
			vLogin.setUserId(userId);
			vLogin.setPassword(password);
			vLogin.setName(name2);

			
			String key = this.keyText.getText();
			String name = this.nameText.getText();
			String address = this.AddressText.getText();
			VUser vUser = new VUser();
			vUser.setUserId(key);
			vUser.setName(name);
			vUser.setAddress(address);
			
			if(userId.contentEquals(key)) {
			CSavedata cSavedata = new CSavedata();
			boolean check =cSavedata.save(vLogin, vUser);
			if(check) {
				this.dispose();

			}else {
				JOptionPane.showMessageDialog(this,"중복된 아이디 입니다");

			}
			}else {
				JOptionPane.showMessageDialog(this,"ID와 ID확인이 동일하지 않습니다.");

			}
			
		
			

		}else if(source.equals(this.cancle)){
			this.dispose();
		}
		
	}
	
	public class ActionHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
		
			save(event.getSource());
	}
	}
}
