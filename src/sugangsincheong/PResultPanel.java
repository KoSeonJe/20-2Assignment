package sugangsincheong;

import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import constants.Constants.EResultPanel;
import controal.CResult;
import valueObject.VGangjwa;

public class PResultPanel extends GangjwaContainer {

	private static final long serialVersionUID = 1L;

	private Vector<VGangjwa> vGangjwa;
	private JTable table;
	private DefaultTableModel tableModel;
	
	private int[] indices;
	public PResultPanel(){
		 this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));	

		this.table = new JTable();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(this.table);
		this.add(scrollPane);
		
		Vector<String> header = new Vector<String>();
		for(EResultPanel eResultPanel : EResultPanel.values()) {
			header.addElement(eResultPanel.getText());
		}
		this.tableModel = new DefaultTableModel(header,0);
		table.setModel(tableModel);
		
		this.indices = null;
	}

	public void intialize(String filename) {
		// TODO Auto-generated method stub
		CResult cResult = new CResult();
		this.vGangjwa =cResult.get(filename);
		this.updateTable();
	}
	public Vector<VGangjwa> getGangjwas() {
		// TODO Auto-generated method stub
		return this.vGangjwa;
	}
	
	public void save(String filename) {
		// TODO Auto-generated method stub
		CResult cResult = new CResult();
		cResult.save(filename,vGangjwa);
	}


	private void updateTable() {
		this.tableModel.setRowCount(0);
		for(VGangjwa vGangjwa : this.vGangjwa) {
			Vector<String> row = new Vector<String>();
			row.add(vGangjwa.getId());
			row.add(vGangjwa.getGangjwa());


			this.tableModel.addRow(row);

		}
		if(this.vGangjwa.size()>0) {
			table.setRowSelectionInterval(0, 0);
		}
		
	}
	public void addGangjwas(Vector<VGangjwa> vSelectedGangjwas) {
		this.vGangjwa.addAll(vSelectedGangjwas);		
		this.updateTable();

	}

	
	

	public Vector<VGangjwa> removeSelectedGangjwas() {
		Vector<VGangjwa> removedGangjwas = new Vector<VGangjwa>();
		int[] indices;
		if(this.indices != null) {
			 indices = this.indices;
			 this.indices = null;
		}else {
		indices = table.getSelectedRows();
		}
		for(int i= indices.length-1; i >= 0; i--) {
			VGangjwa removedGangjwa = this.vGangjwa.remove(indices[i]);
			removedGangjwas.add(removedGangjwa);
		}

		this.updateTable();
			return removedGangjwas;

	}
	
	public Vector<VGangjwa> removeSelectedGangjwascore() {
		Vector<VGangjwa> removedGangjwas = new Vector<VGangjwa>();
		this.indices = table.getSelectedRows();

		for(int i= indices.length-1; i >= 0; i--) {
			VGangjwa removedGangjwa = this.vGangjwa.get(indices[i]);
			removedGangjwas.add(removedGangjwa);
		}

		this.updateTable();

			return removedGangjwas;

	}

}
