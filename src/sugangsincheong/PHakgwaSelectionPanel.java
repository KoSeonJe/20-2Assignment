package sugangsincheong;


import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import constants.Constants.EPHakgwaSelectedPanel;
import controal.CDirectory;
import valueObject.VDirectory;

public class PHakgwaSelectionPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private PDirectory pCampus;
	private PDirectory pColleage;
	private PDirectory pHakgwa;

	private String filename;

	public PHakgwaSelectionPanel(ListSelectionListener listSelectionHandler){
		this.filename =EPHakgwaSelectedPanel.rootFileName.getText();
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		JScrollPane scrollpane;
		

		scrollpane = new JScrollPane();
		this.pCampus =new PDirectory(EPHakgwaSelectedPanel.campus.getText(),listSelectionHandler);
		scrollpane.setViewportView(this.pCampus);
		this.add(scrollpane);
		
		scrollpane = new JScrollPane();
		this.pColleage =new PDirectory(EPHakgwaSelectedPanel.college.getText(),listSelectionHandler);
		scrollpane.setViewportView(this.pColleage);
		this.add(scrollpane);

		
		scrollpane = new JScrollPane();
		this.pHakgwa =new PDirectory(EPHakgwaSelectedPanel.hakgwa.getText(),listSelectionHandler);
		scrollpane.setViewportView(this.pHakgwa);
		this.add(scrollpane);


	}
	public void initialize() {

		this.filename = this.pCampus.initialize(this.filename);
		this.filename= this.pColleage.initialize(this.filename);
		this.filename= this.pHakgwa.initialize(this.filename);
// 자기륾 만들기 전에 데이터를 가져와 버려서  먼저 자기를 모두 만든 후 데이터를 가져오는 구조로 바꾼 것.
	}
	public String getFileNmae() {
		// TODO Auto-generated method stub
		return this.filename;
	}

	

	private class PDirectory extends JTable {
		private static final long serialVersionUID = 1L;
		private CDirectory cDirectory;

		
		private DefaultTableModel tableModel;
		private Vector<VDirectory> vDirectories;
		private ListSelectionListener listSelectionHandler;
		public PDirectory(String title, ListSelectionListener listSelectionHandler) {
			// attribute
			this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			this.listSelectionHandler = listSelectionHandler;
			this.getSelectionModel().addListSelectionListener(this.listSelectionHandler);
			//data model
			Vector<String> header = new Vector<String>();
			header.addElement(title);
			this.tableModel = new DefaultTableModel(header, 0);
			this.setModel(tableModel);

		}
		
		
		public String initialize(String filename) {
			return this.getModelData(filename);
		}

		public String getModelData(String filename) {
			this.getSelectionModel().removeListSelectionListener(this.listSelectionHandler);
			this.cDirectory = new CDirectory();
			vDirectories = cDirectory.getData(filename);
			this.tableModel.setRowCount(0);
			for(VDirectory vDirectory : vDirectories) {
				Vector<String> row = new Vector<String>();
				row.add(vDirectory.getName());
				this.tableModel.addRow(row);
			}
			String selectedFilename = null;


			if (vDirectories.size()>0) {
				this.setRowSelectionInterval(0, 0);
				selectedFilename = vDirectories.get(0).getFilename();
			}
			this.getSelectionModel().addListSelectionListener(this.listSelectionHandler);
			return selectedFilename;
		}


		public String getSelectedFileName() {
			int row = this.getSelectedRow();
			String filename = null;
			filename = vDirectories.get(row).getFilename();
			return filename;
		}

	
	}


	public String update(Object source) {

		if(source.equals(this.pCampus.getSelectionModel())) {
			this.filename = this.pCampus.getSelectedFileName();
			this.filename = this.pColleage.getModelData(this.filename);
			this.filename = this.pHakgwa.getModelData(this.filename);
			
			
		}else if(source.equals(this.pColleage.getSelectionModel())) {
			this.filename = this.pColleage.getSelectedFileName();
			this.filename = this.pHakgwa.getModelData(this.filename);
			
			
			
		}else if(source.equals(this.pHakgwa.getSelectionModel())) {
			this.filename = this.pHakgwa.getSelectedFileName();
			
		}
		return filename;
	}



}
