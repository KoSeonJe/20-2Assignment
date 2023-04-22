package mainframe;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import constants.Constants;
import constants.Constants.EFileMenu;

public class PFileMenu extends JMenu {


	private static final long serialVersionUID = 1L;

	
	public PFileMenu() {
		this.setText(Constants.EMenuBar.eFile.getText());
		
//		JMenuItem newItem0 = new JMenuItem(Constants.EFileMenu.eNew.getText());
//		this.add(newItem0);
//		JMenuItem newItem1 = new JMenuItem(Constants.EFileMenu.eOpen.getText());
//		this.add(newItem1);
//		JMenuItem newItem2 = new JMenuItem(Constants.EFileMenu.eSave.getText());
//		this.add(newItem2);
//		JMenuItem newItem3 = new JMenuItem(Constants.EFileMenu.eSaveAs.getText());
//		this.add(newItem3);
//		JMenuItem newItem4 = new JMenuItem(Constants.EFileMenu.ePrint.getText());
//		this.add(newItem4);		
//		JMenuItem newItem5 = new JMenuItem(Constants.EFileMenu.eExit.getText());
//		this.add(newItem5);
		
		for(EFileMenu eFileMenu : EFileMenu.values()) {
			JMenuItem menuitem = new JMenuItem(eFileMenu.getText());
			this.add(menuitem);
		}
		
	}

}

