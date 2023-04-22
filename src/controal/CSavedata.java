package controal;

import java.util.Vector;

import model.DataAccessObject;
import model.MLogin;
import model.MModel;
import model.MUser;
import valueObject.VLogin;
import valueObject.VUser;

public class CSavedata {

	public CSavedata() {
		
	}
	public boolean save(VLogin vLogin, VUser vUser) {
		// TODO Auto-generated method stub
		Vector<VUser> vUsers = new  Vector<VUser>();
		vUsers.add(vUser);
		
		Vector<MModel> mUsers = new  Vector<MModel>();
		for(VUser vUser2 : vUsers) {
			MUser mUser = new MUser();
			
			mUser.setUserId(vUser2.getUserId());
			mUser.setName(vUser2.getName());
			mUser.setAddress(vUser2.getAddress());
		
			mUsers.add(mUser);
		}
		DataAccessObject DataAccessObject = new DataAccessObject();
		MUser mUser = (MUser)DataAccessObject.getAModel(vUser.getUserId(), MUser.class, vUser.getUserId());
		if(mUser ==null) {
		DataAccessObject.save(vUser.getUserId(), mUsers);
		}
		
		
		Vector<VLogin> vLogins = new  Vector<VLogin>();
		vLogins.add(vLogin);
	
		Vector<MModel> mLogins = new  Vector<MModel>();
		for(VLogin vLogin2 : vLogins) {
			MLogin mLogin = new MLogin();
			
			mLogin.setUserId(vLogin2.getUserId());
			mLogin.setPassword(vLogin2.getPassword());
			mLogin.setName(vLogin2.getName());

			
			mLogins.add(mLogin);
		}
		MLogin mLogin = (MLogin)DataAccessObject.getAModel("LoginInfo.txt", MLogin.class, vLogin.getUserId());
		if(mLogin == null) {
		DataAccessObject.save("LoginInfo.txt", mLogins);
		return true;
		}
		

		
		return false;
	}

}
