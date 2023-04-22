package sugangsincheong;

import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionListener;
import valueObject.VGangjwa;

public class PSelectionPanel extends GangjwaContainer {

	private static final long serialVersionUID = 1L;

	private PHakgwaSelectionPanel pHakgwaSelectionPanel;
	private PGangjwaSelectioPanel pGangjwaSelectioPanel;
	public PSelectionPanel( ListSelectionListener listSelectionHandler){
		 this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));	
		

		this.pHakgwaSelectionPanel =new PHakgwaSelectionPanel(listSelectionHandler);
		this.add(this.pHakgwaSelectionPanel);
		
		JScrollPane scrollPane = new JScrollPane();
		this.pGangjwaSelectioPanel =new PGangjwaSelectioPanel();
		scrollPane.setViewportView(this.pGangjwaSelectioPanel);
		this.add(scrollPane);
		
	}
	public void intialize(PResultPanel pMiridamgiPanel, PResultPanel pSincheongPanel) {

		this.pHakgwaSelectionPanel.initialize();
		String hakgwaFileNmae = this.pHakgwaSelectionPanel.getFileNmae();
		this.pGangjwaSelectioPanel.initialize(hakgwaFileNmae,pMiridamgiPanel,pSincheongPanel);

	}
public void update(Object source) {
		String hakgwaFileName = this.pHakgwaSelectionPanel.update(source);
		this.pGangjwaSelectioPanel.update(hakgwaFileName);
	}
	



public Vector<VGangjwa> removeSelectedGangjwas() {
		return this.pGangjwaSelectioPanel.removeSelectedGangjwas();
	}

public Vector<VGangjwa> selectedscore(){
	return this.pGangjwaSelectioPanel.removeSelectedGangjwascore();
}
	
public void addGangjwas(Vector<VGangjwa> vSelectedGangjwas) {

		this.pGangjwaSelectioPanel.update();
	}

	
}
