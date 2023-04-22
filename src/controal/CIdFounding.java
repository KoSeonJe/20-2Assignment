package controal;

import model.DataAccessObject;
import model.MLogin;
import model.MUser;
import valueObject.VLogin;
import valueObject.VUser;

public class CIdFounding {

	private VLogin vLogin;
	public VUser read(String nametext, String addresstext) {
		DataAccessObject dataAccessObject = new DataAccessObject();
		MLogin mLogin = (MLogin) dataAccessObject.getAModel("LoginInfo.txt", MLogin.class, nametext);
		if (mLogin != null) {
			this.vLogin = new VLogin();
			vLogin.setUserId(mLogin.getUserId());
			vLogin.setPassword(mLogin.getPassword());
			vLogin.setName( mLogin.getName());

		}
		if(this.vLogin !=null) {
		MUser mUser = (MUser) dataAccessObject.getAModel(vLogin.getUserId(), MUser.class, vLogin.getUserId());
		if (mUser != null) {
			VUser vUser = new VUser();
			vUser.setUserId(mUser.getUserId());
			vUser.setName(mUser.getName());
			vUser.setAddress(mUser.getAddress());
			if(nametext.contentEquals(vUser.getName()) && addresstext.equals(vUser.getAddress())) {
			return vUser;
			}else {
				return null;
			}
			
		}
		}
		
		return null;
	}

}
