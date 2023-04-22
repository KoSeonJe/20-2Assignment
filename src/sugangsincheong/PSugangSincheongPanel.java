package sugangsincheong;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JPanel;

import valueObject.VGangjwa;
import valueObject.VUser;

public class PSugangSincheongPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private PHeaderPanel pHeaderPanel;
	private PContentPanel pContentPanel;
	private PFooterPanel pFooterPanel;
	
	private int total;
	
	public PSugangSincheongPanel() {
		this.setLayout(new BorderLayout());
		

		
		this.pHeaderPanel = new PHeaderPanel();
		this.add(this.pHeaderPanel, BorderLayout.NORTH);
		
		this.pContentPanel = new PContentPanel(new ActionHandler());
		this.add(this.pContentPanel, BorderLayout.CENTER);

		this.pFooterPanel = new PFooterPanel();
		this.add(this.pFooterPanel, BorderLayout.SOUTH);

	}


	public void intialize(VUser vUser) {

		this.pHeaderPanel.intialize(vUser);
		this.pContentPanel.intialize(vUser);
		this.pFooterPanel.intialize(this.pContentPanel.getdata());

	}
	
	public PResultPanel miridamgi() {
		return this.pContentPanel.Miridamgi();
	}
	public PResultPanel sincheong() {
		return this.pContentPanel.sincheong();
	}
	public PSelectionPanel selection() {
		return this.pContentPanel.selection();
	}



	public void finish() {
		// TODO Auto-generated method stub
		this.pContentPanel.finish();
	}
	
	//////////////////////////////////////////actionHandler
	public void getScore(Vector<VGangjwa> vGangjwas) {
		 int data = 0;
         this.total = 0;
			for (VGangjwa vGangjwa :vGangjwas) {
				data = Integer.parseInt(vGangjwa.getScore());
				total = total + data;
			}


	}
	private void moveGangjwas(GangjwaContainer source, GangjwaContainer target) {
				 if(target.equals(pContentPanel.sincheong())) {
				
				this.getScore(pContentPanel.getdata());
				int totalscore =this.total;
				this.getScore(pContentPanel.getscore());
				int removescore = this.total;
				this.getScore(pContentPanel.getGangwjascore());
				int gangjwascore = this.total;
				
				if(source.equals(pContentPanel.selection())) {
						if(totalscore + gangjwascore<=20) {
			Vector<VGangjwa> vSelectedGangjwas = source.removeSelectedGangjwas();
			  target.addGangjwas(vSelectedGangjwas);
						}
				}else {
					if(totalscore + removescore <=20) {
						Vector<VGangjwa> vSelectedGangjwas = source.removeSelectedGangjwas();
						  target.addGangjwas(vSelectedGangjwas);
									}
				}
				
				 }else {
					 Vector<VGangjwa> vSelectedGangjwas = source.removeSelectedGangjwas();
					  target.addGangjwas(vSelectedGangjwas);	 
				 }
			

	}



	public class ActionHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {

			Object source = e.getSource();

			if(source.equals(pContentPanel.one().getMoveRight())) {
				moveGangjwas(pContentPanel.selection(), pContentPanel.Miridamgi());
				
			}else if(source.equals(pContentPanel.one().getMoveLeft())) {
				moveGangjwas( pContentPanel.Miridamgi(), pContentPanel.selection());
				
			}else if(source.equals(pContentPanel.two().getMoveRight())) {
				moveGangjwas( pContentPanel.Miridamgi(), pContentPanel.sincheong());
				pFooterPanel.intialize(pContentPanel.getdata());
				
			}else if(source.equals(pContentPanel.two().getMoveLeft())) {
				moveGangjwas(pContentPanel.sincheong(),  pContentPanel.Miridamgi());
				pFooterPanel.intialize(pContentPanel.getdata());

			}else if(source.equals(pContentPanel.one().getMoveTooRight())) {
				moveGangjwas( pContentPanel.selection(), pContentPanel.sincheong());
				pFooterPanel.intialize(pContentPanel.getdata());

			}else if(source.equals(pContentPanel.one().getMoveTooLeft())) {
				moveGangjwas( pContentPanel.Miridamgi(), pContentPanel.selection());
				
			}else if(source.equals(pContentPanel.two().getMoveTooRight())) {
				
				moveGangjwas(pContentPanel.Miridamgi(),  pContentPanel.sincheong());
				pFooterPanel.intialize(pContentPanel.getdata());

			}else if(source.equals(pContentPanel.two().getMoveTooLeft())) {
				
				moveGangjwas(pContentPanel.sincheong(),  pContentPanel.selection());
				pFooterPanel.intialize(pContentPanel.getdata());

			}
			
		}
		  
	  }
}
