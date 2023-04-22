package mainframe;


import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JToolBar;

import constants.Constants.EConfigurations;
import mainframe.Main.ActionHandler;
import valueObject.VUser;


public class PToolBar extends JToolBar {

	private static final long serialVersionUID = 1L;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	
	private VUser vUser;
	
	public PToolBar(ActionHandler actionHandler) {
	
		 this.button1 = new JButton("로그아웃");
		button1.addActionListener(actionHandler);
		this.add(button1);
		
		 this.button2 = new JButton("미리담기 비우기");
		 button2.addActionListener(actionHandler);
			this.add(button2);
			
		 this.button3 = new JButton("수강신청 비우기");
		 button3.addActionListener(actionHandler);
		 this.add(button3);
	}
	
	public Object logout() {
		return  this.button1;
	}
	
	public Object miridamgiremoveall() {
		return  this.button2;

	}
	public Object sincheongremoveall() {
		return  this.button3;

	}
	public void mdelete() {
		File file = new File("data/" + this.vUser.getName() + "M");
		file.delete();
		

	}
	public void sdelete() {
		File file = new File("data/" +this.vUser.getName() + "S");
		file.delete();
		
	}



	public void intialize(VUser vUser) {
		this.vUser = vUser;
	}
}
