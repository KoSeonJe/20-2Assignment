package mainframe;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import constants.Constants;
import constants.Constants.EEditMenu;

public class PEditMenu extends JMenu {

	private static final long serialVersionUID = 1L;

	public PEditMenu() {
		this.setText(Constants.EMenuBar.eEdit.getText());
		
//		JMenuItem newItem0 = new JMenuItem(Constants.EEditMenu.eCopy.getText());
//		this.add(newItem0);
//		JMenuItem newItem1 = new JMenuItem(Constants.EEditMenu.eCut.getText());
//		this.add(newItem1);
//		JMenuItem newItem2 = new JMenuItem(Constants.EEditMenu.ePaste.getText());
//		this.add(newItem2);
//		JMenuItem newItem3 = new JMenuItem(Constants.EEditMenu.eDelet.getText());
//		this.add(newItem3);
		
		for(EEditMenu editmenu : EEditMenu.values()) {
			JMenuItem menuitem = new JMenuItem(editmenu.getText());
			this.add(menuitem);
		}
	}
}
