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
		GangjwaNumber("강자번호"),
		GangjwaName("강좌명");
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
		GangjwaNumber("강좌번호"),
		GangjwaName("강좌명"),
		GangjwaGyosu("담당교수"),
		HakgwaScore("학점"),
		Time("시간");
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
		campus("캠퍼스"),
		college("대학"),
		hakgwa("학과");
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
		nameLabel(" 아이디  "),
		sizeNameText("10"),
		passwordLabel(" 비밀번호 "),
		sizePasswordLabel("10"),
		okButton("ok"),
		cancelButton("cancel"),
		loginFailed("아이디나 비밀번호가 일치하지 않습니다."),
		LoginFailed2( "아이디와 비밀번호는 일치하나 사용자 정보가 존재하지 않습니다."),
		Loginwelcome( "안녕하세요 로그인 화면입니다"),
		userinfo( "회원가입"),
		idfound( "ID 찾기"),
		passwordfound( "Password 찾기");

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
		eFile("파일"),
		eEdit("편집");
		String text;
		EMenuBar(String text){
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
	}
	
	public enum EFileMenu{
		eNew("새로만들기"),
		eOpen("열기"),
		eSave("저장하기"),
		eSaveAs("다른 이름으로"),
		ePrint("프린트"),
		eExit("종료");
		String text;
		EFileMenu(String text){
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
	}
	public enum EEditMenu{
		eCopy("복사"),
		eCut("잘라내기"),
		ePaste("붙이기"),
		eDelet("삭제");
		
		String text;
		EEditMenu(String text){
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
	}
	public enum EIdFounding{
		elabel("찾을 ID의 정보를 입력하세요"),
		ename("이름"),
		eaddress("주소"),
		eok("FIND"),
		ecancel("CANCEL"),
		etext("정보가 없습니다");


		
		String text;
		EIdFounding(String text){
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
	}
	public enum EToolBar{
		elogout("로그아웃"),
		emclear("미리담기 비우기"),
		esclear("수강신청 비우기");


		
		String text;
		EToolBar(String text){
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
	}
	
	public enum ESaveUserdata{
		etext("사용할 ID와 PassWord 입력"),
		eid("ID"),
		epassword("PassWord"),
		etext2("개인정보 입력"),
		eidcheck("ID 확인"),
		ename("name"),
		eaddress("Address"),
		ejoin("JOIN"),
		ecancel("CANCEL"),
		etext3("중복된 아이디 입니다"),
		etext4("ID와 ID확인이 동일하지 않습니다.");


		
		String text;
		ESaveUserdata(String text){
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
	}
	
	public enum EPasswordFound{
		etext("찾을 password의 정보를 입력하세요"),
		eid("ID"),
		ename("이름"),
		eaddress("주소"),
		efind("FIND"),
		ecancel("CANCEL"),
		etext2("정보가 없습니다");


		
		String text;
		EPasswordFound(String text){
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
	}
}