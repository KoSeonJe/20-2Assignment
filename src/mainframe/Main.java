package mainframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import valueObject.VUser;

public class Main {

	private PLoginDialog pLoginDialog ;
	private PMainFrame pMainFrame;
	private boolean check;
	public Main() {
		pLoginDialog = new PLoginDialog(new ActionHandler());
		this.check = false;

	}
	private void initialize() {
		this.pLoginDialog.intialize();
	}
	private void validateUser(Object source) {
		VUser vUser = pLoginDialog.validateUser(source);
		if (vUser != null) {				
			this.pMainFrame = new PMainFrame(new ActionHandler());
			pMainFrame.initialize(vUser);
			check = true;
			this.pLoginDialog.dispose();

		}
		if(check) {
		  if(source.equals(this.pMainFrame.logout())){
			Main main = new Main();
			main.initialize();
			this.pMainFrame.finish();
			this.pMainFrame.dispose();
		}else if(source.equals(this.pMainFrame.miridamgiremoveall())) {
			this.pMainFrame.mdelete();
			

		}else if(source.equals(this.pMainFrame.sincheongremoveall())) {
			this.pMainFrame.sdelete();
			

		}
		}
		
		
	}		
	
	//Login Dialog "OK" and "Cancel" Button Event Handler
	public class ActionHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			validateUser(event.getSource());
	}
	}
	
	public static void main(String[] args) {
		Main main = new Main();
		main.initialize();
	
	}


}

