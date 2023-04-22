package controal;

import java.util.Vector;

import model.DataAccessObject;
import model.MDirectory;
import model.MModel;
import valueObject.VDirectory;

public class CDirectory {

	public CDirectory(){
		
	}
	public Vector<VDirectory> getData(String filename) {

		DataAccessObject dataAccessObject = new DataAccessObject();
		Vector<MModel> mModels = dataAccessObject.getModels(filename, MDirectory.class);
		
		Vector<VDirectory> vDirectories = new Vector<VDirectory>();

		for(MModel mModel : mModels) {
			MDirectory mDirectory = (MDirectory) mModel;
			
			VDirectory vDirectory = new VDirectory();
			vDirectory.setName(mDirectory.getName());
			vDirectory.setFilename(mDirectory.getFilename());
			vDirectories.add(vDirectory);
		}
		
		return vDirectories;
	}

}
