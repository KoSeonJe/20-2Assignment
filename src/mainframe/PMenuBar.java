package mainframe;

import javax.swing.JMenuBar;

public class PMenuBar extends JMenuBar {

	private static final long serialVersionUID = 1L;

	private PFileMenu pFileMenu;
	private PEditMenu pFileMenu2;
	public PMenuBar() {
		this.pFileMenu = new PFileMenu();
		this.add(this.pFileMenu);
		this.pFileMenu2 = new PEditMenu();
		this.add(this.pFileMenu2);
	}
	public void intialize() {
		// TODO Auto-generated method stub
		
	}
}
