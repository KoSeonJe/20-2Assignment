package valueObject;

public class VObject {

	private String userId;
	private String name;
	private String address;
	public VObject(VUser vUser) {
		this.userId = vUser.getUserId();
		this.name = vUser.getName();
		this.address= vUser.getAddress();
				
		
	}
	public String getUserId() {
		return userId;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}
}
