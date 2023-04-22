package controal;

import model.DataAccessObject;
import model.MLogin;
import valueObject.VLogin;

public class CLogin {

	public boolean validateUser(VLogin vLogin) {
		boolean bResult = false;
		
		DataAccessObject dataAccessObject = new DataAccessObject();
		MLogin mLogin = (MLogin)dataAccessObject.getAModel("LoginInfo.txt",MLogin.class,vLogin.getUserId());
		if (mLogin != null) {
			if (vLogin.getPassword().contentEquals(mLogin.getPassword())) {
				bResult = true;
			} else {
				// password mismatch
				bResult = false;
			}
		} else {
			// no userId
			bResult = false;
		}		
		return bResult;
	}
}
