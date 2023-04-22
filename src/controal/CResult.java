package controal;

import java.util.Vector;

import model.DataAccessObject;
import model.MGangjwa;
import model.MModel;
import valueObject.VGangjwa;

public class CResult {

	public CResult() {
		
	}
	public void save(String filename, Vector<VGangjwa> vGangjwas) {
		Vector<MModel> mGangjwas = new  Vector<MModel>();
		for(VGangjwa vGangjwa : vGangjwas) {
			MGangjwa mGangjwa = new MGangjwa();
			
			mGangjwa.setId(vGangjwa.getId());
			mGangjwa.setGangjwa(vGangjwa.getGangjwa());
			mGangjwa.setName(vGangjwa.getName());
			mGangjwa.setScore(vGangjwa.getScore());
			mGangjwa.setTime(vGangjwa.getTime());
			
			mGangjwas.add(mGangjwa);
		}
		DataAccessObject DataAccessObject = new DataAccessObject();
		DataAccessObject.save(filename, mGangjwas);
	}
	public Vector<VGangjwa> get(String filename) {
		DataAccessObject DataAccessObject = new DataAccessObject();
		Vector<MModel> mModels = DataAccessObject.getModels(filename, MGangjwa.class);
		
		Vector<VGangjwa> vGangjwas = new Vector<VGangjwa>();
		for(MModel mModel : mModels) {
			
			MGangjwa mGangjwa = (MGangjwa) mModel;
			VGangjwa vGangjwa = new VGangjwa();
			
			vGangjwa.setId(mGangjwa.getId());
			vGangjwa.setGangjwa(mGangjwa.getGangjwa());
			vGangjwa.setName(mGangjwa.getName());
			vGangjwa.setScore(mGangjwa.getScore());
			vGangjwa.setTime(mGangjwa.getTime());
			
			vGangjwas.add(vGangjwa);
			
		}
		return vGangjwas;
	}

}
