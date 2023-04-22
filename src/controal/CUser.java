package controal;

import model.DataAccessObject;
import model.MUser;
import valueObject.VUser;

public class CUser {

	public VUser getUser(String userId) {
		// get MModel from DAO
		DataAccessObject dataAccessObject = new DataAccessObject();
		MUser mUser = (MUser) dataAccessObject.getAModel(userId, MUser.class, userId);
		
		//prepare ValueObject from Model
		VUser vUser = null;
		if (mUser != null) {
			vUser = new VUser();
			vUser.setUserId(mUser.getUserId());
			vUser.setName(mUser.getName());
			vUser.setAddress(mUser.getAddress());
			
		}
		return vUser;
	}

}
