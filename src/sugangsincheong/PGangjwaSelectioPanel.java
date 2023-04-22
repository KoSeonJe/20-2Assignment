package sugangsincheong;

import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import constants.Constants.EPGangjwaSelectedPanel;
import controal.CGangjwa;
import valueObject.VGangjwa;

public class PGangjwaSelectioPanel extends JTable {
	private static final long serialVersionUID = 1L;

	private DefaultTableModel tableModel ;
	private Vector<VGangjwa> vGangjwas;
	
	private String hakgwaFileName;
	private PResultPanel PMiridamgiPanel;
	private PResultPanel PSincheongPanel;
	
	private int[] indices;
	public PGangjwaSelectioPanel(){
		
		Vector<String> header = new Vector<String>();
		for(EPGangjwaSelectedPanel ePGangjwaSelectedPanel: EPGangjwaSelectedPanel.values()) {
			header.addElement(ePGangjwaSelectedPanel.getText());
		}

		tableModel = new DefaultTableModel(header, 0);
		this.setModel(tableModel);
		
		this.indices = null;
	}

	
	public void initialize(String hakgwaFileNmae, PResultPanel pMiridamgiPanel, PResultPanel pSincheongPanel) {
		this.PMiridamgiPanel=pMiridamgiPanel;
		this.PSincheongPanel=pSincheongPanel;
		
		this.update(hakgwaFileNmae);
	
	}
	public void update(String hakgwaFileName) {
		this.hakgwaFileName = hakgwaFileName;
		
		CGangjwa cGangjwa = new CGangjwa();
		vGangjwas = cGangjwa.getData2(this.hakgwaFileName);
		
		this.removeDublicatedGangjwas(this.PMiridamgiPanel.getGangjwas());
		 this.removeDublicatedGangjwas(this.PSincheongPanel.getGangjwas());
		 
	     this.updateTable();
		
	}
	public void update() {
		this.update(this.hakgwaFileName);
	}

	public Vector<VGangjwa> removeSelectedGangjwas() {
		Vector<VGangjwa> vSelectedGangjwas = new Vector<VGangjwa>();
		int[] indices;
		if(this.indices != null) {
			 indices = this.indices;
			 this.indices = null;
		}else {
		indices = this.getSelectedRows();
		}
		for(int i = indices.length - 1; i>=0; i--) {
			VGangjwa removedGangjwa = this.vGangjwas.remove(indices[i]);
			vSelectedGangjwas.add(removedGangjwa);
		}
		this.updateTable();
		return vSelectedGangjwas;
	}
	
	public Vector<VGangjwa> removeSelectedGangjwascore() {
		Vector<VGangjwa> removedGangjwas = new Vector<VGangjwa>();
	    this.indices = this.getSelectedRows();
		for(int i= indices.length-1; i >= 0; i--) {
			VGangjwa removedGangjwa = this.vGangjwas.get(indices[i]);
			removedGangjwas.add(removedGangjwa);
		}
		this.updateTable();

			return removedGangjwas;

	}
	
	
	public void removeDublicatedGangjwas(Vector<VGangjwa> vSelectedGangjwas) {

		for(VGangjwa vSelectedGangjwa : vSelectedGangjwas) {
			
		for(int i= this.vGangjwas.size()-1; i >= 0; i--) {
			if(this.vGangjwas.get(i).getId().equals(vSelectedGangjwa.getId())) {
			this.vGangjwas.remove(i);
			break;
			}
		}
		}
		this.updateTable();
 
	}
	
	private void updateTable() {
	
			tableModel.setNumRows(0);
		
			for(VGangjwa vGangjwa : vGangjwas) {
				Vector<String> row = new Vector<String>();
				row.add(vGangjwa.getId());
				row.add(vGangjwa.getGangjwa());
				row.add(vGangjwa.getName());
				row.add(vGangjwa.getScore());
				row.add(vGangjwa.getTime());

				this.tableModel.addRow(row);

			} 
			if(this.vGangjwas.size()>0) {
				this.setRowSelectionInterval(0, 0);
			}
			}

}
