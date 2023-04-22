package sugangsincheong;


import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import constants.Constants.EConfigurations;
import sugangsincheong.PSugangSincheongPanel.ActionHandler;
import valueObject.VGangjwa;
import valueObject.VUser;

public class PContentPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private VUser vUser;
	
	private ListSelectionListener listSelectionHandler;
	private PSelectionPanel pSelectionPanel;
	
	private PResultPanel pMiridamgiPanel;
	private PResultPanel PSincheongPanel;
	
	private ActionHandler actionHandler;
	private PControlPanel pControlPanel1;
	private PControlPanel pControlPanel2;

	
public PContentPanel(ActionHandler actionHandler) {
	    
	    this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
	
	    this.actionHandler =actionHandler;
	    
	    
	    this.listSelectionHandler= new ListSelectionHandler();
		this.pSelectionPanel =new PSelectionPanel(listSelectionHandler);
		this.add(this.pSelectionPanel);
		
		this.pControlPanel1 =new PControlPanel(this.actionHandler);
		this.add(this.pControlPanel1);
		
		this.pMiridamgiPanel =new PResultPanel();
		this.add(this.pMiridamgiPanel);
		
		this.pControlPanel2 =new PControlPanel(this.actionHandler);
		this.add(this.pControlPanel2);
		
		this.PSincheongPanel =new PResultPanel();
		this.add(this.PSincheongPanel);
	}
public void intialize(VUser vUser) {
    this.vUser = vUser;
	
	this.pMiridamgiPanel.intialize(this.vUser.getName() + EConfigurations.miridamgiFilePostfix.getText());
	this.PSincheongPanel.intialize(this.vUser.getName() + EConfigurations.sincheongFilePostfix.getText());
	
	this.pSelectionPanel.intialize(
			this.pMiridamgiPanel,
			this.PSincheongPanel
			
	);

	this.pControlPanel1.intialize();
	this.pControlPanel2.intialize();

	
}
public void finish() {
	this.PSincheongPanel.save(this.vUser.getName() + EConfigurations.sincheongFilePostfix.getText());
	this.pMiridamgiPanel.save(this.vUser.getName() + EConfigurations.miridamgiFilePostfix.getText());

}


public PResultPanel sincheong() {
	return this.PSincheongPanel; 
}

public PResultPanel Miridamgi() {
	return this.pMiridamgiPanel; 
}

public PControlPanel one() {
	return this.pControlPanel1;
}
public PControlPanel two() {
	return this.pControlPanel2;
}

public PSelectionPanel selection() {
	return this.pSelectionPanel;
}

public Vector<VGangjwa> getdata() {
	return this.PSincheongPanel.getGangjwas();
}

public Vector<VGangjwa> getscore(){

	return this.pMiridamgiPanel.removeSelectedGangjwascore();
}

public Vector<VGangjwa> getGangwjascore(){
	return this.pSelectionPanel.selectedscore();
}

///////////////////////////////////
//Selection Listener
///////////////////////////////////

public void update(Object source) {
	 pSelectionPanel.update(
			 source
			);

	}


public class ListSelectionHandler implements ListSelectionListener{
		public void valueChanged(ListSelectionEvent event) {
			update(event.getSource());
		}
	}

/////////////////////////////////////////
// actoin listener//
////////////////////////////////////
//private void moveGangjwas(GangjwaContainer source, GangjwaContainer target) {
//	  Vector<VGangjwa> vSelectedGangjwas = source.removeSelectedGangjwas();
//	  target.addGangjwas(vSelectedGangjwas);
//}
//
//
//
//public class ActionHandler implements ActionListener{
//	@Override
//	public void actionPerformed(ActionEvent e) {
//
//		Object source = e.getSource();
//
//		if(source.equals(pControlPanel1.getMoveRight())) {
//			moveGangjwas(pSelectionPanel, pMiridamgiPanel);
//			
//		}else if(source.equals(pControlPanel1.getMoveLeft())) {
//			moveGangjwas(pMiridamgiPanel, pSelectionPanel);
//			
//		}else if(source.equals(pControlPanel2.getMoveRight())) {
//			moveGangjwas(pMiridamgiPanel, PSincheongPanel);
//			
//		}else if(source.equals(pControlPanel2.getMoveLeft())) {
//			moveGangjwas(PSincheongPanel, pMiridamgiPanel);
//		}
//		
//	}
//	  
//  }


}
