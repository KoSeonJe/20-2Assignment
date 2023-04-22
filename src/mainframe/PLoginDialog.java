package mainframe;


import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import constants.Constants.ELoginDialog;
import controal.CLogin;
import controal.CUser;
import mainframe.Main.ActionHandler;
import valueObject.VLogin;
import valueObject.VUser;

public class PLoginDialog extends JDialog {


	private static final long serialVersionUID = 1L;

	private JLabel label;
	private JLabel nameLabel;
	private JTextField nameText;
	private JLabel passwordLbel;
	private JTextField passwordText;
	private JButton okbutton;
	private JButton cancelbutton;
	private JButton join;
	private JButton IdFounding;
	private JButton PasswordFounding;

	//control
	private CLogin cLogin;
	private CUser cUser;
	
	private PSaveUserData pSaveUserData;
	private PIdFounding pIdFounding;
	private PPasswordFounding pPasswordFounding;
	public PLoginDialog(ActionHandler actionHandler) {
		this.setSize(ELoginDialog.width.getInt(), ELoginDialog.height.getInt());
		
		this.setLayout(new GridLayout(5, 1)); 

		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		
		JPanel panel = new JPanel();
		this.label = new JLabel("안녕하세요 로그인 화면입니다");
		panel.add(this.label);
		this.add(panel);
		
		JPanel panel1 = new JPanel();
		this.nameLabel = new JLabel(ELoginDialog.nameLabel.getText());
		panel1.add(this.nameLabel);
		this.nameText = new JTextField();
		this.nameText.setColumns(ELoginDialog.sizeNameText.getInt());
		panel1.add(this.nameText);
		this.add(panel1);
		
		JPanel panel2 = new JPanel();
		this.passwordLbel = new JLabel(ELoginDialog.passwordLabel.getText());
		panel2.add(this.passwordLbel);
		this.passwordText = new JTextField();
		this.passwordText.setColumns(ELoginDialog.sizePasswordLabel.getInt());
		panel2.add(this.passwordText);
		this.add(panel2);

		
		JPanel panel3 = new JPanel();
		this.okbutton = new JButton(ELoginDialog.okButton.getText());
		this.okbutton.addActionListener(actionHandler);
		this.getRootPane().setDefaultButton(this.okbutton);
		panel3.add(this.okbutton);
		this.cancelbutton = new JButton(ELoginDialog.cancelButton.getText());
		this.cancelbutton.addActionListener(actionHandler);
		panel3.add(this.cancelbutton);
		this.add(panel3);
		
		JPanel panel4 = new JPanel();
		this.join = new JButton("회원가입");
		this.join.addActionListener(actionHandler);
		
	    this.IdFounding = new JButton("ID 찾기");
		this.PasswordFounding = new JButton("PassWord 찾기");
		this.IdFounding.addActionListener(actionHandler);
		this.PasswordFounding.addActionListener(actionHandler);
		
		panel4.add(this.join);
		panel4.add(this.IdFounding);
		panel4.add(this.PasswordFounding);
		this.add(panel4);

		this.cLogin = new CLogin();
		this.cUser = new CUser();
	}
	public void intialize() {
		this.setVisible(true);

		
	}
	public VUser validateUser(Object eventSource) {
		VUser vUser = null;
		if (eventSource.equals(this.okbutton)) {
			String userId = this.nameText.getText();
			String password = this.passwordText.getText();
			VLogin vLogin= new VLogin(); 
			vLogin.setUserId(userId);
			vLogin.setPassword(password);
			
			boolean bResult = cLogin.validateUser(vLogin);
			if (bResult) { // 로그인 성공
				vUser = cUser.getUser(userId);
				if(vUser ==null) {
					JOptionPane.showMessageDialog(this,  ELoginDialog.LoginFailed2.getText());
					//사용자 정보가 존재 하지 않는 것
				}
			} else {
				JOptionPane.showMessageDialog(this, ELoginDialog.loginFailed.getText());
				// 아이디와 패스워드가 틀림
			}
		} else if (eventSource.equals(this.cancelbutton)) {
			System.exit(0);
		}else if(eventSource.equals(this.join)) {
			this.pSaveUserData = new PSaveUserData();
			this.pSaveUserData.intialize();
		}else if(eventSource.equals(this.IdFounding)) {
			this.pIdFounding = new PIdFounding();
			this.pIdFounding.intialize();
		}else if(eventSource.equals(this.PasswordFounding)) {
			this.pPasswordFounding = new PPasswordFounding();
			this.pPasswordFounding.intialize();
		}
		return vUser;
	}
	
}
