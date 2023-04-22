package mainframe;

import java.awt.BorderLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

import constants.Constants.EConfigurations;
import constants.Constants.EMainFrame;
import mainframe.Main.ActionHandler;
import sugangsincheong.PSugangSincheongPanel;
import valueObject.VUser;

public class PMainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
//components
	private PMenuBar pMenuBar;
	private PToolBar pToolBar;
	private PSugangSincheongPanel pSugangSincheongPanel;
	//utility
	private WindowsHandler windowsHandler;
//value object
	private VUser vUser;


	//constructor

	public PMainFrame(ActionHandler actionHandler) {
		//attributes
		this.setSize(EMainFrame.width.getInt(), EMainFrame.height.getInt());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		this.setLayout(new BorderLayout());

		//utility
		this.windowsHandler = new WindowsHandler();
		this.addWindowListener(this.windowsHandler);
		
		
		// components

		this.pMenuBar = new PMenuBar();
		this.setJMenuBar(this.pMenuBar);
		// menubar만 set을 붙이고 나머지는 add로 한다.

		this.pToolBar = new PToolBar(actionHandler);
		this.add(this.pToolBar, BorderLayout.NORTH);
		
		this.pSugangSincheongPanel = new PSugangSincheongPanel();
		this.add(this.pSugangSincheongPanel, BorderLayout.CENTER);
		
		
		

	}


	public void initialize(VUser vUser) {
		this.vUser =vUser;
		
		this.setVisible(true);
		this.pMenuBar.intialize();
		this.pToolBar.intialize(this.vUser);
		this.pSugangSincheongPanel.intialize(this.vUser);

	}
	public void mdelete() {
		this.pToolBar.mdelete();
		this.pSugangSincheongPanel.miridamgi().intialize(this.vUser.getName() + "M");;
		this.pSugangSincheongPanel.selection().addGangjwas(null);
	}
	public void sdelete() {
		this.pToolBar.sdelete();
		this.pSugangSincheongPanel.sincheong().intialize(this.vUser.getName() + "S");
		this.pSugangSincheongPanel.selection().addGangjwas(null);

	}
	
	public Object logout() {
		return this.pToolBar.logout();
	}
	
	public Object miridamgiremoveall() {
		return this.pToolBar.miridamgiremoveall();
		}
	
	public Object sincheongremoveall() {
		return this.pToolBar.sincheongremoveall();
	}
	public void finish() {
		this.pSugangSincheongPanel.finish();
	}
	
	private class WindowsHandler implements WindowListener{

		@Override
		public void windowOpened(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
			finish();
		}

		@Override
		public void windowClosed(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowIconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeiconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowActivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
