package constants;

public class Constants {
	
	public enum EConfigurations{
		miridamgiFilePostfix("M"),
		sincheongFilePostfix("S");
		private String text;
		private EConfigurations(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
		public int getInt() {
			return Integer.parseInt(text);
		}
	}
	public enum EResultPanel{
		GangjwaNumber("���ڹ�ȣ"),
		GangjwaName("���¸�");
		private String text;
		private EResultPanel(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
		public int getInt() {
			return Integer.parseInt(text);
		}
	}
	
	public enum EPGangjwaSelectedPanel{
		GangjwaNumber("���¹�ȣ"),
		GangjwaName("���¸�"),
		GangjwaGyosu("��米��"),
		HakgwaScore("����"),
		Time("�ð�");
		private String text;
		private EPGangjwaSelectedPanel(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
		public int getInt() {
			return Integer.parseInt(text);
		}
	}
	public enum EPHakgwaSelectedPanel{
		rootFileName("root"),
		campus("ķ�۽�"),
		college("����"),
		hakgwa("�а�");
		private String text;
		private EPHakgwaSelectedPanel(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
		public int getInt() {
			return Integer.parseInt(text);
		}
	}
	public enum ELoginDialog {
		width("400"),
		height("250"),
		nameLabel(" ���̵�  "),
		sizeNameText("10"),
		passwordLabel(" ��й�ȣ "),
		sizePasswordLabel("10"),
		okButton("ok"),
		cancelButton("cancel"),
		loginFailed("���̵� ��й�ȣ�� ��ġ���� �ʽ��ϴ�."),
		LoginFailed2( "���̵�� ��й�ȣ�� ��ġ�ϳ� ����� ������ �������� �ʽ��ϴ�."),
		Loginwelcome( "�ȳ��ϼ��� �α��� ȭ���Դϴ�"),
		userinfo( "ȸ������"),
		idfound( "ID ã��"),
		passwordfound( "Password ã��");

		private String text;
		private ELoginDialog(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
		public int getInt() {
			return Integer.parseInt(text);
		}
	}
    
	public enum EMainFrame {
		width("1000"),
		height("600");
		
		private String text;
		private EMainFrame(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
		public int getInt() {
			return Integer.parseInt(text);
		}
	}


	public enum EMenuBar {
		eFile("����"),
		eEdit("����");
		String text;
		EMenuBar(String text){
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
	}
	
	public enum EFileMenu{
		eNew("���θ����"),
		eOpen("����"),
		eSave("�����ϱ�"),
		eSaveAs("�ٸ� �̸�����"),
		ePrint("����Ʈ"),
		eExit("����");
		String text;
		EFileMenu(String text){
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
	}
	public enum EEditMenu{
		eCopy("����"),
		eCut("�߶󳻱�"),
		ePaste("���̱�"),
		eDelet("����");
		
		String text;
		EEditMenu(String text){
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
	}
	public enum EIdFounding{
		elabel("ã�� ID�� ������ �Է��ϼ���"),
		ename("�̸�"),
		eaddress("�ּ�"),
		eok("FIND"),
		ecancel("CANCEL"),
		etext("������ �����ϴ�");


		
		String text;
		EIdFounding(String text){
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
	}
	public enum EToolBar{
		elogout("�α׾ƿ�"),
		emclear("�̸���� ����"),
		esclear("������û ����");


		
		String text;
		EToolBar(String text){
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
	}
	
	public enum ESaveUserdata{
		etext("����� ID�� PassWord �Է�"),
		eid("ID"),
		epassword("PassWord"),
		etext2("�������� �Է�"),
		eidcheck("ID Ȯ��"),
		ename("name"),
		eaddress("Address"),
		ejoin("JOIN"),
		ecancel("CANCEL"),
		etext3("�ߺ��� ���̵� �Դϴ�"),
		etext4("ID�� IDȮ���� �������� �ʽ��ϴ�.");


		
		String text;
		ESaveUserdata(String text){
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
	}
	
	public enum EPasswordFound{
		etext("ã�� password�� ������ �Է��ϼ���"),
		eid("ID"),
		ename("�̸�"),
		eaddress("�ּ�"),
		efind("FIND"),
		ecancel("CANCEL"),
		etext2("������ �����ϴ�");


		
		String text;
		EPasswordFound(String text){
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
	}
}