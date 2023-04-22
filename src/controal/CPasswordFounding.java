package controal;

import model.DataAccessObject;
import model.MLogin;
import model.MUser;
import valueObject.VLogin;
import valueObject.VUser;

public class CPasswordFounding {

	private VLogin vLogin;
	public VLogin read(String id, String name, String address) {
		DataAccessObject dataAccessObject = new DataAccessObject();

		MLogin mLogin = (MLogin) dataAccessObject.getAModel("LoginInfo.txt", MLogin.class, id);
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
				if(id.contentEquals(vUser.getUserId())&& name.contentEquals(vUser.getName()) && address.equals(vUser.getAddress())) {
				return this.vLogin;
				}else {
					
					return null;
				}
				
			}
			}
		return null;
	}

}
